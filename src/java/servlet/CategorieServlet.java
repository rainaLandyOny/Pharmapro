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
@WebServlet("/CategorieServlet")
public class CategorieServlet extends HttpServlet {
    
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
                    ArrayList<Categorie> categories = CategorieDAO.getAll();
                    request.setAttribute("categories", categories);
                    RequestDispatcher listDispatcher = request.getRequestDispatcher("/listCategorie.jsp");
                    listDispatcher.forward(request, response);
                    break;

                case "edit":
                    int idCategorieEdit = Integer.parseInt(request.getParameter("id"));
                    Categorie categorieEdit = CategorieDAO.getById(idCategorieEdit);
                    request.setAttribute("categorie", categorieEdit);
                    RequestDispatcher editDispatcher = request.getRequestDispatcher("/insertCategorie.jsp");
                    editDispatcher.forward(request, response);
                    break;

                case "delete":
                    int idCategorieDelete = Integer.parseInt(request.getParameter("id"));
                    CategorieDAO.delete(idCategorieDelete);
                    response.sendRedirect("CategorieServlet?action=list");
                    break;

                default:
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Action inconnue : " + action);
                    break;
            }
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID invalide.");
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
                    String nomCategorieAdd = request.getParameter("nomCategorie");
                    CategorieDAO.insert(nomCategorieAdd);
                    response.sendRedirect("CategorieServlet?action=list");
                    break;

                case "update":
                    int idCategorieUpdate = Integer.parseInt(request.getParameter("idCategorie"));
                    String nomCategorieUpdate = request.getParameter("nomCategorie");
                    Categorie categorieUpdate = new Categorie(idCategorieUpdate, nomCategorieUpdate);
                    CategorieDAO.update(categorieUpdate);
                    response.sendRedirect("CategorieServlet?action=list");
                    break;

                default:
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Action inconnue : " + action);
                    break;
            }
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID invalide.");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}