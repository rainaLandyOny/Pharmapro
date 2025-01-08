/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connexion.Connexion;
import models.Categorie;

import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Raina
 */
public class CategorieDAO {
    public static ArrayList<Categorie> getAll() throws Exception {
        ArrayList<Categorie> categories = new ArrayList<>();
        String query = "SELECT * FROM Categorie";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                categories.add(new Categorie(
                        resultSet.getInt("IdCategorie"),
                        resultSet.getString("NomCategorie")
                ));
            }
        } catch (Exception e) {
            throw e;
        }
        return categories;
    }

    // Get Category by Id
    public static Categorie getById(int idCategorie) throws Exception {
        Categorie categorie = null;
        String query = "SELECT * FROM Categorie WHERE IdCategorie = ?";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, idCategorie);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    categorie = new Categorie(
                            resultSet.getInt("IdCategorie"),
                            resultSet.getString("NomCategorie")
                    );
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return categorie;
    }

    // Insert a new Category
    public static void insert(String nomCategorie) throws Exception {
        String query = "INSERT INTO Categorie (NomCategorie) VALUES (?)";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, nomCategorie);
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    // Update an existing Category
    public static void update(Categorie categorie) throws Exception {
        String query = "UPDATE Categorie SET NomCategorie = ? WHERE IdCategorie = ?";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, categorie.getNomCategorie());
            statement.setInt(2, categorie.getIdCategorie());
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    // Delete a Category by Id
    public static void delete(int idCategorie) throws Exception {
        String query = "DELETE FROM Categorie WHERE IdCategorie = ?";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, idCategorie);
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
}
