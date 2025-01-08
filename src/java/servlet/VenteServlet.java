/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;
import dao.VenteDAO;
import models.Vente;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
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

@WebServlet("/VenteServlet")
public class VenteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if ("list".equals(action)) {
                // Get all ventes
                ArrayList<Vente> ventes = VenteDAO.getAll();
                request.setAttribute("ventes", ventes);
                request.getRequestDispatcher("/listVentes.jsp").forward(request, response);
            } else if ("show".equals(action)) {
                // Get a vente by Id
                String idVente = request.getParameter("idVente");
                Vente vente = VenteDAO.getById(idVente);
                request.setAttribute("vente", vente);
                request.getRequestDispatcher("/showVente.jsp").forward(request, response);
            } else if ("historique".equals(action)) {
                // Get historical ventes
                ArrayList<Vente> historiqueVentes = VenteDAO.getHistoriqueVentes();
                request.setAttribute("historiqueVentes", historiqueVentes);
                request.getRequestDispatcher("/historiqueVentes.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error fetching data");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if ("insert".equals(action)) {
                // Insert new vente
                String idVente = request.getParameter("idVente");
                Timestamp dateVente = Timestamp.valueOf(request.getParameter("dateVente"));
                double total = Double.parseDouble(request.getParameter("total"));

                VenteDAO.insert(idVente, dateVente, total);
                response.sendRedirect("VenteServlet?action=list");
            } else if ("update".equals(action)) {
                // Update an existing vente
                String idVente = request.getParameter("idVente");
                Timestamp dateVente = Timestamp.valueOf(request.getParameter("dateVente"));
                double total = Double.parseDouble(request.getParameter("total"));

                Vente vente = new Vente(idVente, dateVente, total);
                VenteDAO.update(vente);
                response.sendRedirect("VenteServlet?action=list");
            } else if ("delete".equals(action)) {
                // Delete vente by Id
                String idVente = request.getParameter("idVente");
                VenteDAO.delete(idVente);
                response.sendRedirect("VenteServlet?action=list");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error processing data");
        }
    }
}
