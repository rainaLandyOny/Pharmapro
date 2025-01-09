/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connexion.Connexion;
import models.Produit;

import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Raina
 */
public class ProduitDAO {
    // Get all products
    public static ArrayList<Produit> getAll() throws Exception {
        ArrayList<Produit> produits = new ArrayList<>();
        String query = "SELECT * FROM Produit";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                produits.add(new Produit(
                        resultSet.getString("IdProduit"),
                        resultSet.getString("NomProduit"),
                        resultSet.getDouble("PrixProduit"),
                        resultSet.getString("IdFournisseur"),
                        resultSet.getInt("IdCategorie"),
                        resultSet.getInt("IdSousCategorie"),
                        resultSet.getDate("Date_fabrication"),
                        resultSet.getString("Description")
                ));
            }
        } catch (Exception e) {
            throw e;
        }
        return produits;
    }

    // Get product by ID
    public static Produit getById(String idProduit) throws Exception {
        Produit produit = null;
        String query = "SELECT * FROM Produit WHERE IdProduit = ?";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, idProduit);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    produit = new Produit(
                            resultSet.getString("IdProduit"),
                            resultSet.getString("NomProduit"),
                            resultSet.getDouble("PrixProduit"),
                            resultSet.getString("IdFournisseur"),
                            resultSet.getInt("IdCategorie"),
                            resultSet.getInt("IdSousCategorie"),
                            resultSet.getDate("Date_fabrication"),
                            resultSet.getString("Description")
                    );
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return produit;
    }

    // Insert a new product
    public static void insert(Produit produit) throws Exception {
        String query = "INSERT INTO Produit (IdProduit, NomProduit, PrixProduit, IdFournisseur, IdCategorie, IdSousCategorie, Date_fabrication, Description) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, produit.getIdProduit());
            statement.setString(2, produit.getNomProduit());
            statement.setDouble(3, produit.getPrixProduit());
            statement.setString(4, produit.getIdFournisseur());
            statement.setInt(5, produit.getIdCategorie());
            statement.setInt(6, produit.getIdSousCategorie());
            statement.setDate(7, new java.sql.Date(produit.getDateFabrication().getTime()));
            statement.setString(8, produit.getDescription());
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    // Update an existing product
    public static void update(Produit produit) throws Exception {
        String query = "UPDATE Produit SET NomProduit = ?, PrixProduit = ?, IdFournisseur = ?, IdCategorie = ?, IdSousCategorie = ?, Date_fabrication = ?, Description = ? WHERE IdProduit = ?";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, produit.getNomProduit());
            statement.setDouble(2, produit.getPrixProduit());
            statement.setString(3, produit.getIdFournisseur());
            statement.setInt(4, produit.getIdCategorie());
            statement.setInt(5, produit.getIdSousCategorie());
            statement.setDate(6, new java.sql.Date(produit.getDateFabrication().getTime()));
            statement.setString(7, produit.getDescription());
            statement.setString(8, produit.getIdProduit());
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    // Delete a product by ID
    public static void delete(String idProduit) throws Exception {
        String query = "DELETE FROM Produit WHERE IdProduit = ?";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, idProduit);
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    
    
}