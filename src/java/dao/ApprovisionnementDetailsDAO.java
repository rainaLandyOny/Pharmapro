/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import connexion.Connexion;
import models.ApprovisionnementDetails;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Raina
 */
public class ApprovisionnementDetailsDAO {
      // Get all Approvisionnementdetails
    public static ArrayList<ApprovisionnementDetails> getAll() throws Exception {
        ArrayList<ApprovisionnementDetails> approvisionnementDetailsList = new ArrayList<>();
        String query = "SELECT * FROM ApprovisionnementDetails";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                approvisionnementDetailsList.add(new ApprovisionnementDetails(
                        resultSet.getString("IdApprovisionnementDetails"),
                        resultSet.getString("IdApprovisionnement"),
                        resultSet.getString("IdFournisseur"),
                        resultSet.getBigDecimal("Quantite"),
                        resultSet.getBigDecimal("Prix"),
                        resultSet.getBigDecimal("Total"),
                        resultSet.getDate("DatePeremption")
                ));
            }
        } catch (Exception e) {
            throw e;
        }
        return approvisionnementDetailsList;
    }

    // Get Approvisionnementdetails by Id
    public static ApprovisionnementDetails getById(String idApprovisionnementDetails) throws Exception {
        ApprovisionnementDetails approvisionnementDetails = null;
        String query = "SELECT * FROM ApprovisionnementDetails WHERE IdApprovisionnementDetails = ?";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, idApprovisionnementDetails);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    approvisionnementDetails = new ApprovisionnementDetails(
                            resultSet.getString("IdApprovisionnementDetails"),
                            resultSet.getString("IdApprovisionnement"),
                            resultSet.getString("IdFournisseur"),
                            resultSet.getBigDecimal("Quantite"),
                            resultSet.getBigDecimal("Prix"),
                            resultSet.getBigDecimal("Total"),
                            resultSet.getDate("DatePeremption")
                    );
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return approvisionnementDetails;
    }

    // Insert a new Approvisionnementdetails
    public static void insert(ApprovisionnementDetails approvisionnementDetails) throws Exception {
        String query = "INSERT INTO ApprovisionnementDetails (IdApprovisionnementDetails, IdApprovisionnement, " +
                "IdFournisseur, Quantite, Prix, Total, DatePeremption) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, approvisionnementDetails.getIdApprovisionnementDetails());
            statement.setString(2, approvisionnementDetails.getIdApprovisionnement());
            statement.setString(3, approvisionnementDetails.getIdFournisseur());
            statement.setBigDecimal(4, approvisionnementDetails.getQuantite());
            statement.setBigDecimal(5, approvisionnementDetails.getPrix());
            statement.setBigDecimal(6, approvisionnementDetails.getTotal());
            statement.setDate(7, approvisionnementDetails.getDatePeremption());
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    // Update an existing Approvisionnementdetails
    public static void update(ApprovisionnementDetails approvisionnementDetails) throws Exception {
        String query = "UPDATE ApprovisionnementDetails SET IdApprovisionnement = ?, IdFournisseur = ?, " +
                "Quantite = ?, Prix = ?, Total = ?, DatePeremption = ? WHERE IdApprovisionnementDetails = ?";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, approvisionnementDetails.getIdApprovisionnement());
            statement.setString(2, approvisionnementDetails.getIdFournisseur());
            statement.setBigDecimal(3, approvisionnementDetails.getQuantite());
            statement.setBigDecimal(4, approvisionnementDetails.getPrix());
            statement.setBigDecimal(5, approvisionnementDetails.getTotal());
            statement.setDate(6, approvisionnementDetails.getDatePeremption());
            statement.setString(7, approvisionnementDetails.getIdApprovisionnementDetails());
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    // Delete an Approvisionnementdetails by Id
    public static void delete(String idApprovisionnementDetails) throws Exception {
        String query = "DELETE FROM ApprovisionnementDetails WHERE IdApprovisionnementDetails = ?";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, idApprovisionnementDetails);
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
}
