/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joe.alain.myapp.modele;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Doudou TIARILALA <doudou.tiarilala@inqipit.fr>
 * 8 juil. 2020 17:27:00
 */
@Entity
@Table(name = "userd")
public  class UserD{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;
    private String user_fullname;
    private String user_shortname;
    private String user_projet;
    private String user_tache;
    private String user_actif;
    Timestamp user_ts;

   

    @Override
    public String toString() {
        return "User{" + "user_id=" + user_id + ", user_fullname=" + user_fullname + ", user_shortname=" + user_shortname + ", user_projet=" + user_projet + ", user_tache=" + user_tache + ", user_actif=" + user_actif + ", user_ts=" + user_ts + '}';
    }

    public UserD(int user_id, String user_fullname, String user_shortname, String user_projet, String user_tache, String user_actif, Timestamp user_ts) {
        this.setUser_id(user_id);
        this.setUser_fullname(user_fullname);
        this.setUser_shortname(user_shortname);
        this.setUser_projet(user_projet);
        this.setUser_tache (user_tache);
        this.setUser_actif(user_actif);
        this.setUser_ts(user_ts);
    }
    public UserD() {
    }
    
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_fullname() {
        return user_fullname;
    }

    public void setUser_fullname(String user_fullname) {
        this.user_fullname = user_fullname;
    }

    public String getUser_shortname() {
        return user_shortname;
    }

    public void setUser_shortname(String user_shortname) {
        this.user_shortname = user_shortname;
    }

    public String getUser_projet() {
        return user_projet;
    }

    public void setUser_projet(String user_projet) {
        this.user_projet = user_projet;
    }

    public String getUser_tache() {
        return user_tache;
    }

    public void setUser_tache(String user_tache) {
        this.user_tache = user_tache;
    }

    public String getUser_actif() {
        return user_actif;
    }

    public void setUser_actif(String user_actif) {
        this.user_actif = user_actif;
    }

    public Timestamp getUser_ts() {
        return user_ts;
    }

    public void setUser_ts(Timestamp user_ts) {
        this.user_ts = user_ts;
    }
  

}
