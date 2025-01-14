/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.ConseilsDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Conseils;

/**
 *
 * @author Raina
 */
@WebServlet("/ConseilsServlet")
public class ConseilsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if (action == null || action.isEmpty()) {
                // Afficher tous les Conseils
                ArrayList<Conseils> conseils = ConseilsDAO.getAll();
                request.setAttribute("conseils", conseils);
                request.getRequestDispatcher("/conseils.jsp").forward(request, response);

            } else if (action.equals("getById")) {
                // Récupérer un Conseil par ID
                String idConseils = request.getParameter("id");
                Conseils conseil = ConseilsDAO.getById(idConseils);
                request.setAttribute("conseil", conseil);
                request.getRequestDispatcher("/detailConseil.jsp").forward(request, response);
            }
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erreur : " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if (action.equals("add")) {
                // Ajouter un Conseil
                String idConseils = request.getParameter("idConseils");
                String idProduit = request.getParameter("idProduit");
                Date moisEtAnne = java.sql.Date.valueOf(request.getParameter("moisEtAnne")); // Format: YYYY-MM-DD

                ConseilsDAO.insert(idConseils, idProduit, moisEtAnne);
                response.sendRedirect("ConseilsServlet");

            } else if (action.equals("update")) {
                // Mettre à jour un Conseil
                String idConseils = request.getParameter("idConseils");
                String idProduit = request.getParameter("idProduit");
                Date moisEtAnne = java.sql.Date.valueOf(request.getParameter("moisEtAnne"));

                Conseils conseil = new Conseils(idConseils, idProduit, moisEtAnne);
                ConseilsDAO.update(conseil);
                response.sendRedirect("ConseilsServlet");

            } else if (action.equals("delete")) {
                // Supprimer un Conseil
                String idConseils = request.getParameter("idConseils");
                ConseilsDAO.delete(idConseils);
                response.sendRedirect("ConseilsServlet");
            }
        } catch (Exception e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Erreur : " + e.getMessage());
        }
    }
}