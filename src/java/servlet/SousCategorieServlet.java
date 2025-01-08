/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.SousCategorieDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.SousCategorie;

/**
 *
 * @author Raina
 */
@WebServlet("/SousCategorieServlet") // Mapping du servlet à l'URL /SousCategorieServlet
public class SousCategorieServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if (action == null) {
                // Afficher toutes les sous-catégories
                ArrayList<SousCategorie> sousCategories = SousCategorieDAO.getAll();
                request.setAttribute("sousCategories", sousCategories);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/sousCategorie.jsp");
                dispatcher.forward(request, response);
            } else if (action.equals("edit")) {
                // Afficher une sous-catégorie spécifique pour modification
                String idSousCategorie = request.getParameter("id");
                SousCategorie sousCategorie = SousCategorieDAO.getById(idSousCategorie);
                request.setAttribute("sousCategorie", sousCategorie);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/editSousCategorie.jsp");
                dispatcher.forward(request, response);
            } else if (action.equals("delete")) {
                // Supprimer une sous-catégorie
                String idSousCategorie = request.getParameter("id");
                SousCategorieDAO.delete(idSousCategorie);
                response.sendRedirect("SousCategorieServlet");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if (action.equals("add")) {
                // Ajouter une nouvelle sous-catégorie
                String idSousCategorie = request.getParameter("idSousCategorie");
                String nomSousCategorie = request.getParameter("nomSousCategorie");
                SousCategorieDAO.insert(idSousCategorie, nomSousCategorie);
                response.sendRedirect("SousCategorieServlet");
            } else if (action.equals("update")) {
                // Mettre à jour une sous-catégorie
                String idSousCategorie = request.getParameter("idSousCategorie");
                String nomSousCategorie = request.getParameter("nomSousCategorie");
                SousCategorie sousCategorie = new SousCategorie(idSousCategorie, nomSousCategorie);
                SousCategorieDAO.update(sousCategorie);
                response.sendRedirect("SousCategorieServlet");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
