package sn.ksb.immo.ksbimmo.generatecontract.model;


import jakarta.persistence.*;

@Entity
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nom;

    private String naissance;
    private String profession;

    private String cni;
    private String dateDelivrance;

    private String proprieteLieu;

    private String proprietaire;

    private String numPassport;
    private String lieuNaissance;


    private Long prix;
    private String numLot;

    private  String addressBailleur;
    private String adddressPreneur;

    public Form() {
    }

    public Form(Long id, String nom, String naissance, String profession, String cni, String dateDelivrance, String proprieteLieu, Long prix, String proprietaire, String numLot,String numPassport, String lieuNaissance, String addressBailleur,String adddressPreneur) {
        this.id = id;
        this.nom = nom;
        this.naissance = naissance;
        this.profession = profession;
        this.cni = cni;
        this.dateDelivrance = dateDelivrance;
        this.proprieteLieu = proprieteLieu;
        this.proprietaire = proprietaire;
        this.numLot  = numLot;
        this.prix = prix;
        this.numPassport= numPassport;
        this.lieuNaissance= lieuNaissance;
        this.addressBailleur= addressBailleur;
        this.adddressPreneur=adddressPreneur;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNaissance() {
        return naissance;
    }

    public void setNaissance(String naissance) {
        this.naissance = naissance;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getCni() {
        return cni;
    }

    public void setCni(String cni) {
        this.cni = cni;
    }

    public String getDateDelivrance() {
        return dateDelivrance;
    }

    public void setDateDelivrance(String dateDelivrance) {
        this.dateDelivrance = dateDelivrance;
    }

    public String getProprieteLieu() {
        return proprieteLieu;
    }

    public void setProprieteLieu(String proprieteLieu) {
        this.proprieteLieu = proprieteLieu;
    }

    public Long getPrix() {
        return prix;
    }

    public void setPrix(Long prix) {
        this.prix = prix;
    }

    public String getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    public String getNumLot() {
        return numLot;
    }

    public void setNumLot(String numLot) {
        this.numLot = numLot;
    }


    public String getNumPassport() {
        return numPassport;
    }

    public void setNumPassport(String numPassport) {
        this.numPassport = numPassport;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public String getAddressBailleur() {
        return addressBailleur;
    }

    public void setAddressBailleur(String addressBailleur) {
        this.addressBailleur = addressBailleur;
    }

    public String getAdddressPreneur() {
        return adddressPreneur;
    }

    public void setAdddressPreneur(String adddressPreneur) {
        this.adddressPreneur = adddressPreneur;
    }
}


