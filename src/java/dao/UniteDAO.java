/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import connexion.Connexion;
import models.Unite;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Raina
 */
public class UniteDAO {
       // Get all Unites
    public static ArrayList<Unite> getAll() throws Exception {
        ArrayList<Unite> unites = new ArrayList<>();
        String query = "SELECT * FROM Unite";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                unites.add(new Unite(
                        resultSet.getString("IdUnite"),
                        resultSet.getString("NomUnite")
                ));
            }
        } catch (Exception e) {
            throw e;
        }
        return unites;
    }

    // Get Unite by Id
    public static Unite getById(String idUnite) throws Exception {
        Unite unite = null;
        String query = "SELECT * FROM Unite WHERE IdUnite = ?";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, idUnite);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    unite = new Unite(
                            resultSet.getString("IdUnite"),
                            resultSet.getString("NomUnite")
                    );
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return unite;
    }

    // Insert a new Unite
    public static void insert(String nomUnite) throws Exception {
        String query = "INSERT INTO Unite (NomUnite) VALUES (?)";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, nomUnite);
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    // Update an existing Unite
    public static void update(Unite unite) throws Exception {
        String query = "UPDATE Unite SET NomUnite = ? WHERE IdUnite = ?";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, unite.getNomUnite());
            statement.setString(2, unite.getIdUnite());
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    // Delete a Unite by Id
    public static void delete(String idUnite) throws Exception {
        String query = "DELETE FROM Unite WHERE IdUnite = ?";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, idUnite);
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
}
