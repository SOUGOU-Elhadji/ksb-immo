package sn.ksb.immo.ksbimmo.application.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sn.ksb.immo.ksbimmo.application.dtos.MensualiteDto;
import sn.ksb.immo.ksbimmo.application.models.Locataire;
import sn.ksb.immo.ksbimmo.application.models.Loyer;
import sn.ksb.immo.ksbimmo.application.models.Mensualite;
import sn.ksb.immo.ksbimmo.application.repositories.LocataireRepo;
import sn.ksb.immo.ksbimmo.application.repositories.LoyerRepo;
import sn.ksb.immo.ksbimmo.application.repositories.MensualiteRepo;
import sn.ksb.immo.ksbimmo.application.repositories.ProprieteRepo;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

@Service
@Transactional
@Slf4j
public class MensualiteService {

    private final MensualiteRepo mensualiteRepository;

    private final LocataireRepo locataireRepository;

    private final ProprieteRepo proprieteRepository;

    private final LoyerRepo loyerRepository;

    public MensualiteService(MensualiteRepo mensualiteRepository, LocataireRepo locataireRepository, ProprieteRepo proprieteRepository, LoyerRepo loyerRepository) {
        this.mensualiteRepository = mensualiteRepository;
        this.locataireRepository = locataireRepository;
        this.proprieteRepository = proprieteRepository;
        this.loyerRepository = loyerRepository;
    }

    //enregister un paiement
    public Mensualite createMensualite(MensualiteDto dto) {
        log.info("Entrée dans la méthode createMensualite du service MensualiteService");
        Mensualite mensualite = null;
        try {
            //recuperer le loyer du locataire
            Loyer loyer = loyerRepository.findById(UUID.fromString(dto.getLoyerId())).orElse(null);
            //si le loyer n'existe pas
            if (loyer == null) {
                log.warn("Le loyer n'existe pas");
                return null;
            }
            //creer la mensualite
            mensualite = new Mensualite();
            mensualite.setLoyer(loyer);
            mensualite.setDatePaiement(new Date());
            if (dto.getNombreMois() > 1) {
                mensualite.setMontant(loyer.getMensualite() * dto.getNombreMois());
            } else {
                mensualite.setMontant(loyer.getMensualite());
            }
            //enregistrer la mensualite
            mensualite = mensualiteRepository.save(mensualite);
            //modifier le dernier paiement du loyer
            loyer.setDernierPaiement(new Date());
            //modifier la date du prochain paiement
            LocalDate localDate = loyer.getDateProchainPaiement().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            localDate = localDate.plusMonths(dto.getNombreMois());
            loyer.setDateProchainPaiement(Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
            //enregistrer le loyer
            loyerRepository.save(loyer);
        }catch (Exception e) {
            log.error("Erreur lors la création de l'objet : {}", e.getMessage());
        }
        if (mensualite == null) {
            log.error("Erreur lors la création de l'objet");
        }
        log.info("Sortie de la méthode createMensualite du service MensualiteService");
        return mensualite;
    }
    
}
