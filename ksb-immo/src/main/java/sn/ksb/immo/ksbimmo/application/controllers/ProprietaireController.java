package sn.ksb.immo.ksbimmo.application.controllers;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.ksb.immo.ksbimmo.application.dtos.ProprietaireDto;
import sn.ksb.immo.ksbimmo.application.models.Proprietaire;
import sn.ksb.immo.ksbimmo.application.services.ProprietaireService;

import java.util.List;

@RestController
@Slf4j
@OpenAPIDefinition(tags = {@Tag(name = "Proprietaire", description = "Proprietaire API")})
@RequestMapping("/api/proprietaire")
@CrossOrigin
public class ProprietaireController {

    private final ProprietaireService service;

    public ProprietaireController(ProprietaireService service) {
        this.service = service;
    }

    //get All proprietaires
    @GetMapping
    public List<ProprietaireDto> getAll() {
        //log the entry of the method
        log.info("Entrée dans la méthode getAll du controller ProprietaireController");
        //initialize a list of proprietaire
        List<ProprietaireDto> proprietaires = null;
        //try to get all proprietaires from the service
        try {
            proprietaires = service.getAll();
        } catch (Exception e) {
            //log the error
            log.error("Erreur lors de la récupération des proprietaires dans la base de données");
        }
        //if the list is empty
        if (proprietaires == null || proprietaires.isEmpty()) {
            //log the error
            log.error("Aucun proprietaire n'a été trouvé dans la base de données");
        }
        //log the exit of the method
        log.info("Sortie de la méthode getAll du controller ProprietaireController");
        //return the list
        return proprietaires;
    }

    //get proprietaire by numCarteIdentite
    @GetMapping("/{numCarteIdentite}")
    public ProprietaireDto getByNumCarteIdentite(@PathVariable String numCarteIdentite) {
        //log the entry of the method
        log.info("Entrée dans la méthode getByNumCarteIdentite du controller ProprietaireController");
        //initialize a proprietaire
        ProprietaireDto proprietaire = null;
        //log the numCarteIdentite parameter
        log.info("Paramètre numCarteIdentite : " + numCarteIdentite);
        //try to get the proprietaire from the service
        try {
            proprietaire = service.getByCni(numCarteIdentite);
        } catch (Exception e) {
            //log the error
            log.error("Erreur lors de la récupération du proprietaire dans la base de données");
        }
        //if the proprietaire is null
        if (proprietaire == null) {
            //log the error
            log.error("Aucun proprietaire n'a été trouvé dans la base de données");
        }
        //log the exit of the method
        log.info("Sortie de la méthode getByNumCarteIdentite du controller ProprietaireController");
        //return the proprietaire
        return proprietaire;
    }

    //create proprietaire
    @PostMapping
    public ProprietaireDto create(@RequestBody ProprietaireDto proprietaire) {
        //log the entry of the method
        log.info("Entrée dans la méthode create du controller ProprietaireController");
        //initialize a proprietaire
        ProprietaireDto proprietaireCreated = null;
        //log the proprietaire parameter
        log.info("Paramètre proprietaire : " + proprietaire);
        //try to create the proprietaire
        try {
            proprietaireCreated = service.add(proprietaire);
        } catch (Exception e) {
            //log the error
            log.error("Erreur lors de la création du proprietaire dans la base de données");
        }
        //if the proprietaire is null
        if (proprietaireCreated == null) {
            //log the error
            log.error("Aucun proprietaire n'a été créé dans la base de données");
        }
        //log the exit of the method
        log.info("Sortie de la méthode create du controller ProprietaireController");
        //return the proprietaire
        return proprietaireCreated;
    }

    //update Proprietaire
    public ProprietaireDto update(@RequestBody ProprietaireDto proprietaire) {
        //log the entry of the method
        log.info("Entrée dans la méthode update du controller ProprietaireController");
        //initialize a proprietaire
        ProprietaireDto proprietaireUpdated = null;
        //log the proprietaire parameter
        log.info("Paramètre proprietaire : " + proprietaire);
        //try to update the proprietaire
        try {
            proprietaireUpdated = service.update(proprietaire);
        } catch (Exception e) {
            //log the error
            log.error("Erreur lors de la mise à jour du proprietaire dans la base de données");
        }
        //if the proprietaire is null
        if (proprietaireUpdated == null) {
            //log the error
            log.error("Aucun proprietaire n'a été mis à jour dans la base de données");
        }
        //log the exit of the method
        log.info("Sortie de la méthode update du controller ProprietaireController");
        //return the proprietaire
        return proprietaireUpdated;
    }

    //delete proprietaire
    @DeleteMapping("/{numCarteIdentite}")
    public void delete(@PathVariable String numCarteIdentite) {
        //log the entry of the method
        log.info("Entrée dans la méthode delete du controller ProprietaireController");
        //initialize a proprietaire
        ProprietaireDto proprietaireDeleted = null;
        HttpStatus status = HttpStatus.OK;
        //log the numCarteIdentite parameter
        log.info("Paramètre numCarteIdentite : " + numCarteIdentite);
        //try to delete the proprietaire
        try {
            service.delete(numCarteIdentite);
        } catch (Exception e) {
            //log the error
            log.error("Erreur lors de la suppression du proprietaire dans la base de données");
        }
        //log the exit of the method
        log.info("Sortie de la méthode delete du controller ProprietaireController");
    }
}
