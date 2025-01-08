/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Raina
 */


import connexion.Connexion;
import models.Fournisseur;

import java.sql.*;
import java.util.ArrayList;

public class FournisseurDAO {

    // Get all Fournisseurs
    public static ArrayList<Fournisseur> getAll() throws Exception {
        ArrayList<Fournisseur> fournisseurs = new ArrayList<>();
        String query = "SELECT * FROM Fournisseur";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                fournisseurs.add(new Fournisseur(
                        resultSet.getString("IdFournisseur"),
                        resultSet.getString("NomFournisseur"),
                        resultSet.getString("AdresseFournisseur")
                ));
            }
        } catch (Exception e) {
            throw e;
        }
        return fournisseurs;
    }

    // Get Fournisseur by Id
    public static Fournisseur getById(String idFournisseur) throws Exception {
        Fournisseur fournisseur = null;
        String query = "SELECT * FROM Fournisseur WHERE IdFournisseur = ?";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, idFournisseur);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    fournisseur = new Fournisseur(
                            resultSet.getString("IdFournisseur"),
                            resultSet.getString("NomFournisseur"),
                            resultSet.getString("AdresseFournisseur")
                    );
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return fournisseur;
    }

    // Insert a new Fournisseur
    public static void insert(String nomFournisseur, String adresseFournisseur) throws Exception {
        String query = "INSERT INTO Fournisseur (NomFournisseur, AdresseFournisseur) VALUES (?, ?)";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, nomFournisseur);
            statement.setString(2, adresseFournisseur);
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    // Update an existing Fournisseur
    public static void update(Fournisseur fournisseur) throws Exception {
        String query = "UPDATE Fournisseur SET NomFournisseur = ?, AdresseFournisseur = ? WHERE IdFournisseur = ?";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, fournisseur.getNomFournisseur());
            statement.setString(2, fournisseur.getAdresseFournisseur());
            statement.setString(3, fournisseur.getidFournisseur());
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    // Delete a Fournisseur by Id
    public static void delete(String idFournisseur) throws Exception {
        String query = "DELETE FROM Fournisseur WHERE IdFournisseur = ?";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, idFournisseur);
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    
      // Recherche par nom
    public static ArrayList<Fournisseur> rechercherParNom(String nomFournisseur) throws Exception {
        ArrayList<Fournisseur> fournisseurs = new ArrayList<>();
        String query = "SELECT * FROM Fournisseur WHERE NomFournisseur LIKE ?";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, "%" + nomFournisseur + "%"); // Recherche avec LIKE
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    fournisseurs.add(new Fournisseur(
                            resultSet.getString("IdFournisseur"),
                            resultSet.getString("NomFournisseur"),
                            resultSet.getString("AdresseFournisseur")
                         
                    ));
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return fournisseurs;
    }

    // Recherche par adresse
    public static ArrayList<Fournisseur> rechercherParAdresse(String adresseFournisseur) throws Exception {
        ArrayList<Fournisseur> fournisseurs = new ArrayList<>();
        String query = "SELECT * FROM Fournisseur WHERE AdresseFournisseur LIKE ?";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, "%" + adresseFournisseur + "%"); // Recherche avec LIKE
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    fournisseurs.add(new Fournisseur(
                            resultSet.getString("IdFournisseur"),
                            resultSet.getString("NomFournisseur"),
                            resultSet.getString("AdresseFournisseur")
                           
                    ));
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return fournisseurs;
    }
}

