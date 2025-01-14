/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;

/**
 *
 * @author Raina
 */
public class Conseils {
    private String idConseils;
    private String idProduit;
    private Date moisEtAnne;

    // Constructeurs
    public Conseils() {
    }

    public Conseils(String idConseils, String idProduit, Date moisEtAnne) {
        this.idConseils = idConseils;
        this.idProduit = idProduit;
        this.moisEtAnne = moisEtAnne;
    }

    // Getters et Setters
    public String getIdConseils() {
        return idConseils;
    }

    public void setIdConseils(String idConseils) {
        this.idConseils = idConseils;
    }

    public String getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(String idProduit) {
        this.idProduit = idProduit;
    }

    public Date getMoisEtAnne() {
        return moisEtAnne;
    }

    public void setMoisEtAnne(Date moisEtAnne) {
        this.moisEtAnne = moisEtAnne;
    }
}
