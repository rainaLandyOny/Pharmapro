/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import connexion.Connexion;
import models.DetailsVente;

import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Raina
 */
public class VenteDetailsDAO {

    // Get all DetailsVentes
    public static ArrayList<DetailsVente> getAll() throws Exception {
        ArrayList<DetailsVente> detailsVentes = new ArrayList<>();
        String query = "SELECT * FROM DetailsVente";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                detailsVentes.add(new DetailsVente(
                        resultSet.getString("IdDetailsVente"),
                        resultSet.getString("IdVente"),
                        resultSet.getString("IdProduit"),
                        resultSet.getInt("Quantite"),
                        resultSet.getDouble("Prix")
                ));
            }
        } catch (Exception e) {
            throw e;
        }
        return detailsVentes;
    }

    // Get DetailsVente by Vente Id
    public static ArrayList<DetailsVente> getByVenteId(String idVente) throws Exception {
        ArrayList<DetailsVente> detailsVentes = new ArrayList<>();
        String query = "SELECT * FROM DetailsVente WHERE IdVente = ?";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, idVente);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    detailsVentes.add(new DetailsVente(
                            resultSet.getString("IdDetailsVente"),
                            resultSet.getString("IdVente"),
                            resultSet.getString("IdProduit"),
                            resultSet.getInt("Quantite"),
                            resultSet.getDouble("Prix")
                    ));
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return detailsVentes;
    }

    // Insert a new DetailsVente
    public static void insert(String idDetailsVente, String idVente, String idProduit, int quantite, double prix) throws Exception {
        String query = "INSERT INTO DetailsVente (IdDetailsVente, IdVente, IdProduit, Quantite, Prix) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, idDetailsVente);
            statement.setString(2, idVente);
            statement.setString(3, idProduit);
            statement.setInt(4, quantite);
            statement.setDouble(5, prix);
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    // Update an existing DetailsVente
    public static void update(DetailsVente detailsVente) throws Exception {
        String query = "UPDATE DetailsVente SET Quantite = ?, Prix = ? WHERE IdDetailsVente = ?";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, detailsVente.getQuantite());
            statement.setDouble(2, detailsVente.getPrix());
            statement.setString(3, detailsVente.getIdDetailsVente());
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    // Delete a DetailsVente by IdDetailsVente
    public static void delete(String idDetailsVente) throws Exception {
        String query = "DELETE FROM DetailsVente WHERE IdDetailsVente = ?";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, idDetailsVente);
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
}
    
    
