package sn.ksb.immo.ksbimmo.application.dtos;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class LoyerDto {
    private Double montant;
    private String dateDebut;

    //la durée de la location en mois
    private Integer dureeBail;
}
