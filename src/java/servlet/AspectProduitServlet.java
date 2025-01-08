/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;


import dao.AspectProduitDAO;
import models.AspectProduit;

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
@WebServlet("/AspectProduitServlet")
public class AspectProduitServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if (action.equals("list") ) {
                // List all AspectProduit
                ArrayList<AspectProduit> aspectProduits = AspectProduitDAO.getAll();
                request.setAttribute("aspectProduits", aspectProduits);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/aspectProduitList.jsp");
                dispatcher.forward(request, response);
            } else if (action.equals("delete")) {
                // Delete a specific AspectProduit
                String idAspectProduit = request.getParameter("idAspectProduit");
                AspectProduitDAO.delete(idAspectProduit);
                response.sendRedirect("AspectProduitServlet");
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
                // Add a new AspectProduit
                String idAspectProduit = request.getParameter("idAspectProduit");
                int idAspect = Integer.parseInt(request.getParameter("idAspect"));
                String idProduit = request.getParameter("idProduit");

                AspectProduit aspectProduit = new AspectProduit(idAspectProduit, idAspect, idProduit);
                AspectProduitDAO.insert(aspectProduit);
                response.sendRedirect("AspectProduitServlet");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
