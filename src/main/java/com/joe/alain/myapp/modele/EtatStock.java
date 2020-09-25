package com.joe.alain.myapp.modele;


import javax.persistence.*;

@Entity
@Table(name = "v_etatde_stock")
public class EtatStock {

    @Id
    private String id;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Article.class)
    @JoinColumn(name="article")
    private Article article;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Depot.class)
    @JoinColumn(name="depot")
    private Depot depot;

    private double reste;
    private double pu;
    private double montant;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Depot getDepot() {
        return depot;
    }

    public void setDepot(Depot depot) {
        this.depot = depot;
    }

    public double getReste() {
        return reste;
    }

    public void setReste(double reste) {
        this.reste = reste;
    }

    public double getPu() {
        return pu;
    }

    public void setPu(double pu) {
        this.pu = pu;
    }

    public double getMontant() {
        return pu * reste;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }


}
