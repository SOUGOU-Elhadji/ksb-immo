package sn.ksb.immo.ksbimmo.application.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "images")
public class Image {
    @Id
    private String id;
    private String fileName;

    private String imageType;

    private byte[] image;

    @ManyToOne
    @JsonIgnore
    private Propriete propriete;

}
