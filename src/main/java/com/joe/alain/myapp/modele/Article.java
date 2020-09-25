package com.joe.alain.myapp.modele;

import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;

@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank(message = "Code obligatoire")
    private String code;

    @NotBlank(message = "Nom obligatoire")
    private String nomarticle;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Unite.class)
    @JoinColumn(name="unite")
    private Unite unite;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Categorie.class)
    @JoinColumn(name="categorie")
    private Categorie categorie;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = SousCategorie.class)
    @JoinColumn(name="souscategorie")
    private SousCategorie souscategorie;

    private double prix;

    private Date creation;

    public Article() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public SousCategorie getSouscategorie() {
        return souscategorie;
    }

    public void setSouscategorie(SousCategorie souscategorie) {
        this.souscategorie = souscategorie;
    }

    public Article(String nomarticle, Unite unite, Categorie categorie, double prix, Date creation) {
        this.nomarticle = nomarticle;
        this.categorie = categorie;
        this.creation = creation;
        this.prix = prix;
        this.unite = unite;
    }

    public Article(int id, String nomarticle, Unite unite, Categorie categorie, double prix, Date creation) {
        this.nomarticle = nomarticle;
        this.categorie = categorie;
        this.creation = creation;
        this.prix = prix;
        this.unite = unite;
    }

    public Unite getUnite() {
        return unite;
    }

    public void setUnite(Unite unite) {
        this.unite = unite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomarticle() {
        return nomarticle;
    }

    public void setNomarticle(String nomarticle) {
        this.nomarticle = nomarticle;
    }

    public Categorie getCategorie() {
        return categorie;
    }


    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }
}
