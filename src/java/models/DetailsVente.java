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
public class DetailsVente {
    private String idDetailsVente;
    private String idVente;
    private String idProduit;
    private int quantite;
    private double prix;

    public DetailsVente(String idDetailsVente,String idVente, String idProduit, int quantite, double prix) {
        this.idDetailsVente= idDetailsVente;
        this.idVente = idVente;
        this.idProduit = idProduit;
        this.quantite = quantite;
        this.prix = prix;
    }
    // Getters and Setters
    public String getIdDetailsVente(){
        return idDetailsVente;
    }

    public void setIdDetailsVente(String idDetailsVente) {
        this.idDetailsVente = idDetailsVente;
    }


    public String getIdVente() {
        return idVente;
    }

    public void setIdVente(String idVente) {
        this.idVente = idVente;
    }

    public String getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(String idProduit) {
        this.idProduit = idProduit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
