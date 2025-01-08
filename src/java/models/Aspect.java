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
public class Aspect {
    private int idAspect;
    private String nomAspect;

    public Aspect(int idAspect, String nomAspect) {
        this.idAspect = idAspect;
        this.nomAspect = nomAspect;
    }

   

    // Getters and Setters
    public int getIdAspect() {
        return idAspect;
    }

    public void setIdAspect(int idAspect) {
        this.idAspect = idAspect;
    }

    public String getNomAspect() {
        return nomAspect;
    }

    public void setNomAspect(String nomAspect) {
        this.nomAspect = nomAspect;
    }
}
