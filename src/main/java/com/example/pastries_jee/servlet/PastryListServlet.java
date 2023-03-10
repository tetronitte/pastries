package com.example.pastries_jee.servlet;

import com.example.pastries_jee.dao.FactoryDao;
import com.example.pastries_jee.entities.Pastry;
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String search = request.getParameter("search");
        List<Pastry> pastries = FactoryDao.getPastryDao().getLike(search);
        request.setAttribute("pastries", pastries);
        request.getRequestDispatcher("/WEB-INF/pastry-list.jsp").forward(request,response);
    }
}