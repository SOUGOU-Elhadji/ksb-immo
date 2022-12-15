package sn.ksb.immo.ksbimmo.application.services;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sn.ksb.immo.ksbimmo.application.dtos.ProprieteDto;
import sn.ksb.immo.ksbimmo.application.models.Agence;
import sn.ksb.immo.ksbimmo.application.models.Proprietaire;
import sn.ksb.immo.ksbimmo.application.models.Propriete;
import sn.ksb.immo.ksbimmo.application.repositories.AgenceRepo;
import sn.ksb.immo.ksbimmo.application.repositories.ProprietaireRepo;
import sn.ksb.immo.ksbimmo.application.repositories.ProprieteRepo;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class ProprieteService {

    private final ProprieteRepo proprieteRepo;

    private final ProprietaireRepo proprietaireRepo;

    private final AgenceRepo agenceRepo;

    private final ModelMapper mapper;

    public ProprieteService(ProprieteRepo proprieteRepo, ProprietaireRepo proprietaireRepo, AgenceRepo agenceRepo, ModelMapper mapper) {
        this.proprieteRepo = proprieteRepo;
        this.proprietaireRepo = proprietaireRepo;
        this.agenceRepo = agenceRepo;
        this.mapper = mapper;
    }

    //récupérer les propriétés d'une agence
    public List<ProprieteDto> getProprietesByAgence(String agenceId) {
        //log entrée dans la méthode getProprietesByAgence du service ProprieteService
        log.info("Entrée dans la méthode getProprietesByAgence du service ProprieteService");
        //initialisation de la liste des propriétés
        List<ProprieteDto> proprietes = new ArrayList<>();
        //try catch pour récupérer les propriétés
        try {
            //récupération des propriétés
            List<Propriete> proprietesList = proprieteRepo.findByAgence_Id(UUID.fromString(agenceId));
            //si la liste n'est pas vide la mapper
            if (!proprietesList.isEmpty()) {
                proprietes = proprietesList.stream().map(propriete -> mapper.map(propriete, ProprieteDto.class)).collect(Collectors.toList());
            }
            //log récupération des propriétés
            log.info("Récupération des propriétés");
        } catch (Exception e) {
            //log erreur récupération des propriétés
            log.error("Erreur lors de la récupération des propriétés");
        }
        //si la liste est vide
        if (proprietes.isEmpty()) {
            //log aucune propriété trouvée dans la base de données
            log.error("Aucune propriété trouvée dans la base de données pour l'agence d'id : {}" , agenceId);
        }
        //log sortie de la méthode getProprietesByAgence du service ProprieteService
        log.info("Sortie de la méthode getProprietesByAgence du service ProprieteService");
        //retourner la liste des propriétés
        return proprietes;
    }

    //récupérer les propriétés d'un propriétaire
    public List<ProprieteDto> getProprietesByProprietaire(String proprietaireId) {
        //log entrée dans la méthode getProprietesByProprietaire du service ProprieteService
        log.info("Entrée dans la méthode getProprietesByProprietaire du service ProprieteService");
        //initialisation de la liste des propriétés
        List<ProprieteDto> proprietes = new ArrayList<>();
        //try catch pour récupérer les propriétés
        try {
            //récupération des propriétés
            List<Propriete> proprietesList = proprieteRepo.findByProprietaire_Id(UUID.fromString(proprietaireId));
            //si la liste n'est pas vide la mapper
            if (!proprietesList.isEmpty()) {
                proprietes = proprietesList.stream().map(propriete -> mapper.map(propriete, ProprieteDto.class)).collect(Collectors.toList());
            }
            //log récupération des propriétés
            log.info("Récupération des propriétés");
        } catch (Exception e) {
            //log erreur récupération des propriétés
            log.error("Erreur lors de la récupération des propriétés");
        }
        //si la liste est vide
        if (proprietes.isEmpty()) {
            //log aucune propriété trouvée dans la base de données
            log.error("Aucune propriété trouvée dans la base de données pour le propriétaire d'id : {}" , proprietaireId);
        }
        //log sortie de la méthode getProprietesByProprietaire du service ProprieteService
        log.info("Sortie de la méthode getProprietesByProprietaire du service ProprieteService");
        //retourner la liste des propriétés
        return proprietes;
    }

    //récupérer une propriété par son id
    public ProprieteDto getProprieteById(String proprieteId) {
        //log entrée dans la méthode getProprieteById du service ProprieteService
        log.info("Entrée dans la méthode getProprieteById du service ProprieteService");
        //initialisation de la propriété
        ProprieteDto propriete = null;
        //try catch pour récupérer la propriété
        try {
            //récupération de la propriété dans un optional
            Optional<Propriete> proprieteOptional = proprieteRepo.findById(UUID.fromString(proprieteId));
            //si la propriété est présente la mapper
            if (proprieteOptional.isPresent()) {
                propriete = mapper.map(proprieteOptional.get(), ProprieteDto.class);
            }else {
                //log aucune propriété trouvée dans la base de données
                log.error("Aucune propriété trouvée dans la base de données pour l'id : {}" , proprieteId);
            }
            //log récupération de la propriété
            log.info("Récupération de la propriété");
        } catch (Exception e) {
            //log erreur récupération de la propriété
            log.error("Erreur lors de la récupération de la propriété");
        }
        //log sortie de la méthode getProprieteById du service ProprieteService
        log.info("Sortie de la méthode getProprieteById du service ProprieteService");
        //retourner la propriété
        return propriete;
    }

    //ajouter une propriété
    public ProprieteDto addPropriete(ProprieteDto propriete) {
        //log entrée dans la méthode addPropriete du service ProprieteService
        log.info("Entrée dans la méthode addPropriete du service ProprieteService");
        //try catch pour ajouter la propriété
        ProprieteDto proprieteToSave = null;
        try {
            //mapper la propriété
            Propriete proprieteEntity = mapper.map(propriete, Propriete.class);
            //récupérer l'agence
            Agence agence = agenceRepo.findById(UUID.fromString(propriete.getAgenceId())).orElse(null);
            if (agence == null) {
                //log aucune agence trouvée dans la base de données
                log.error("Aucune agence trouvée dans la base de données pour l'id : {}" , propriete.getAgenceId());
                return null;
            }
            //récupérer le propriétaire
            Proprietaire proprietaire = proprietaireRepo.findById(UUID.fromString(propriete.getProprietaireId())).orElse(null);
            if (proprietaire == null) {
                //log aucun propriétaire trouvé dans la base de données
                log.error("Aucun propriétaire trouvé dans la base de données pour l'id : {}" , propriete.getProprietaireId());
                return null;
            }
            proprieteEntity.setAgence(agence);
            proprieteEntity.setProprietaire(proprietaire);
            //ajouter la propriété
            proprieteToSave = mapper.map(proprieteRepo.save(proprieteEntity), ProprieteDto.class);
        } catch (Exception e) {
            //log erreur ajout de la propriété
            log.error("Erreur lors de l'ajout de la propriété");
        }
        if (proprieteToSave != null && proprieteToSave.getId() != null) {
            //log enregistrement de la propriété avec l'id
            log.info("Enregistrement de la propriété avec l'id : {}" , proprieteToSave.getId());
        }
        //log sortie de la méthode addPropriete du service ProprieteService
        log.info("Sortie de la méthode addPropriete du service ProprieteService");
        //retourner la propriété
        return proprieteToSave;
    }

    //modifier une propriété
    public ProprieteDto updatePropriete(ProprieteDto dto) {
        //log entrée dans la méthode updatePropriete du service ProprieteService
        log.info("Entrée dans la méthode updatePropriete du service ProprieteService");
        ProprieteDto propriete = null;
        try {
            //récupérer la propriété
            Propriete proprieteEntity = proprieteRepo.findById(UUID.fromString(dto.getId())).orElse(null);
            //si la propriété n'est pas null
            if (proprieteEntity != null) {
                //mapper la propriété
                Propriete proprieteToUpdate = mapper.map(dto, Propriete.class);
                //récupérer l'agence
                Agence agence = agenceRepo.findById(UUID.fromString(dto.getAgenceId())).orElse(null);
                if (agence == null) {
                    //log aucune agence trouvée dans la base de données
                    log.error("Aucune agence trouvée dans la base de données pour l'id : {}" , dto.getAgenceId());
                    return null;
                }
                //récupérer le propriétaire
                Proprietaire proprietaire = proprietaireRepo.findById(UUID.fromString(dto.getProprietaireId())).orElse(null);
                if (proprietaire == null) {
                    //log aucun propriétaire trouvé dans la base de données
                    log.error("Aucun propriétaire trouvé dans la base de données pour l'id : {}" , dto.getProprietaireId());
                    return null;
                }
                proprieteToUpdate.setAgence(agence);
                proprieteToUpdate.setProprietaire(proprietaire);
                //modifier la propriété
                propriete = mapper.map(proprieteRepo.save(proprieteToUpdate), ProprieteDto.class);
            }
            else {
                //log aucune propriété trouvée dans la base de données
                log.error("Aucune propriété trouvée dans la base de données pour l'id : {}" , dto.getId());
            }
        } catch (Exception e) {
            //log erreur modification de la propriété
            log.error("Erreur lors de la modification de la propriété");
        }
        if (propriete != null && propriete.getId() != null) {
            //log modification de la propriété avec l'id
            log.info("Modification de la propriété avec l'id : {}" , propriete.getId());
        }
        //log sortie de la méthode updatePropriete du service ProprieteService
        log.info("Sortie de la méthode updatePropriete du service ProprieteService");
        //retourner la propriété
        return propriete;
    }

    //supprimer une propriété
    public void deletePropriete(String proprieteId) {
        //log entrée dans la méthode deletePropriete du service ProprieteService
        log.info("Entrée dans la méthode deletePropriete du service ProprieteService");
        //try catch pour supprimer la propriété
        try {
            //supprimer la propriété
            proprieteRepo.deleteById(UUID.fromString(proprieteId));
            //log suppression de la propriété
            log.info("Suppression de la propriété");
        } catch (Exception e) {
            //log erreur suppression de la propriété
            log.error("Erreur lors de la suppression de la propriété");
        }
        //log sortie de la méthode deletePropriete du service ProprieteService
        log.info("Sortie de la méthode deletePropriete du service ProprieteService");
    }

    //récupérer propriété par status
    public List<ProprieteDto> getProprieteByStatus(Boolean status) {
        //log entrée dans la méthode getProprieteByStatus du service ProprieteService
        log.info("Entrée dans la méthode getProprieteByStatus du service ProprieteService");
        List<ProprieteDto> proprieteList = null;
        try {
            //récupérer la liste des propriétés par status
            List<Propriete> proprieteEntityList = proprieteRepo.findByStatus(status);
            //si la liste des propriétés n'est pas null la mapper
            if (proprieteEntityList != null) {
                proprieteList = proprieteEntityList.stream().map(propriete -> mapper.map(propriete, ProprieteDto.class)).collect(Collectors.toList());
            }
        } catch (Exception e) {
            //log erreur récupération de la liste des propriétés par status
            log.error("Erreur lors de la récupération de la liste des propriétés par status");
        }
        //log sortie de la méthode getProprieteByStatus du service ProprieteService
        log.info("Sortie de la méthode getProprieteByStatus du service ProprieteService");
        //retourner la liste des propriétés
        return proprieteList;
    }

    //récupérer propriétés par adresse
    public List<ProprieteDto> getProprieteByAdresse(String adresse) {
        //log entrée dans la méthode getProprieteByAdresse du service ProprieteService
        log.info("Entrée dans la méthode getProprieteByAdresse du service ProprieteService");
        List<ProprieteDto> proprieteList = null;
        try {
            //récupérer la liste des propriétés par adresse
            List<Propriete> proprieteEntityList = proprieteRepo.findByAdresse(adresse);
            //si la liste des propriétés n'est pas null la mapper
            if (proprieteEntityList != null) {
                proprieteList = proprieteEntityList.stream().map(propriete -> mapper.map(propriete, ProprieteDto.class)).collect(Collectors.toList());
            }
        } catch (Exception e) {
            //log erreur récupération de la liste des propriétés par adresse
            log.error("Erreur lors de la récupération de la liste des propriétés par adresse");
        }
        //log sortie de la méthode getProprieteByAdresse du service ProprieteService
        log.info("Sortie de la méthode getProprieteByAdresse du service ProprieteService");
        //retourner la liste des propriétés
        return proprieteList;
    }
    
}
