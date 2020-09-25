package com.joe.alain.myapp.modele;

import javax.persistence.*;

@Entity
@Table(name = "facture_client_details")
public class FactureClientDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Article.class)
    @JoinColumn(name="produit")
    private Article produit;
    private String description;
    private double quantite;
    private double montant;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = FactureClient.class)
    @JoinColumn(name="facture")
    private FactureClient facture;

    public FactureClient getFacture() {
        return facture;
    }

    public void setFacture(FactureClient facture) {
        this.facture = facture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Article getProduit() {
        return produit;
    }

    public void setProduit(Article produit) {
        this.produit = produit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
}
