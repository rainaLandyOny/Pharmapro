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
public class AspectProduit {
    private String idAspectProduit;
    private int idAspect;
    private String idProduit;

    public AspectProduit(String idAspectProduit, int idAspect, String idProduit) {
        this.idAspectProduit = idAspectProduit;
        this.idAspect = idAspect;
        this.idProduit = idProduit;
    }

    // Getters and Setters
    public String getIdAspectProduit() {
        return idAspectProduit;
    }

    public void setIdAspectProduit(String idAspectProduit) {
        this.idAspectProduit = idAspectProduit;
    }

    public int getIdAspect() {
        return idAspect;
    }

    public void setIdAspect(int idAspect) {
        this.idAspect = idAspect;
    }

    public String getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(String idProduit) {
        this.idProduit = idProduit;
    }
}
