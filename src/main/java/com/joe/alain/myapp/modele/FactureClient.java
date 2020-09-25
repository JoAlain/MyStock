package com.joe.alain.myapp.modele;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "facture_client")
public class FactureClient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String orderid;

    @JoinColumn(name = "tiers")
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Tiers.class)
    private Tiers tiers; // client

    private Date creation;
    private Date paiementdue;

    @JoinColumn(name = "modepaiement")
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = ModeDePaiement.class)
    private ModeDePaiement modepaiement;

    private double tva;
    private int etat;

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public double getTva() {
        return tva;
    }

    public void setTva(double tva) {
        this.tva = tva;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public Tiers getTiers() {
        return tiers;
    }

    public void setTiers(Tiers tiers) {
        this.tiers = tiers;
    }

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public Date getPaiementdue() {
        return paiementdue;
    }

    public void setPaiementdue(Date paiementdue) {
        this.paiementdue = paiementdue;
    }

    public ModeDePaiement getModepaiement() {
        return modepaiement;
    }

    public void setModepaiement(ModeDePaiement modepaiement) {
        this.modepaiement = modepaiement;
    }
}
