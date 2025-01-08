/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;
import dao.ProduitDAO;
import models.Produit;
        
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
@WebServlet("/ProduitServlet")
public class ProduitServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if (action.equals("list")) {
                // List all products
                ArrayList<Produit> produits = ProduitDAO.getAll();
                request.setAttribute("produits", produits);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/produitList.jsp");
                dispatcher.forward(request, response);
            } else if (action.equals("edit")) {
                // Edit a specific product
                String idProduit = request.getParameter("idProduit");
                Produit produit = ProduitDAO.getById(idProduit);
                request.setAttribute("produit", produit);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/editProduit.jsp");
                dispatcher.forward(request, response);
            } else if (action.equals("delete")) {
                // Delete a specific product
                String idProduit = request.getParameter("idProduit");
                ProduitDAO.delete(idProduit);
                response.sendRedirect("ProduitServlet");
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
                // Add a new product
                String idProduit = request.getParameter("idProduit");
                String nomProduit = request.getParameter("nomProduit");
                double prixProduit = Double.parseDouble(request.getParameter("prixProduit"));
                String idFournisseur = request.getParameter("idFournisseur");
                java.sql.Date dateFabrication = java.sql.Date.valueOf(request.getParameter("dateFabrication"));
                String description = request.getParameter("description");

                Produit produit = new Produit(idProduit, nomProduit, prixProduit, idFournisseur, dateFabrication, description);
                ProduitDAO.insert(produit);
                response.sendRedirect("ProduitServlet");
            } else if (action.equals("update")) {
                // Update an existing product
                String idProduit = request.getParameter("idProduit");
                String nomProduit = request.getParameter("nomProduit");
                double prixProduit = Double.parseDouble(request.getParameter("prixProduit"));
                String idFournisseur = request.getParameter("idFournisseur");
                java.sql.Date dateFabrication = java.sql.Date.valueOf(request.getParameter("dateFabrication"));
                String description = request.getParameter("description");

                Produit produit = new Produit(idProduit, nomProduit, prixProduit, idFournisseur, dateFabrication, description);
                ProduitDAO.update(produit);
                response.sendRedirect("ProduitServlet");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}