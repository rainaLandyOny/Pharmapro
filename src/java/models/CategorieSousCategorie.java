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
public class CategorieSousCategorie {
    private int idCategorieSousCategorie;
    private int idCategorie;
    private int idSousCategorie;

    public CategorieSousCategorie(int idCategorieSousCategorie,int idCategorie, int idSousCategorie) {
        this.idCategorieSousCategorie= idCategorieSousCategorie;
        this.idCategorie = idCategorie;
        this.idSousCategorie = idSousCategorie;
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
}
