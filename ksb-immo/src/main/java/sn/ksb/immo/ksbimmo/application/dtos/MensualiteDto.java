package sn.ksb.immo.ksbimmo.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MensualiteDto {
    private String loyerId;

    private Double montant;

    private Integer nombreMois;
}
