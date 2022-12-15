package sn.ksb.immo.ksbimmo.application.dtos;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LoyerDto {
    private Double mensualite;
    private Double caution;
    private String dateDebut;
    private Integer dureeBail;
}
