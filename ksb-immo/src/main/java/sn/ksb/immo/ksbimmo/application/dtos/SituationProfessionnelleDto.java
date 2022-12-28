package sn.ksb.immo.ksbimmo.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SituationProfessionnelleDto {
    private String nomEmployeur;

    private String adresseEmployeur;

    private String telephoneEmployeur;

    private String emailEmployeur;

    private String posteOccupe;

    private Double salaire;

    private String dateEmbauche;

    private String dateDepart;

}
