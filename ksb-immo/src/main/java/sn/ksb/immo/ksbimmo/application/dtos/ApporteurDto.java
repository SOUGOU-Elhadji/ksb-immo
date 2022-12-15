package sn.ksb.immo.ksbimmo.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApporteurDto {
    private String id;
    private String cni;
    private String nom;
    private String prenom;
    private String telephone;
    private String email;
    private String adresse;
    private String profession;
    private String dateDelivranceCni;
    private String dateNaissance;
    private String numCompteBancaire;
}
