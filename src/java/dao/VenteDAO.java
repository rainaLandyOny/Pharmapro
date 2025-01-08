/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connexion.Connexion;
import models.Vente;

import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Raina
 */
public class VenteDAO {
     // Get all Ventes
    public static ArrayList<Vente> getAll() throws Exception {
        ArrayList<Vente> ventes = new ArrayList<>();
        String query = "SELECT * FROM Vente";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                ventes.add(new Vente(
                        resultSet.getString("IdVente"),
                        resultSet.getTimestamp("DateVente"),
                        resultSet.getDouble("Total")
                ));
            }
        } catch (Exception e) {
            throw e;
        }
        return ventes;
    }

    // Get Vente by Id
    public static Vente getById(String idVente) throws Exception {
        Vente vente = null;
        String query = "SELECT * FROM Vente WHERE IdVente = ?";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, idVente);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    vente = new Vente(
                            resultSet.getString("IdVente"),
                            resultSet.getTimestamp("DateVente"),
                            resultSet.getDouble("Total")
                    );
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return vente;
    }

    // Insert a new Vente
    public static void insert(String idVente, Timestamp dateVente, double total) throws Exception {
        String query = "INSERT INTO Vente (IdVente, DateVente, Total) VALUES (?, ?, ?)";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, idVente);
            statement.setTimestamp(2, dateVente);
            statement.setDouble(3, total);
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    // Update an existing Vente
    public static void update(Vente vente) throws Exception {
        String query = "UPDATE Vente SET DateVente = ?, Total = ? WHERE IdVente = ?";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setTimestamp(1, (Timestamp) vente.getDateVente());
            statement.setDouble(2, vente.getMontantTotal());
            statement.setString(3, vente.getIdVente());
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    // Delete a Vente by Id
    public static void delete(String idVente) throws Exception {
        String query = "DELETE FROM Vente WHERE IdVente = ?";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, idVente);
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    // Méthode pour récupérer l'historique des ventes
    public static ArrayList<Vente> getHistoriqueVentes() throws Exception {
        ArrayList<Vente> ventes = new ArrayList<>();
        String query = "SELECT * FROM Vente ORDER BY dateVente DESC";  // Récupérer par ordre décroissant de date

        try (Connection connection = Connexion.postgreS();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                ventes.add(new Vente(
                        resultSet.getString("idVente"),
                        resultSet.getDate("dateVente"),
                        resultSet.getDouble("montantTotal")
                ));
            }
        } catch (Exception e) {
            throw e;
        }
        return ventes;
    }
}
