package com.example.pastries_jee.servlet;

import com.example.pastries_jee.dao.FactoryDao;
import com.example.pastries_jee.entities.Pastry;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/pastry/*")
public class PastryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getPathInfo();
        Optional<Pastry> pastry = FactoryDao.getPastryDao().getByName(name.substring(1));
        if (pastry.isPresent()) {
            request.setAttribute("pastry", pastry.get());
            request.getRequestDispatcher("/WEB-INF/pastry.jsp").forward(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "La pâtisserie demandée est introuvable");
        }
    }
}