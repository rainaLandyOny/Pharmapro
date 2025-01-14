/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import connexion.Connexion;
import java.sql.Date;
import models.Conseils;

/**
 *
 * @author Raina
 */
public class ConseilsDAO {
     // Récupérer tous les Conseils
    public static ArrayList<Conseils> getAll() throws Exception {
        ArrayList<Conseils> conseils = new ArrayList<>();
        String query = "SELECT * FROM Conseils";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                conseils.add(new Conseils(
                        resultSet.getString("IdConseils"),
                        resultSet.getString("IdProduit"),
                        resultSet.getDate("MoisetAnne")
                ));
            }
        } catch (Exception e) {
            throw e;
        }
        return conseils;
    }

    // Récupérer un Conseil par Id
    public static Conseils getById(String idConseils) throws Exception {
        Conseils conseil = null;
        String query = "SELECT * FROM Conseils WHERE IdConseils = ?";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, idConseils);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    conseil = new Conseils(
                            resultSet.getString("IdConseils"),
                            resultSet.getString("IdProduit"),
                            resultSet.getDate("MoisetAnne")
                    );
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return conseil;
    }

    // Insérer un nouveau Conseil
    public static void insert(String idConseils, String idProduit, Date moisEtAnne) throws Exception {
        String query = "INSERT INTO Conseils (IdConseils, IdProduit, MoisetAnne) VALUES (?, ?, ?)";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, idConseils);
            statement.setString(2, idProduit);
            statement.setDate(3, new java.sql.Date(moisEtAnne.getTime()));
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    // Mettre à jour un Conseil existant
    public static void update(Conseils conseil) throws Exception {
        String query = "UPDATE Conseils SET IdProduit = ?, MoisetAnne = ? WHERE IdConseils = ?";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, conseil.getIdProduit());
            statement.setDate(2, new java.sql.Date(conseil.getMoisEtAnne().getTime()));
            statement.setString(3, conseil.getIdConseils());
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    // Supprimer un Conseil par Id
    public static void delete(String idConseils) throws Exception {
        String query = "DELETE FROM Conseils WHERE IdConseils = ?";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, idConseils);
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    
     public static ArrayList<Conseils> getByMonthAndYear(String moisAnne) throws Exception {
        ArrayList<Conseils> conseilsList = new ArrayList<>();
        String query = "SELECT * FROM Conseils WHERE MoisetAnne = ?";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, moisAnne);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    conseilsList.add(new Conseils(
                            resultSet.getString("IdConseils"),
                            resultSet.getString("IdProduit"),
                            resultSet.getDate("MoisetAnne")
                    ));
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return conseilsList;
    }
    
}
