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
public class Fournisseur {
    private String idFournisseur;
    private String nomFournisseur;
    private String adresseFournisseur;

     public Fournisseur(String idFournisseur, String nomFournisseur, String adresseFournisseur) {
        this.idFournisseur = idFournisseur;
        this.nomFournisseur = nomFournisseur;
        this.adresseFournisseur = adresseFournisseur;
    }



    public String getidFournisseur() {
        return idFournisseur;
    }
    public void setIdFournisseur(String idFournisseur) {
        idFournisseur = idFournisseur;
    }

    public String getNomFournisseur() {
        return nomFournisseur;
    }
    public void setNomFournisseur(String nomFournisseur) {
        nomFournisseur = nomFournisseur;
    }
    public String getAdresseFournisseur() {
        return adresseFournisseur;
    }
    public void setAdresseFournisseur(String adresseFournisseur) {
        adresseFournisseur = adresseFournisseur;
    }
}
