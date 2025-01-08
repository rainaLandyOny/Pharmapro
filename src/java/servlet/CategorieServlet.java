/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.CategorieDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Categorie;

/**
 *
 * @author Raina
 */
@WebServlet("/CategorieServlet") // Mapping de l'URL pour ce servlet
public class CategorieServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if (action.equals("list") ) {
                // Afficher toutes les catégories
                ArrayList<Categorie> categories = CategorieDAO.getAll();
                request.setAttribute("categories", categories);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/categorie.jsp");
                dispatcher.forward(request, response);
            } else if (action.equals("edit")) {
                // Afficher une catégorie spécifique pour modification
                int idCategorie = Integer.parseInt(request.getParameter("id"));
                Categorie categorie = CategorieDAO.getById(idCategorie);
                request.setAttribute("categorie", categorie);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/editCategorie.jsp");
                dispatcher.forward(request, response);
            } else if (action.equals("delete")) {
                // Supprimer une catégorie
                int idCategorie = Integer.parseInt(request.getParameter("id"));
                CategorieDAO.delete(idCategorie);
                response.sendRedirect("CategorieServlet");
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
                // Ajouter une nouvelle catégorie
                String nomCategorie = request.getParameter("nomCategorie");
                CategorieDAO.insert(nomCategorie);
                response.sendRedirect("CategorieServlet");
            } else if (action.equals("update")) {
                // Mettre à jour une catégorie
                int idCategorie = Integer.parseInt(request.getParameter("idCategorie"));
                String nomCategorie = request.getParameter("nomCategorie");
                Categorie categorie = new Categorie(idCategorie, nomCategorie);
                CategorieDAO.update(categorie);
                response.sendRedirect("CategorieServlet");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}