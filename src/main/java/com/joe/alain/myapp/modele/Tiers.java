package com.joe.alain.myapp.modele;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tiers")
public class Tiers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank
    private String nom;

    private String nif;
    private String stat;
    private String email;

    @NotBlank
    private String adresse;
    private String gerant;
    @NotBlank
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = TypeTiers.class)
    @JoinColumn(name="type")
    private TypeTiers type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getGerant() {
        return gerant;
    }

    public void setGerant(String gerant) {
        this.gerant = gerant;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public TypeTiers getType() {
        return type;
    }

    public void setType(TypeTiers type) {
        this.type = type;
    }
}
