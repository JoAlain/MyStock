package com.joe.alain.myapp.modele;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "sous_categorie")
public class SousCategorie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank(message = "Libelle obligatoire")
    private String libelle;

    @JoinColumn(name = "categorie_id")
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Categorie.class)
    private Categorie categorie;

    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
