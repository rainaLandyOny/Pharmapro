/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.AspectDAO;
import models.Aspect;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author Raina
 */
@WebServlet("/aspect")
public class AspectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if (action.equals("list") ) {
                // Afficher tous les aspects
                ArrayList<Aspect> aspects = AspectDAO.getAll();
                request.setAttribute("aspects", aspects);
                request.getRequestDispatcher("/aspect").forward(request, response);
            } else if (action.equals("edit")) {
                // Afficher les informations d'un aspect pour modification
                int idAspect = Integer.parseInt(request.getParameter("id"));
                Aspect aspect = AspectDAO.getById(idAspect);
                request.setAttribute("aspect", aspect);
                request.getRequestDispatcher("/aspect/edit.jsp").forward(request, response);
            } else if (action.equals("delete")) {
                // Supprimer un aspect
                int idAspect = Integer.parseInt(request.getParameter("id"));
                AspectDAO.delete(idAspect);
                response.sendRedirect(request.getContextPath() + "/aspect");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Une erreur s'est produite lors de l'opération.");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        try {
            if (action.equals("add")) {
                // Ajouter un aspect
                String nomAspect = request.getParameter("nomAspect");
                AspectDAO.insert(nomAspect);
                response.sendRedirect(request.getContextPath() + "/aspect");
            } else if (action.equals("update")) {
                // Mettre à jour un aspect
                int idAspect = Integer.parseInt(request.getParameter("idAspect"));
                String nomAspect = request.getParameter("nomAspect");

                Aspect aspect = new Aspect(idAspect, nomAspect);
                AspectDAO.update(aspect);
                response.sendRedirect(request.getContextPath() + "/aspect");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Une erreur s'est produite lors de l'opération.");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}