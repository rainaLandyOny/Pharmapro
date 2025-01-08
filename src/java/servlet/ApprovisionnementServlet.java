/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.ApprovisionnementDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Approvisionnement;

/**
 *
 * @author Raina
 */
@WebServlet("/ApprovisionnementServlet") // Mapping de l'URL pour ce servlet
public class ApprovisionnementServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if (action == null) {
                // Afficher tous les approvisionnements
                ArrayList<Approvisionnement> approvisionnements = ApprovisionnementDAO.getAll();
                request.setAttribute("approvisionnements", approvisionnements);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/approvisionnement.jsp");
                dispatcher.forward(request, response);
            } else if (action.equals("edit")) {
                // Afficher un approvisionnement spécifique pour modification
                String idApprovisionnement = request.getParameter("id");
                Approvisionnement approvisionnement = ApprovisionnementDAO.getById(idApprovisionnement);
                request.setAttribute("approvisionnement", approvisionnement);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/editApprovisionnement.jsp");
                dispatcher.forward(request, response);
            } else if (action.equals("delete")) {
                // Supprimer un approvisionnement
                String idApprovisionnement = request.getParameter("id");
                ApprovisionnementDAO.delete(idApprovisionnement);
                response.sendRedirect("ApprovisionnementServlet");
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
                // Ajouter un nouvel approvisionnement
                String idApprovisionnement = request.getParameter("idApprovisionnement");
                String idProduit = request.getParameter("idProduit");
                Date dateApprovisionnement = Date.valueOf(request.getParameter("dateApprovisionnement"));
                ApprovisionnementDAO.insert(idApprovisionnement, idProduit, dateApprovisionnement);
                response.sendRedirect("ApprovisionnementServlet");
            } else if (action.equals("update")) {
                // Mettre à jour un approvisionnement
                String idApprovisionnement = request.getParameter("idApprovisionnement");
                String idProduit = request.getParameter("idProduit");
                Date dateApprovisionnement = Date.valueOf(request.getParameter("dateApprovisionnement"));
                Approvisionnement approvisionnement = new Approvisionnement(idApprovisionnement, idProduit, dateApprovisionnement);
                ApprovisionnementDAO.update(approvisionnement);
                response.sendRedirect("ApprovisionnementServlet");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
