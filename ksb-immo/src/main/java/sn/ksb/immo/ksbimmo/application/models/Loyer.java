package sn.ksb.immo.ksbimmo.application.models;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "loyer")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class Loyer {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    private Double montant;

    private Date debut;

    private Date fin;

    private Date dernierPaiement;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Propriete propriete;

    @OneToOne(cascade = CascadeType.ALL)
    private Locataire locataire;

    @OneToMany(cascade = CascadeType.MERGE)
    private List<Mensualite> mensualites;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Employee employe;

}