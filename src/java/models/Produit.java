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
public class Produit {
    private String idProduit;
    private String nomProduit;
    private double prixProduit;
    private String idFournisseur;
    private int idCategorie;
    private int idSousCategorie;
    private java.sql.Date dateFabrication;
    private String description;

    public Produit(String idProduit, String nomProduit, double prixProduit, String idFournisseur, int idCategorie,
            int idSousCategorie, Date dateFabrication, String description) {
        this.idProduit = idProduit;
        this.nomProduit = nomProduit;
        this.prixProduit = prixProduit;
        this.idFournisseur = idFournisseur;
        this.idCategorie = idCategorie;
        this.idSousCategorie = idSousCategorie;
        this.dateFabrication = dateFabrication;
        this.description = description;
    }

    public Produit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    

    // Getters and Setters
    public String getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(String idProduit) {
        this.idProduit = idProduit;
    }

    public String getNomProduit() {
        return nomProduit;
    }

    public void setNomProduit(String nomProduit) {
        this.nomProduit = nomProduit;
    }

    public double getPrixProduit() {
        return prixProduit;
    }

    public void setPrixProduit(double prixProduit) {
        this.prixProduit = prixProduit;
    }

    public String getIdFournisseur() {
        return idFournisseur;
    }

    public void setIdFournisseur(String idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public int getIdSousCategorie() {
        return idSousCategorie;
    }

    public void setIdSousCategorie(int idSousCategorie) {
        this.idSousCategorie = idSousCategorie;
    }

    public java.sql.Date getDateFabrication() {
        return dateFabrication;
    }

    public void setDateFabrication(java.sql.Date dateFabrication) {
        this.dateFabrication = dateFabrication;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

