/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connexion.Connexion;
import models.Approvisionnement;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Raina
 */
public class ApprovisionnementDAO {
      // Get all Approvisionnements
    public static ArrayList<Approvisionnement> getAll() throws Exception {
        ArrayList<Approvisionnement> approvisionnements = new ArrayList<>();
        String query = "SELECT * FROM Approvisionnement";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                approvisionnements.add(new Approvisionnement(
                        resultSet.getString("IdApprovisionnement"),
                        resultSet.getString("IdProduit"),
                        resultSet.getDate("DateApprovisionnement")
                ));
            }
        } catch (Exception e) {
            throw e;
        }
        return approvisionnements;
    }

    // Get Approvisionnement by Id
    public static Approvisionnement getById(String idApprovisionnement) throws Exception {
        Approvisionnement approvisionnement = null;
        String query = "SELECT * FROM Approvisionnement WHERE IdApprovisionnement = ?";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, idApprovisionnement);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    approvisionnement = new Approvisionnement(
                            resultSet.getString("IdApprovisionnement"),
                            resultSet.getString("IdProduit"),
                            resultSet.getDate("DateApprovisionnement")
                    );
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return approvisionnement;
    }

    // Insert a new Approvisionnement
    public static void insert(String idApprovisionnement, String idProduit, Date dateApprovisionnement) throws Exception {
        String query = "INSERT INTO Approvisionnement (IdApprovisionnement, IdProduit, DateApprovisionnement) VALUES (?, ?, ?)";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, idApprovisionnement);
            statement.setString(2, idProduit);
            statement.setDate(3, dateApprovisionnement);
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    // Update an existing Approvisionnement
    public static void update(Approvisionnement approvisionnement) throws Exception {
        String query = "UPDATE Approvisionnement SET IdProduit = ?, DateApprovisionnement = ? WHERE IdApprovisionnement = ?";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, approvisionnement.getIdProduit());
            statement.setDate(2, (Date) approvisionnement.getDateApprovisionnement());
            statement.setString(3, approvisionnement.getIdApprovisionnement());
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    // Delete an Approvisionnement by Id
    public static void delete(String idApprovisionnement) throws Exception {
        String query = "DELETE FROM Approvisionnement WHERE IdApprovisionnement = ?";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, idApprovisionnement);
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
}
