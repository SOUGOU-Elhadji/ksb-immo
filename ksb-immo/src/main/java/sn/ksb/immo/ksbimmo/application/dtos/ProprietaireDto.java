package sn.ksb.immo.ksbimmo.application.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProprietaireDto {
    private String id;
    private String nom;
    private String prenom;
    private String adresse;
    private String telephone;
    private String email;
    private String profession;
    private String dateNaissance;
    private String cni;
    private String dateDelivranceCni;
    private String numCompteBancaire;
    List<ProprieteDto> proprietes;

}
