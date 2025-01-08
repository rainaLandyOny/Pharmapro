/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import connexion.Connexion;
import models.SousCategorieProduit;

import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Raina
 */
public class SousCategorieProduitDAO {
       // Get all relations
    public static ArrayList<SousCategorieProduit> getAll() throws Exception {
        ArrayList<SousCategorieProduit> relations = new ArrayList<>();
        String query = "SELECT * FROM SousCategorieProduit";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                relations.add(new SousCategorieProduit(
                        resultSet.getInt("IdSousCategorie"),
                        resultSet.getString("IdProduit")
                ));
            }
        } catch (Exception e) {
            throw e;
        }
        return relations;
    }

    // Get relation by IdSousCategorie and IdProduit
    public static SousCategorieProduit getByIds(int idSousCategorie, String idProduit) throws Exception {
        SousCategorieProduit relation = null;
        String query = "SELECT * FROM SousCategorieProduit WHERE IdSousCategorie = ? AND IdProduit = ?";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, idSousCategorie);
            statement.setString(2, idProduit);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    relation = new SousCategorieProduit(
                            resultSet.getInt("IdSousCategorie"),
                            resultSet.getString("IdProduit")
                    );
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return relation;
    }

    // Insert a new relation
    public static void insert(int idSousCategorie, String idProduit) throws Exception {
        String query = "INSERT INTO SousCategorieProduit (IdSousCategorie, IdProduit) VALUES (?, ?)";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, idSousCategorie);
            statement.setString(2, idProduit);
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    // Update an existing relation (example: if IdProduit changes)
    public static void update(int idSousCategorie, String oldIdProduit, String newIdProduit) throws Exception {
        String query = "UPDATE SousCategorieProduit SET IdProduit = ? WHERE IdSousCategorie = ? AND IdProduit = ?";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, newIdProduit);
            statement.setInt(2, idSousCategorie);
            statement.setString(3, oldIdProduit);
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    // Delete a relation
    public static void delete(int idSousCategorie, String idProduit) throws Exception {
        String query = "DELETE FROM SousCategorieProduit WHERE IdSousCategorie = ? AND IdProduit = ?";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, idSousCategorie);
            statement.setString(2, idProduit);
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
}
