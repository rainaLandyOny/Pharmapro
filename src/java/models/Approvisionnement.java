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
public class Approvisionnement {
    private String idApprovisionnement;
    private String idProduit;
    private Date dateApprovisionnement;
    
     public Approvisionnement(String idApprovisionnement, String idProduit, Date dateApprovisionnement) {
        this.idApprovisionnement = idApprovisionnement;
        this.idProduit = idProduit;
        this.dateApprovisionnement = dateApprovisionnement;
    }
      // Getters and Setters
    public String getIdApprovisionnement() {
        return idApprovisionnement;
    }

    public void setIdApprovisionnement(String idApprovisionnement) {
        this.idApprovisionnement = idApprovisionnement;
    }

    public String getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(String idProduit) {
        this.idProduit = idProduit;
    }

    public Date getDateApprovisionnement() {
        return dateApprovisionnement;
    }

    public void setDateApprovisionnement(Date dateApprovisionnement) {
        this.dateApprovisionnement = dateApprovisionnement;
    }
}
