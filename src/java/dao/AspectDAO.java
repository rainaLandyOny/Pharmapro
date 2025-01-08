/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connexion.Connexion;
import models.Aspect;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Raina
 */

import connexion.Connexion;
import models.Aspect;
import java.sql.*;
import java.util.ArrayList;

public class AspectDAO {

    // Get all Aspects
    public static ArrayList<Aspect> getAll() throws Exception {
        ArrayList<Aspect> aspects = new ArrayList<>();
        String query = "SELECT * FROM Aspect";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                aspects.add(new Aspect(
                        resultSet.getInt("IdAspect"), // Utilisation de getInt
                        resultSet.getString("NomAspect")
                ));
            }
        } catch (Exception e) {
            throw e;
        }
        return aspects;
    }

    // Get Aspect by Id
    public static Aspect getById(int idAspect) throws Exception {
        Aspect aspect = null;
        String query = "SELECT * FROM Aspect WHERE IdAspect = ?";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, idAspect); // Utilisation de setInt
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    aspect = new Aspect(
                            resultSet.getInt("IdAspect"), // Utilisation de getInt
                            resultSet.getString("NomAspect")
                    );
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return aspect;
    }

    // Insert a new Aspect
    public static void insert(String nomAspect) throws Exception {
        String query = "INSERT INTO Aspect (NomAspect) VALUES (?)";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, nomAspect);
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    // Update an existing Aspect
    public static void update(Aspect aspect) throws Exception {
        String query = "UPDATE Aspect SET NomAspect = ? WHERE IdAspect = ?";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, aspect.getNomAspect());
            statement.setInt(2, aspect.getIdAspect()); // Utilisation de setInt
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    // Delete an Aspect by Id
    public static void delete(int idAspect) throws Exception {
        String query = "DELETE FROM Aspect WHERE IdAspect = ?";

        try (Connection connection = Connexion.postgreS();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, idAspect); // Utilisation de setInt
            statement.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
}
