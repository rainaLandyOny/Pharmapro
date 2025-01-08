/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import connexion.Connexion;
import models.SousCategorie;

import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Raina
 */
public class SousCategorieDAO {
      // Get all SousCategories
    public static ArrayList<SousCategorie> getAll() throws Exception {
        ArrayList<SousCategorie> sousCategories = new ArrayList<>();
        String query = "SELECT * FROM SousCategorie";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                sousCategories.add(new SousCategorie(
                        resultSet.getString("IdSousCategorie"),  // Updated to String
                        resultSet.getString("NomSousCategorie")
                ));
            }
        } catch (Exception e) {
            throw e;
        }
        return sousCategories;
    }

    // Get SousCategorie by Id
    public static SousCategorie getById(String idSousCategorie) throws Exception {
        SousCategorie sousCategorie = null;
        String query = "SELECT * FROM SousCategorie WHERE IdSousCategorie = ?";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, idSousCategorie);  // Updated to String
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    sousCategorie = new SousCategorie(
                            resultSet.getString("IdSousCategorie"),  // Updated to String
                            resultSet.getString("NomSousCategorie")
                    );
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return sousCategorie;
    }

    // Insert a new SousCategorie
    public static void insert(String idSousCategorie, String nomSousCategorie) throws Exception {
        String query = "INSERT INTO SousCategorie (IdSousCategorie, NomSousCategorie) VALUES (?, ?)";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, idSousCategorie);  // Updated to String
            statement.setString(2, nomSousCategorie);
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    // Update an existing SousCategorie
    public static void update(SousCategorie sousCategorie) throws Exception {
        String query = "UPDATE SousCategorie SET NomSousCategorie = ? WHERE IdSousCategorie = ?";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, sousCategorie.getNomSousCategorie());
            statement.setString(2, sousCategorie.getIdSousCategorie());  // Updated to String
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    // Delete a SousCategorie by Id
    public static void delete(String idSousCategorie) throws Exception {
        String query = "DELETE FROM SousCategorie WHERE IdSousCategorie = ?";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, idSousCategorie);  // Updated to String
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
}
