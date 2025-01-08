/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.UniteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Unite;

/**
 *
 * @author Raina
 */
@WebServlet("/UniteServlet") // Mapping du servlet à l'URL /UniteServlet
public class UniteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if (action == null) {
                // Afficher toutes les unités
                ArrayList<Unite> unites = UniteDAO.getAll();
                request.setAttribute("unites", unites);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/unite.jsp");
                dispatcher.forward(request, response);
            } else if (action.equals("edit")) {
                // Afficher une unité spécifique pour modification
                String idUnite = request.getParameter("id");
                Unite unite = UniteDAO.getById(idUnite);
                request.setAttribute("unite", unite);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/editUnite.jsp");
                dispatcher.forward(request, response);
            } else if (action.equals("delete")) {
                // Supprimer une unité
                String idUnite = request.getParameter("id");
                UniteDAO.delete(idUnite);
                response.sendRedirect("UniteServlet");
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
                // Ajouter une nouvelle unité
                String nomUnite = request.getParameter("nomUnite");
                UniteDAO.insert(nomUnite);
                response.sendRedirect("UniteServlet");
            } else if (action.equals("update")) {
                // Mettre à jour une unité
                String idUnite = request.getParameter("idUnite");
                String nomUnite = request.getParameter("nomUnite");
                Unite unite = new Unite(idUnite, nomUnite);
                UniteDAO.update(unite);
                response.sendRedirect("UniteServlet");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
