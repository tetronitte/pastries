package com.example.pastries_jee.servlet;

import com.example.dao.FactoryDao;
import com.example.entities.Pastry;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(urlPatterns = "/pastry-list")
public class PastryListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Pastry> pastries = FactoryDao.getPastryDao().getAll();
        request.setAttribute("pastries", pastries);
        request.getRequestDispatcher("/WEB-INF/pastry-list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long pastryId = Long.parseLong(request.getParameter("id"));
        Optional<Pastry> pastry = FactoryDao.getPastryDao().get(pastryId);
        if (pastry.isPresent()) {
            FactoryDao.getPastryDao().delete(pastry.get());
            response.sendRedirect("pastry-list");
        }
        else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "La pâtisserie est introuvable");
        }
    }
}