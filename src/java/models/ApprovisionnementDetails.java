/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.math.BigDecimal;
import java.sql.Date;
/**
 *
 * @author Raina
 */
public class ApprovisionnementDetails {
    private String idApprovisionnementDetails;
    private String idApprovisionnement;
    private String idFournisseur;
    private BigDecimal quantite;
    private BigDecimal prix;
    private BigDecimal total;
    private Date datePeremption;
    
     // Constructor
 public ApprovisionnementDetails(String idApprovisionnementDetails, String idApprovisionnement,String idFournisseur,BigDecimal quantite, BigDecimal prix,BigDecimal total, Date datePeremption) {
        this.idApprovisionnementDetails = idApprovisionnementDetails;
        this.idApprovisionnement = idApprovisionnement;
        this.idFournisseur = idFournisseur;
        this.quantite = quantite;
        this.prix = prix;
        this.total = total;
        this.datePeremption = datePeremption;
    }

    // Getters and Setters
    public String getIdApprovisionnementDetails() {
        return idApprovisionnementDetails;
    }

    public void setIdApprovisionnementdetails(String idApprovisionnementDetails) {
        this.idApprovisionnementDetails = idApprovisionnementDetails;
    }

    public String getIdApprovisionnement() {
        return idApprovisionnement;
    }

    public void setIdApprovisionnement(String idApprovisionnement) {
        this.idApprovisionnement = idApprovisionnement;
    }

    public String getIdFournisseur() {
        return idFournisseur;
    }

    public void setIdFournisseur(String idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    public BigDecimal getQuantite() {
        return quantite;
    }

    public void setQuantite(BigDecimal quantite) {
        this.quantite = quantite;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Date getDatePeremption() {
        return datePeremption;
    }

    public void setDatePeremption(Date datePeremption) {
        this.datePeremption = datePeremption;
    }
}
