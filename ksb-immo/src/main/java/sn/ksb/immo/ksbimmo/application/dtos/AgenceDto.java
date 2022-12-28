package sn.ksb.immo.ksbimmo.application.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgenceDto {
    private String id;
    private String nom;
    private String region;
    private String departement;
    private String telephone;
    private String adresse;

    private String dateCreation;
    private List<EmployeeDto> employees;
}
