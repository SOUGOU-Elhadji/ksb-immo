package sn.ksb.immo.ksbimmo.application.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoyerDto {
    private Double montant;
    private String dateDebut;

    //la durée de la location en mois
    private Integer dureeBail;
}
