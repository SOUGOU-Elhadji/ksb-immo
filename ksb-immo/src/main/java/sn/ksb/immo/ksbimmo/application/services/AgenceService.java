package sn.ksb.immo.ksbimmo.application.services;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sn.ksb.immo.ksbimmo.application.dtos.AgenceDto;
import sn.ksb.immo.ksbimmo.application.models.Role;
import sn.ksb.immo.ksbimmo.application.models.Agence;
import sn.ksb.immo.ksbimmo.application.models.Employee;
import sn.ksb.immo.ksbimmo.application.repositories.AgenceRepo;
import sn.ksb.immo.ksbimmo.application.repositories.RoleRepo;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class AgenceService {
    private final RoleRepo roleRepo;

    private final AgenceRepo agenceRepo;

    private final ModelMapper mapper;

    public AgenceService(AgenceRepo agenceRepo, ModelMapper mapper,
                         RoleRepo roleRepo) {
        this.agenceRepo = agenceRepo;
        this.mapper = mapper;
        this.roleRepo = roleRepo;
    }

    //récupérer toutes les agences qui ne sont pas supprimées
    public List<AgenceDto> getAllAgences() {
        //log entrée dans la méthode getAllAgences du service AgenceService
        log.info("Entrée dans la méthode getAllAgences du service AgenceService");
        //initialisation de la liste des agences
        List<AgenceDto> agencesDto = new ArrayList<>();
        //try catch pour récupérer les agences
        try {
            //récupération des agences
            List<Agence> agences = agenceRepo.findAll();
            //conversion des agences en agencesDto
            for (Agence agence : agences) {
                if (agence != null) {
                    agencesDto.add(mapper.map(agence, AgenceDto.class));
                }
            }
            //log récupération des agences
            log.info("Récupération des agences");
        } catch (Exception e) {
            //log erreur récupération des agences
            log.error("Erreur lors de la récupération des agences: {}", e.getMessage());
        }

        //si la liste est vide
        if (agencesDto.isEmpty()) {
            //log aucune agence trouvée dans la base de données
            log.error("Aucune agence trouvée dans la base de données");
        }
        //log sortie de la méthode getAllAgences du service AgenceService
        log.info("Sortie de la méthode getAllAgences du service AgenceService");
        //retourner la liste des agences
        return agencesDto;
    }

    //récupérer une agence par son id
    public AgenceDto getAgenceById(String uuid) {
        //log entrée dans la méthode getAgenceById du service AgenceService
        log.info("Entrée dans la méthode getAgenceById du service AgenceService");
        //initialisation de l'agence
        Agence agence = null;
        //log uuid
        log.info("Paramètre uuid : " + uuid);
        //try catch pour récupérer l'agence
        try {
            //récupération de l'agence
            agence = agenceRepo.findById(UUID.fromString(uuid)).orElse(null);
            //log récupération de l'agence
            log.info("Récupération de l'agence");
        } catch (Exception e) {
            //log erreur récupération de l'agence
            log.error("Erreur lors de la récupération de l'agence");
        }
        //si l'agence est null
        if (agence == null) {
            //log agence non trouvée dans la base de données
            log.error("Agence non trouvée dans la base de données");
        }
        //log sortie de la méthode getAgenceById du service AgenceService
        log.info("Sortie de la méthode getAgenceById du service AgenceService");
        //retourner l'agence
        return mapper.map(agence, AgenceDto.class);
    }

    //ajouter une agence
    public AgenceDto addAgence(AgenceDto dto) {
        //log entrée dans la méthode addAgence du service AgenceService
        log.info("Entrée dans la méthode addAgence du service AgenceService");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String date = formatter.format(new Date());
        dto.setDateCreation(date);
        Agence agence = mapper.map(dto, Agence.class);
        //try catch pour ajouter l'agence
        try {
            //ajouter l'agence a la liste des employés
            for (Employee employee : agence.getEmployees()) {
                employee.setUsername(employee.getEmail());
                employee.setPassword(employee.getPrenom().toLowerCase()+employee.getNom().toLowerCase());
                employee.generateMatricule();
                employee.setAgence(agence);
                employee.getRoles().add(roleRepo.findByName("Agent"));
                if (employee.getManager()) {
                    employee.getRoles().add(roleRepo.findByName("Manager"));
                }
            }
            //ajout de l'agence
            agence = agenceRepo.save(agence);
            //log ajout de l'agence
            log.info("Ajout de l'agence");
        } catch (Exception e) {
            //log erreur ajout de l'agence
            log.error("Erreur lors de l'ajout de l'agence: {}", e.getMessage());
        }
        //si l'id de l'agence est null
        if (agence.getId() == null) {
            //log agence non ajoutée dans la base de données
            log.error("Agence non ajoutée dans la base de données");
        }
        //log sortie de la méthode addAgence du service AgenceService
        log.info("Sortie de la méthode addAgence du service AgenceService");
        //retourner l'agence
        return mapper.map(agence, AgenceDto.class);
    }

    //modifier une agence
    public AgenceDto updateAgence(AgenceDto dto) {
        //log entrée dans la méthode updateAgence du service AgenceService
        log.info("Entrée dans la méthode updateAgence du service AgenceService");
        //try catch pour modifier l'agence
        Agence agence = null;
        try {
            //récupération de l'agence par son id
            agence = agenceRepo.findById(UUID.fromString(dto.getId())).orElse(null);
            //si l'agence est null
            if (agence == null) {
                //log agence non trouvée dans la base de données
                log.error("Agence non trouvée dans la base de données");
                return dto;
            }
            //modification de l'agence
            agence.setNom(dto.getNom());
            agence.setAdresse(dto.getAdresse());
            agence.setTelephone(dto.getTelephone());
            agence.setRegion(dto.getRegion());
            agence.setDepartement(dto.getDepartement());
            agence = agenceRepo.save(agence);
            //log modification de l'agence
            log.info("Modification de l'agence");
        } catch (Exception e) {
            //log erreur modification de l'agence
            log.error("Erreur lors de la modification de l'agence");
        }
        //si l'id de l'agence est null
        if (agence == null || agence.getId() != UUID.fromString(dto.getId())) {
            //log agence non modifiée dans la base de données
            log.error("Agence non modifiée dans la base de données");
        }
        //log sortie de la méthode updateAgence du service AgenceService
        log.info("Sortie de la méthode updateAgence du service AgenceService");
        //retourner l'agence
        return mapper.map(agence, AgenceDto.class);
    }

    //supprimer une agence
    public Boolean deleteAgence(String id) {
        //log entrée dans la méthode deleteAgence du service AgenceService
        log.info("Entrée dans la méthode deleteAgence du service AgenceService");
        //initialisation de la variable de retour
        Boolean isDeleted = true;
        //log id
        log.info("Paramètre id : " + id);
        //try catch pour supprimer l'agence
        try {
            Agence agence = agenceRepo.findById(UUID.fromString(id)).orElse(null);
            //si agence différent de null
            if (agence != null) {
                //supprimer l'agence
                agenceRepo.delete(agence);
                //log suppression de l'agence
                log.info("Suppression de l'agence");
                //modifier la variable de retour
                isDeleted = agenceRepo.findById(UUID.fromString(id)).isPresent();
            }
        } catch (Exception e) {
            //log erreur suppression de l'agence
            log.error("Erreur lors de la suppression de l'agence");
        }
        //log sortie de la méthode deleteAgence du service AgenceService
        log.info("Sortie de la méthode deleteAgence du service AgenceService");
        //retourner la variable de retour
        return isDeleted;
    }

    //récupérer les agences par région
    public List<AgenceDto> getAgencesByRegion(String region) {
        //log entrée dans la méthode getAgencesByRegion du service AgenceService
        log.info("Entrée dans la méthode getAgencesByRegion du service AgenceService");
        //initialisation de la liste des agences
        List<AgenceDto> agencesDto = new ArrayList<>();
        //log region
        log.info("Paramètre region : " + region);
        //try catch pour récupérer les agences
        try {
            //récupération des agences
            List<Agence> agences = agenceRepo.findByRegion(region);
            agencesDto = agences.stream().map(agence -> mapper.map(agence, AgenceDto.class)).collect(Collectors.toList());
            //log récupération des agences
            log.info("Récupération des agences");
        } catch (Exception e) {
            //log erreur récupération des agences
            log.error("Erreur lors de la récupération des agences");
        }
        //si la liste des agences est vide
        if (agencesDto.isEmpty()) {
            //log agences non trouvées dans la base de données
            log.error("Agences non trouvées dans la base de données");
        }
        //log sortie de la méthode getAgencesByRegion du service AgenceService
        log.info("Sortie de la méthode getAgencesByRegion du service AgenceService");
        //retourner la liste des agences
        return agencesDto;
    }

    //récupérer les agences par région et département
    public List<AgenceDto> getAgencesByRegionAndDepartement(String region, String departement) {
        //log entrée dans la méthode getAgencesByRegionAndDepartement du service AgenceService
        log.info("Entrée dans la méthode getAgencesByRegionAndDepartement du service AgenceService");
        //initialisation de la liste des agences
        List<AgenceDto> agencesDto = new ArrayList<>();
        //log region
        log.info("Paramètre region : " + region);
        //log departement
        log.info("Paramètre departement : " + departement);
        //try catch pour récupérer les agences
        try {
            //récupération des agences
            List<Agence> agences = agenceRepo.findByRegionAndDepartement(region, departement);
            agencesDto = agences.stream().map(agence -> mapper.map(agence, AgenceDto.class)).collect(Collectors.toList());
            //log récupération des agences
            log.info("Récupération des agences");
        } catch (Exception e) {
            //log erreur récupération des agences
            log.error("Erreur lors de la récupération des agences");
        }
        //si la liste des agences est vide
        if (agencesDto.isEmpty()) {
            //log agences non trouvées dans la base de données
            log.error("Agences non trouvées dans la base de données");
        }
        //log sortie de la méthode getAgencesByRegionAndDepartement du service AgenceService
        log.info("Sortie de la méthode getAgencesByRegionAndDepartement du service AgenceService");
        //retourner la liste des agences
        return agencesDto;
    }

}
