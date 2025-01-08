/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connexion.Connexion;
import models.AspectProduit;

import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Raina
 */
public class AspectProduitDAO {
      // Get all AspectProduit
    public static ArrayList<AspectProduit> getAll() throws Exception {
        ArrayList<AspectProduit> aspectProduits = new ArrayList<>();
        String query = "SELECT * FROM AspectProduit";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                aspectProduits.add(new AspectProduit(
                        resultSet.getString("IdAspectProduit"),
                        resultSet.getInt("IdAspect"),
                        resultSet.getString("IdProduit")
                ));
            }
        } catch (Exception e) {
            throw e;
        }
        return aspectProduits;
    }

    // Get AspectProduit by ID
    public static AspectProduit getById(String idAspectProduit) throws Exception {
        AspectProduit aspectProduit = null;
        String query = "SELECT * FROM AspectProduit WHERE IdAspectProduit = ?";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, idAspectProduit);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    aspectProduit = new AspectProduit(
                            resultSet.getString("IdAspectProduit"),
                            resultSet.getInt("IdAspect"),
                            resultSet.getString("IdProduit")
                    );
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return aspectProduit;
    }

    // Insert a new AspectProduit
    public static void insert(AspectProduit aspectProduit) throws Exception {
        String query = "INSERT INTO AspectProduit (IdAspectProduit, IdAspect, IdProduit) VALUES (?, ?, ?)";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, aspectProduit.getIdAspectProduit());
            statement.setInt(2, aspectProduit.getIdAspect());
            statement.setString(3, aspectProduit.getIdProduit());
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    // Delete an AspectProduit by ID
    public static void delete(String idAspectProduit) throws Exception {
        String query = "DELETE FROM AspectProduit WHERE IdAspectProduit = ?";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, idAspectProduit);
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
}

