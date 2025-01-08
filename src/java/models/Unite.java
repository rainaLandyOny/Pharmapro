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
public class Unite {
    private String idUnite;
    private String nomUnite;

    public Unite(String idUnite, String nomUnite) {
        this.idUnite = idUnite;
        this.nomUnite = nomUnite;
    }

    // Getters and Setters
    public String getIdUnite() {
        return idUnite;
    }

    public void setIdUnite(String idUnite) {
        this.idUnite = idUnite;
    }

    public String getNomUnite() {
        return nomUnite;
    }

    public void setNomUnite(String nomUnite) {
        this.nomUnite = nomUnite;
    }
}
