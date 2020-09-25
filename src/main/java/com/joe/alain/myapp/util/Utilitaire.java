package com.joe.alain.myapp.util;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import static com.sun.org.apache.xalan.internal.xsltc.runtime.BasisLibrary.stringToInt;
import static org.thymeleaf.util.StringUtils.split;

public class Utilitaire {

    public static String dateDuJour() {
        Calendar a = Calendar.getInstance();
        String retour = null;
        retour = String.valueOf(String.valueOf(completerInt(2, a.get(5)))).concat("/");
        retour = String.valueOf(String.valueOf((new StringBuffer(String.valueOf(String.valueOf(retour)))).append(completerInt(2, a.get(2) + 1)).append("/")));
        retour = String.valueOf(retour) + String.valueOf(completerInt(4, a.get(1)));
        return retour;
    }

    public static Date dateDuJourSql() {
        return string_date("dd/MM/yyyy", dateDuJour());
    }

    public static String getMois(String daty) {
        return completerInt(2, split(daty, "/")[1]);
    }

    public static String getJour(String daty) {
        return completerInt(2, split(daty, "/")[0]);
    }

    public static String completerInt(int longuerChaine, int nombre) {
        String zero = null;
        zero = "";
        for (int i = 0; i < longuerChaine - String.valueOf(nombre).length(); i++) {
            zero = String.valueOf(String.valueOf(zero)).concat("0");
        }

        return String.valueOf(zero) + String.valueOf(String.valueOf(nombre));
    }

    public static String completerInt(int longuerChaine, String nombre2) {
        int nombre = stringToInt(nombre2);
        return completerInt(longuerChaine, nombre);
    }
    public static String getAnnee(String daty) {
        return split(daty, "/")[2];
    }
    public static Date string_date(String patterne, String daty) {
        try {
            if (daty == null || daty.compareTo("") == 0) {
                return null;
            }
            SimpleDateFormat formatter = new SimpleDateFormat(patterne);
            formatter.applyPattern(patterne);
            formatter.setTimeZone(TimeZone.getTimeZone("EUROPE"));
            String annee = getAnnee(daty);
            int anneecours = getAneeEnCours();
            int siecl = anneecours / 100;
            if (annee.toCharArray().length == 2) {
                annee = String.valueOf(siecl) + annee;
            }
            daty = getJour(daty) + "/" + getMois(daty) + "/" + annee;
            Date hiredate = new Date(formatter.parse(daty).getTime());
            Date date1 = hiredate;
            return date1;
        } catch (Exception e) {
            System.out.println("Error string_date wawawawa :" + e.getMessage());
        }
        Date date = dateDuJourSql();
        return date;
    }

    public static int getAneeEnCours() {
        Calendar a = Calendar.getInstance();
        return a.get(1);
    }
}
