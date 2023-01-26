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

@WebServlet(urlPatterns = "/delete-pastry")
public class deletePastryServlet extends HttpServlet {

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
