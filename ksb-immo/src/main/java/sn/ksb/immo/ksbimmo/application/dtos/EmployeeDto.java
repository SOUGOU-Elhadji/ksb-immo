package sn.ksb.immo.ksbimmo.application.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn.ksb.immo.ksbimmo.application.annotations.ValidEmail;
import sn.ksb.immo.ksbimmo.application.models.Role;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private String id;

    @NotNull
    @NotEmpty
    private String nom;

    @NotNull
    @NotEmpty
    private String prenom;

    @NotNull
    @NotEmpty
    private String telephone;

    @ValidEmail
    @NotNull
    @NotEmpty
    private String email;

    @NotNull
    @NotEmpty
    private String cni;

    private String dateDelivranceCni;

    @NotNull
    @NotEmpty
    private String adresse;

    @NotNull
    @NotEmpty
    private String numCompteBancaire;
    private Boolean manager;

    @NotNull
    @NotEmpty
    private String agenceId;

}
