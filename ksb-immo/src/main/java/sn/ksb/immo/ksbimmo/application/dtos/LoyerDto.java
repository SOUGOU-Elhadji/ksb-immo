package sn.ksb.immo.ksbimmo.application.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoyerDto {
    private String id;
    private Double montant;
    private String debut;
    private Integer dureeBail;
    private String proprieteId;
    private String locataireId;
}
