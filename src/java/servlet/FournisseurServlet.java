/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.FournisseurDAO;
import models.Fournisseur;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Raina
 */

@WebServlet("/fournisseur")
public class FournisseurServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if (action == null) {
                // Afficher tous les fournisseurs
                ArrayList<Fournisseur> fournisseurs = FournisseurDAO.getAll();
                request.setAttribute("fournisseurs", fournisseurs);
                request.getRequestDispatcher("/fournisseur/list.jsp").forward(request, response);
            } else if (action.equals("rechercherParNom")) {
                // Recherche par nom
                String nom = request.getParameter("nom");
                if (nom != null) {
                    ArrayList<Fournisseur> fournisseurs = FournisseurDAO.rechercherParNom(nom);
                    request.setAttribute("fournisseurs", fournisseurs);
                }
                request.getRequestDispatcher("/fournisseur/list.jsp").forward(request, response);
            } else if (action.equals("rechercherParAdresse")) {
                // Recherche par adresse
                String adresse = request.getParameter("adresse");
                if (adresse != null) {
                    ArrayList<Fournisseur> fournisseurs = FournisseurDAO.rechercherParAdresse(adresse);
                    request.setAttribute("fournisseurs", fournisseurs);
                }
                request.getRequestDispatcher("/fournisseur/list.jsp").forward(request, response);
            } else if (action.equals("edit")) {
                // Afficher les informations d'un fournisseur pour modification
                String idFournisseur = request.getParameter("id");
                Fournisseur fournisseur = FournisseurDAO.getById(idFournisseur);
                request.setAttribute("fournisseur", fournisseur);
                request.getRequestDispatcher("/fournisseur/edit.jsp").forward(request, response);
            } else if (action.equals("delete")) {
                // Supprimer un fournisseur
                String idFournisseur = request.getParameter("id");
                FournisseurDAO.delete(idFournisseur);
                response.sendRedirect(request.getContextPath() + "/fournisseur");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Une erreur s'est produite lors de l'opération.");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if (action.equals("add")) {
                // Ajouter un fournisseur
                String nomFournisseur = request.getParameter("nomFournisseur");
                String adresseFournisseur = request.getParameter("adresseFournisseur");
                FournisseurDAO.insert(nomFournisseur, adresseFournisseur);
                response.sendRedirect(request.getContextPath() + "/fournisseur");
            } else if (action.equals("update")) {
                // Mettre à jour un fournisseur
                String idFournisseur = request.getParameter("idFournisseur");
                String nomFournisseur = request.getParameter("nomFournisseur");
                String adresseFournisseur = request.getParameter("adresseFournisseur");

                Fournisseur fournisseur = new Fournisseur(idFournisseur, nomFournisseur, adresseFournisseur);
                FournisseurDAO.update(fournisseur);
                response.sendRedirect(request.getContextPath() + "/fournisseur");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Une erreur s'est produite lors de l'opération.");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}

