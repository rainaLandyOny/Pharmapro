/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Raina
 */
public class SousCategorie {
     private String idSousCategorie;  // Changed to String based on VARCHAR
    private String nomSousCategorie;

    public SousCategorie(String idSousCategorie, String nomSousCategorie) {
        this.idSousCategorie = idSousCategorie;
        this.nomSousCategorie = nomSousCategorie;
    }

    // Getters and Setters
    public String getIdSousCategorie() {
        return idSousCategorie;
    }

    public void setIdSousCategorie(String idSousCategorie) {
        this.idSousCategorie = idSousCategorie;
    }

    public String getNomSousCategorie() {
        return nomSousCategorie;
    }

    public void setNomSousCategorie(String nomSousCategorie) {
        this.nomSousCategorie = nomSousCategorie;
    }
}
