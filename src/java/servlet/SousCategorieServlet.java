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
@WebServlet("/SousCategorieServlet")
public class SousCategorieServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if (action == null || action.isEmpty()) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Action non spécifiée.");
                return;
            }

            switch (action) {
                case "list":
                    ArrayList<SousCategorie> sousCategories = SousCategorieDAO.getAll();
                    request.setAttribute("sousCategories", sousCategories);
                    RequestDispatcher listDispatcher = request.getRequestDispatcher("/listSousCategorie.jsp");
                    listDispatcher.forward(request, response);
                    break;

                case "edit":
                    int idSousCategorieEdit = Integer.parseInt(request.getParameter("id"));
                    SousCategorie sousCategorieEdit = SousCategorieDAO.getById(idSousCategorieEdit);
                    request.setAttribute("sousCategorie", sousCategorieEdit);
                    RequestDispatcher editDispatcher = request.getRequestDispatcher("/editSousCategorie.jsp");
                    editDispatcher.forward(request, response);
                    break;

                case "delete":
                    int idSousCategorieDelete = Integer.parseInt(request.getParameter("id"));
                    SousCategorieDAO.delete(idSousCategorieDelete);
                    response.sendRedirect("SousCategorieServlet?action=list");
                    break;

                default:
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Action inconnue : " + action);
                    break;
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
            if (action == null || action.isEmpty()) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Action non spécifiée.");
                return;
            }

            switch (action) {
                case "add":
                    int idSousCategorieAdd = Integer.parseInt(request.getParameter("idSousCategorie"));
                    String nomSousCategorieAdd = request.getParameter("nomSousCategorie");
                    SousCategorieDAO.insert(idSousCategorieAdd, nomSousCategorieAdd);
                    response.sendRedirect("SousCategorieServlet?action=list");
                    break;

                case "update":
                    int idSousCategorieUpdate = Integer.parseInt(request.getParameter("idSousCategorie"));
                    String nomSousCategorieUpdate = request.getParameter("nomSousCategorie");
                    SousCategorie sousCategorieUpdate = new SousCategorie(idSousCategorieUpdate, nomSousCategorieUpdate);
                    SousCategorieDAO.update(sousCategorieUpdate);
                    response.sendRedirect("SousCategorieServlet?action=list");
                    break;

                default:
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Action inconnue : " + action);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}