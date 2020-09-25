package com.joe.alain.myapp.modele;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;

@Entity
@Table(name = "mouvement")
public class Mouvement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Date date;

    @NotBlank(message = "Reference is mandatory")
    private String reference;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Depot.class)
    @JoinColumn(name="depot")
    private Depot depot;

    private String designation;

    private String type;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Article.class)
    @JoinColumn(name="article")
    private Article article;

    private double entree;

    private double sortie;

    private double pu;

    private double montant;

    private int etat;

    public Mouvement(Date date, String reference, Depot depot, String designation, String type, Article article, double entree, double pu, double montant, int etat) {
        this.date = date;
        this.reference = reference;
        this.depot = depot;
        this.designation = designation;
        this.type = type;
        this.article = article;
        this.entree = entree;
        this.pu = pu;
        this.montant = montant;
        this.etat = etat;
    }

    public Mouvement() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Depot getDepot() {
        return depot;
    }

    public void setDepot(Depot depot) {
        this.depot = depot;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public double getEntree() {
        return entree;
    }

    public void setEntree(double entree) {
        this.entree = entree;
    }

    public double getSortie() {
        return sortie;
    }

    public void setSortie(double sortie) {
        this.sortie = sortie;
    }

    public double getPu() {
        return pu;
    }

    public void setPu(double pu) {
        this.pu = pu;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
