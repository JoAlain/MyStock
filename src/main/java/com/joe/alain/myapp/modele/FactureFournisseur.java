package com.joe.alain.myapp.modele;

import javax.persistence.*;

@Entity
@Table(name = "facture_fournisseur")
public class FactureFournisseur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


}
