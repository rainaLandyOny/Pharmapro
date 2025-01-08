/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.util.Date;
/**
 *
 * @author Raina
 */
public class Vente {
    private String idVente;
    private Date dateVente;
    private double montantTotal;

    public Vente(String idVente, Date dateVente, double montantTotal) {
        this.idVente = idVente;
        this.dateVente = dateVente;
        this.montantTotal = montantTotal;
    }

    // Getters and Setters
    public String getIdVente() {
        return idVente;
    }

    public void setIdVente(String idVente) {
        this.idVente = idVente;
    }

    public Date getDateVente() {
        return dateVente;
    }

    public void setDateVente(Date dateVente) {
        this.dateVente = dateVente;
    }

    public double getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(double montantTotal) {
        this.montantTotal = montantTotal;
    }
}
