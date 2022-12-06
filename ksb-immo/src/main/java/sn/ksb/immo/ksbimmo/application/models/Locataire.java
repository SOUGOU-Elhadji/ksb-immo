package sn.ksb.immo.ksbimmo.application.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Locataire extends Utilisateur{

    private String nom;

    private String prenom;

    private String adresse;

    private String telephone;

    private String email;

    private String profession;

    @Embedded
    private SituationProfessionnelle situationProfessionnelle;

    @OneToOne(cascade = CascadeType.ALL)
    private Garant garant;

    private String numCompteBancaire;

    @ManyToMany
    @JoinColumn(table = "locataire_propriete")
    private List<Propriete> proprietes;

    @OneToOne(cascade = CascadeType.ALL)
    private Loyer loyer;

}
