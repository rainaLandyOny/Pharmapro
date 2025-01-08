/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;
import dao.VenteDetailsDAO;
import models.DetailsVente;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author Raina
 */
@WebServlet("/VenteDetailsServlet")
public class VenteDetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if (action == null) {
                // Display all vente details
                ArrayList<DetailsVente> detailsVentes = VenteDetailsDAO.getAll();
                request.setAttribute("detailsVentes", detailsVentes);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/venteDetails.jsp");
                dispatcher.forward(request, response);
            } else if ("edit".equals(action)) {
                // Display a specific vente detail for editing
                String idVente = request.getParameter("idDetailsVente");
                ArrayList<DetailsVente> detailsVente = VenteDetailsDAO.getByVenteId(idVente);
                request.setAttribute("detailsVente", detailsVente);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/editVenteDetails.jsp");
                dispatcher.forward(request, response);
            } else if ("delete".equals(action)) {
                // Delete a specific vente detail
                String idDetailsVente = request.getParameter("idDetailsVente");
                VenteDetailsDAO.delete(idDetailsVente);
                response.sendRedirect("VenteDetailsServlet");
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
            if ("add".equals(action)) {
                // Add a new vente detail
                String idDetailsVente = request.getParameter("idDetailsVente");
                String idVente = request.getParameter("idVente");
                String idProduit = request.getParameter("idProduit");
                int quantite = Integer.parseInt(request.getParameter("quantite"));
                double prix = Double.parseDouble(request.getParameter("prix"));
                
                VenteDetailsDAO.insert(idDetailsVente, idVente, idProduit, quantite, prix);
                response.sendRedirect("VenteDetailsServlet");
            } else if ("update".equals(action)) {
                // Update an existing vente detail
                String idDetailsVente = request.getParameter("idDetailsVente");
                String idVente = request.getParameter("idVente");
                String idProduit = request.getParameter("idProduit");
                int quantite = Integer.parseInt(request.getParameter("quantite"));
                double prix = Double.parseDouble(request.getParameter("prix"));

                DetailsVente detailsVente = new DetailsVente(idDetailsVente, idVente, idProduit, quantite, prix);
                VenteDetailsDAO.update(detailsVente);
                response.sendRedirect("VenteDetailsServlet");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
