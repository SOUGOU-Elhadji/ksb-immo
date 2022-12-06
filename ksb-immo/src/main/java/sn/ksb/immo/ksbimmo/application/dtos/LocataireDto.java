package sn.ksb.immo.ksbimmo.application.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LocataireDto {

    private String id;
    private String nom;

    private String prenom;

    private String adresse;

    private String telephone;

    private String email;

    private String profession;

    private GarantDto garant;

    private String cni;

    private String dateDelivranceCni;

    private String numCompteBancaire;

    private String proprieteId;

    private LoyerDto loyer;

    private SituationProfessionnelleDto situationProfessionnelle;
}
