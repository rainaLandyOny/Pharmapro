/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.ApprovisionnementDetailsDAO;
import models.ApprovisionnementDetails;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Raina
 */
@WebServlet("/ApprovisionnementDetailsServlet") // Mapping du servlet à l'URL /ApprovisionnementDetailsServlet
public class ApprovisionnementDetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if (action == null) {
                // Afficher tous les détails d'approvisionnement
                ArrayList<ApprovisionnementDetails> approvisionnementDetails = ApprovisionnementDetailsDAO.getAll();
                request.setAttribute("approvisionnementDetails", approvisionnementDetails);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/approvisionnementDetails.jsp");
                dispatcher.forward(request, response);
            } else if (action.equals("edit")) {
                // Afficher un détail d'approvisionnement spécifique pour modification
                String idApprovisionnementDetails = request.getParameter("idApprovisionnementDetails");
                ApprovisionnementDetails approvisionnementDetail = ApprovisionnementDetailsDAO.getById(idApprovisionnementDetails);
                request.setAttribute("approvisionnementDetail", approvisionnementDetail);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/editApprovisionnementDetails.jsp");
                dispatcher.forward(request, response);
            } else if (action.equals("delete")) {
                // Supprimer un détail d'approvisionnement
                String idApprovisionnementDetails = request.getParameter("idApprovisionnementDetails");
                ApprovisionnementDetailsDAO.delete(idApprovisionnementDetails);
                response.sendRedirect("ApprovisionnementDetailsServlet");
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
                // Ajouter un nouveau détail d'approvisionnement
                String idApprovisionnementDetails = request.getParameter("idApprovisionnementDetails");
                String idApprovisionnement = request.getParameter("idApprovisionnement");
                String idFournisseur = request.getParameter("idFournisseur");
                double quantite = Double.parseDouble(request.getParameter("quantite"));
                double prix = Double.parseDouble(request.getParameter("prix"));
                double total = quantite * prix;
                java.sql.Date datePeremption = java.sql.Date.valueOf(request.getParameter("datePeremption"));

                ApprovisionnementDetails approvisionnementDetail = new ApprovisionnementDetails(
                        idApprovisionnementDetails, idApprovisionnement, idFournisseur, 
                        java.math.BigDecimal.valueOf(quantite), java.math.BigDecimal.valueOf(prix), 
                        java.math.BigDecimal.valueOf(total), datePeremption);

                ApprovisionnementDetailsDAO.insert(approvisionnementDetail);
                response.sendRedirect("ApprovisionnementDetailsServlet");
            } else if (action.equals("update")) {
                // Mettre à jour un détail d'approvisionnement
                String idApprovisionnementDetails = request.getParameter("idApprovisionnementDetails");
                String idApprovisionnement = request.getParameter("idApprovisionnement");
                String idFournisseur = request.getParameter("idFournisseur");
                double quantite = Double.parseDouble(request.getParameter("quantite"));
                double prix = Double.parseDouble(request.getParameter("prix"));
                double total = quantite * prix;
                java.sql.Date datePeremption = java.sql.Date.valueOf(request.getParameter("datePeremption"));

                ApprovisionnementDetails approvisionnementDetail = new ApprovisionnementDetails(
                        idApprovisionnementDetails, idApprovisionnement, idFournisseur, 
                        java.math.BigDecimal.valueOf(quantite), java.math.BigDecimal.valueOf(prix), 
                        java.math.BigDecimal.valueOf(total), datePeremption);

                ApprovisionnementDetailsDAO.update(approvisionnementDetail);
                response.sendRedirect("ApprovisionnementDetailsServlet");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
