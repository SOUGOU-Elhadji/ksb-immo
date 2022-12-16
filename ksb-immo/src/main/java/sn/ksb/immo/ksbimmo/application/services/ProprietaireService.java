package sn.ksb.immo.ksbimmo.application.services;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sn.ksb.immo.ksbimmo.application.dtos.ProprietaireDto;
import sn.ksb.immo.ksbimmo.application.dtos.ProprieteDto;
import sn.ksb.immo.ksbimmo.application.models.Role;
import sn.ksb.immo.ksbimmo.application.models.Proprietaire;
import sn.ksb.immo.ksbimmo.application.models.Propriete;
import sn.ksb.immo.ksbimmo.application.repositories.AgenceRepo;
import sn.ksb.immo.ksbimmo.application.repositories.ProprietaireRepo;
import sn.ksb.immo.ksbimmo.application.repositories.RoleRepo;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@Slf4j
public class ProprietaireService {
    private final RoleRepo roleRepo;

    private final ProprietaireRepo proprietaireRepo;

    private final AgenceRepo agenceRepo;
    private final ModelMapper modelMapper;

    public ProprietaireService(ProprietaireRepo proprietaireRepo, AgenceRepo agenceRepo, ModelMapper modelMapper,
                               RoleRepo roleRepo) {
        this.proprietaireRepo = proprietaireRepo;
        this.agenceRepo = agenceRepo;
        this.modelMapper = modelMapper;
        this.roleRepo = roleRepo;
    }

    //récuperer les proprietaires qui ne sont pas supprimer
    public List<ProprietaireDto> getAll() {
        //log entrée de la méthode getAll dans le service
        log.info("Entrée dans la méthode getAll du service ProprietaireService");
        //initialize an empty list
        List<ProprietaireDto> proprietaires = new ArrayList<>();
        //try to get all proprietaires from the database
        try {
            List<Proprietaire> pList = proprietaireRepo.findAll();
            //if the list is not empty change the proprietaire list to proprietaireDto list
            if (pList != null && !pList.isEmpty()) {
                for (Proprietaire p : pList) {
                    proprietaires.add(modelMapper.map(p, ProprietaireDto.class));
                }
            }
        } catch (Exception e) {
            //log the error
            log.error("Erreur lors de la récupération des proprietaires dans la base de données");
        }
        //if the list is empty
        if (proprietaires.isEmpty()) {
            //log the error
            log.error("Aucun proprietaire n'a été trouvé dans la base de données");
        }
        //log the exit of the method
        log.info("Sortie de la méthode getAll du service ProprietaireService");
        //return the list
        return proprietaires;
    }

    //récuperer un proprietaire par son numero de carte d'identité
    public ProprietaireDto getByCni(String numCarteIdentite) {
        //log the entry of the method
        log.info("Entrée dans la méthode getByCni du service ProprietaireService");
        //initialize a proprietaire
        ProprietaireDto proprietaire = null;
        //log the numCarteIdentite parameter
        log.info("Paramètre numCarteIdentite : " + numCarteIdentite);
        //try to get the proprietaire from the database
        try {
            proprietaire = modelMapper.map(proprietaireRepo.findByCni(numCarteIdentite), ProprietaireDto.class);
        } catch (Exception e) {
            //log the error
            log.error("Erreur lors de la récupération du proprietaire dans la base de données");
        }
        //if the proprietaire is null
        if (proprietaire == null) {
            //log the error
            log.error("Aucun proprietaire avec le numéro {} n'a été trouvé dans la base de données", numCarteIdentite);
        }
        //log the exit of the method
        log.info("Sortie de la méthode getByCni du service ProprietaireService");
        //return the proprietaire
        return proprietaire;
    }

    //ajouter un proprietaire
    public ProprietaireDto add(ProprietaireDto dto) {
        //log the entry of the method
        log.info("Entrée dans la méthode add du service ProprietaireService");
        //log the proprietaire parameter
        log.info("Paramètre proprietaire : " + dto.getCni());
        ProprietaireDto proprietaire = null;
        //try to save the proprietaire in the database
        try {
            Proprietaire p = modelMapper.map(dto, Proprietaire.class);
            //check if the proprietaire already exists
            if (proprietaireRepo.existsByCni(p.getCni())) {
                //log the error
                log.error("Le proprietaire {} existe déjà dans la base de données", proprietaire.getCni());
                //return null
                return null;
            }
            //set the created at date
            p.setDateCreation(new Date());
            //set the updated at date
            p.setDateModification(new Date());
            //set the proprietaire as not deleted
            p.setDeleted(false);
            p.getProprietes().clear();
            for (ProprieteDto proprieteDto: dto.getProprietes()) {
                Propriete propriete = modelMapper.map(proprieteDto, Propriete.class);
                propriete.setAgence(agenceRepo.findById(UUID.fromString(proprieteDto.getAgenceId())).orElse(null));
                propriete.setStatus(false);
                propriete.setDeleted(false);
                propriete.setProprietaire(p);
                propriete.setDateCreation(new Date());
                propriete.setDateModification(new Date());

                p.getProprietes().add(propriete);
            }
            p.getRoles().add(roleRepo.findByName("Proprietaire"));
            //save the proprietaire in the database
            proprietaire = modelMapper.map(proprietaireRepo.save(p), ProprietaireDto.class);
        } catch (Exception e) {
            //log the error
            log.error("Erreur lors de l'ajout du proprietaire dans la base de données : {}", e.getMessage());
            e.printStackTrace();
        }
        //log the exit of the method
        log.info("Sortie de la méthode add du service ProprietaireService");
        //return the proprietaire
        return proprietaire;
    }

    //modifier un proprietaire
    public ProprietaireDto update(ProprietaireDto proprietaire) {
        //log the entry of the method
        log.info("Entrée dans la méthode update du service ProprietaireService");
        ProprietaireDto proprietaireDto = null;
        //try to update the proprietaire in the database
        try {
            //check if the proprietaire exists
            if (!proprietaireRepo.existsByCni(proprietaire.getCni())) {
                //log the error
                log.error("Le proprietaire {} n'existe pas dans la base de données", proprietaire.getCni());
                //return null
                return null;
            }
            //retrieve the proprietaire from the database
            Proprietaire proprietaireFromDb = proprietaireRepo.findByCni(proprietaire.getCni());
            proprietaireFromDb.setId(UUID.fromString(proprietaire.getId()));
            proprietaireFromDb.setNom(proprietaire.getNom());
            proprietaireFromDb.setPrenom(proprietaire.getPrenom());
            proprietaireFromDb.setTelephone(proprietaire.getTelephone());
            proprietaireFromDb.setAdresse(proprietaire.getAdresse());
            proprietaireFromDb.setEmail(proprietaire.getEmail());
            proprietaireFromDb.setDateModification(new Date());
            proprietaireFromDb.getProprietes().clear();
            for (ProprieteDto proprieteDto: proprietaire.getProprietes()) {
                Propriete propriete = modelMapper.map(proprieteDto, Propriete.class);
                propriete.setAgence(agenceRepo.findById(UUID.fromString(proprieteDto.getAgenceId())).orElse(null));
                propriete.setStatus(false);
                propriete.setDeleted(false);
                propriete.setProprietaire(proprietaireFromDb);
                propriete.setDateCreation(new Date());
                propriete.setDateModification(new Date());

                proprietaireFromDb.getProprietes().add(propriete);
            }

            //set the updated at date
            proprietaireFromDb.setDateModification(new Date());
            //save the proprietaire in the database
            proprietaireDto = modelMapper.map(proprietaireRepo.save(proprietaireFromDb), ProprietaireDto.class);
        } catch (Exception e) {
            //log the error
            log.error("Erreur lors de la modification du proprietaire dans la base de données");
        }
        //log the exit of the method
        log.info("Sortie de la méthode update du service ProprietaireService");
        //return the proprietaire
        return proprietaire;
    }

    //supprimer un proprietaire
    public void delete(String numCarteIdentite) {
        //log the entry of the method
        log.info("Entrée dans la méthode deleteProprietaire du service ProprietaireService");
        //log the numCarteIdentite parameter
        Proprietaire proprietaire = null;
        log.info("Paramètre numCarteIdentite : " + numCarteIdentite);
        //try to delete the proprietaire from the database
        try {
            //check if the proprietaire exists
            if (!proprietaireRepo.existsByCni(numCarteIdentite)) {
                //log the error
                log.error("Le proprietaire {} n'existe pas dans la base de données", numCarteIdentite);
                //return null
            }
            //retrieve the proprietaire from the database
            proprietaire = proprietaireRepo.findByCni(numCarteIdentite);
            //delete the proprietaire from the database
            proprietaireRepo.delete(proprietaire);
        } catch (Exception e) {
            //log the error
            log.error("Erreur lors de la suppression du proprietaire dans la base de données");
        }
        //check if the proprietaire is deleted
        if (proprietaire != null && proprietaire.getDeleted()) {
            //log the success
            log.info("Le proprietaire {} a été supprimé avec succès", numCarteIdentite);
        }
        //log the exit of the method
        log.info("Sortie de la méthode deleteProprietaire du service ProprietaireService");

    }

}
