package sn.ksb.immo.ksbimmo.application.controllers;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import sn.ksb.immo.ksbimmo.application.dtos.AgenceDto;
import sn.ksb.immo.ksbimmo.application.models.Agence;
import sn.ksb.immo.ksbimmo.application.services.AgenceService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@OpenAPIDefinition(tags = {@Tag(name = "Agence", description = "Agence API")})
@RequestMapping("/api/agence")
<<<<<<< HEAD
@CrossOrigin(origins = "http://localhost:4200")
=======
@CrossOrigin
>>>>>>> a63cb9f2f2db6e095a956fdc57ae78d46285b00e
public class AgenceController {

    private final AgenceService service;


    public AgenceController(AgenceService service) {
        this.service = service;
    }

    //get All agences
    @GetMapping
    public List<AgenceDto> getAllAgence() {
        //log the entry of the method
        log.info("Entrée dans la méthode getAllAgence du controller AgenceController");
        //initialize a list of agence
        List<AgenceDto> agences = null;
        //try to get all agences from the service
        try {
            agences = service.getAllAgences();
        } catch (Exception e) {
            //log the error
            log.error("Erreur lors de la récupération des agences dans la base de données");
        }
        //if the list is empty
        if (agences == null || agences.isEmpty()) {
            //log the error
            log.error("Aucune agence n'a été trouvée dans la base de données");
        }
        //log the exit of the method
        log.info("Sortie de la méthode getAllAgence du controller AgenceController");
        //return the list
        return agences;
    }

    //get agence by id
    @GetMapping("/{id}")
    public AgenceDto getAgenceById(@PathVariable String id) {
        //log the entry of the method
        log.info("Entrée dans la méthode getAgenceById du controller AgenceController");
        //initialize a agence
        AgenceDto agence = null;
        //log the id parameter
        log.info("Paramètre id : " + id);
        //try to get the agence from the service
        try {
            agence = service.getAgenceById(id);
        } catch (Exception e) {
            //log the error
            log.error("Erreur lors de la récupération de l'agence dans la base de données");
        }
        //if the agence is null
        if (agence == null) {
            //log the error
            log.error("Aucune agence n'a été trouvée dans la base de données");
        }
        //log the exit of the method
        log.info("Sortie de la méthode getAgenceById du controller AgenceController");
        //return the agence
        return agence;
    }

    //create agence
    @PostMapping
    public AgenceDto createAgence(@RequestBody @Validated AgenceDto agence) {
        //log the entry of the method
        log.info("Entrée dans la méthode createAgence du controller AgenceController");
        //log the agence parameter
        log.info("Paramètre agence : " + agence);
        //initialize a agence
        AgenceDto agenceCreated = null;
        //try to create the agence
        try {
            agenceCreated = service.addAgence(agence);
        } catch (Exception e) {
            //log the error
            log.error("Erreur lors de la création de l'agence dans la base de données");
        }
        //if the agence is null
        if (agenceCreated == null) {
            //log the error
            log.error("Aucune agence n'a été créée dans la base de données");
        }
        //log the exit of the method
        log.info("Sortie de la méthode createAgence du controller AgenceController");
        //return the agence
        return agenceCreated;
    }

    //update agence
    @PutMapping
    public AgenceDto updateAgence(@RequestBody @Validated AgenceDto agence) {
        //log the entry of the method
        log.info("Entrée dans la méthode updateAgence du controller AgenceController");
        //initialize a agence
        AgenceDto agenceUpdated = null;
        //try to update the agence
        try {
            agenceUpdated = service.updateAgence(agence);
        } catch (Exception e) {
            //log the error
            log.error("Erreur lors de la mise à jour de l'agence dans la base de données");
        }
        //if the agence is null
        if (agenceUpdated == null) {
            //log the error
            log.error("Aucune agence n'a été mise à jour dans la base de données");
        }
        //log the exit of the method
        log.info("Sortie de la méthode updateAgence du controller AgenceController");
        //return the agence
        return agenceUpdated;
    }

    //delete agence
    @DeleteMapping("/{id}")
    public void deleteAgence(@PathVariable String id) {
        //log the entry of the method
        log.info("Entrée dans la méthode deleteAgence du controller AgenceController");
        //log the id parameter
        log.info("Paramètre id : " + id);
        //try to delete the agence
        try {
            service.deleteAgence(id);
        } catch (Exception e) {
            //log the error
            log.error("Erreur lors de la suppression de l'agence dans la base de données");
        }
        //log the exit of the method
        log.info("Sortie de la méthode deleteAgence du controller AgenceController");
    }

    //get agence by region
    @GetMapping("/region/{region}")
    public List<AgenceDto> getAgenceByRegion(@PathVariable String region) {
        //log the entry of the method
        log.info("Entrée dans la méthode getAgenceByRegion du controller AgenceController");
        //initialize a list of agence
        List<AgenceDto> agencesDto = null;
        //log the region parameter
        log.info("Paramètre region : " + region);
        //try to get the agence from the service
        try {
            agencesDto = service.getAgencesByRegion(region);
        } catch (Exception e) {
            //log the error
            log.error("Erreur lors de la récupération de l'agence dans la base de données");
        }
        //if the agence is null
        if (agencesDto == null) {
            //log the error
            log.error("Aucune agence n'a été trouvée dans la base de données");
        }
        //log the exit of the method
        log.info("Sortie de la méthode getAgenceByRegion du controller AgenceController");
        //return the agence
        return agencesDto;
    }

    //get agence by region and departement
    @GetMapping("/region/{region}/departement/{departement}")
    public List<AgenceDto> getAgenceByRegionAndDepartement(@PathVariable String region, @PathVariable String departement) {
        //log the entry of the method
        log.info("Entrée dans la méthode getAgenceByRegionAndDepartement du controller AgenceController");
        //initialize a list of agence
        List<AgenceDto> agences = null;
        //log the region parameter
        log.info("Paramètre region : " + region);
        //log the departement parameter
        log.info("Paramètre departement : " + departement);
        //try to get the agence from the service
        try {
            agences = service.getAgencesByRegionAndDepartement(region, departement);
        } catch (Exception e) {
            //log the error
            log.error("Erreur lors de la récupération de l'agence dans la base de données");
        }
        //if the agence is null
        if (agences == null) {
            //log the error
            log.error("Aucune agence n'a été trouvée dans la base de données");
        }
        //log the exit of the method
        log.info("Sortie de la méthode getAgenceByRegionAndDepartement du controller AgenceController");
        //return the agence
        return agences;
    }
}
