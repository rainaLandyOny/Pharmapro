/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import connexion.Connexion;
import models.CategorieSousCategorie;

import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Raina
 */
public class CategorieSousCategorieDAO {

    // Get all relations
    public static ArrayList<CategorieSousCategorie> getAll() throws Exception {
        ArrayList<CategorieSousCategorie> relations = new ArrayList<>();
        String query = "SELECT * FROM CategorieSousCategorie";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                relations.add(new CategorieSousCategorie(
                        resultSet.getInt("IdCategorieSousCategorie"),
                        resultSet.getInt("IdCategorie"),
                        resultSet.getInt("IdSousCategorie")
                ));
            }
        } catch (Exception e) {
            throw e;
        }
        return relations;
    }

    // Get relation by IdCategorieSousCategorie
    public static CategorieSousCategorie getById(int idCategorieSousCategorie) throws Exception {
        CategorieSousCategorie relation = null;
        String query = "SELECT * FROM CategorieSousCategorie WHERE IdCategorieSousCategorie = ?";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, idCategorieSousCategorie);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    relation = new CategorieSousCategorie(
                            resultSet.getInt("IdCategorieSousCategorie"),
                            resultSet.getInt("IdCategorie"),
                            resultSet.getInt("IdSousCategorie")
                    );
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return relation;
    }

    // Insert a new relation
    public static void insert(int idCategorie, int idSousCategorie) throws Exception {
        String query = "INSERT INTO CategorieSousCategorie (IdCategorie, IdSousCategorie) VALUES (?, ?)";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, idCategorie);
            statement.setInt(2, idSousCategorie);
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    // Update an existing relation
    public static void update(int idCategorieSousCategorie, int idCategorie, int idSousCategorie) throws Exception {
        String query = "UPDATE CategorieSousCategorie SET IdCategorie = ?, IdSousCategorie = ? WHERE IdCategorieSousCategorie = ?";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, idCategorie);
            statement.setInt(2, idSousCategorie);
            statement.setInt(3, idCategorieSousCategorie);
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    // Delete a relation
    public static void delete(int idCategorieSousCategorie) throws Exception {
        String query = "DELETE FROM CategorieSousCategorie WHERE IdCategorieSousCategorie = ?";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, idCategorieSousCategorie);
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
}