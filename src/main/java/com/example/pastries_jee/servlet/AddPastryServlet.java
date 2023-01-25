package com.example.pastries_jee.servlet;

import com.example.pastries_jee.dao.FactoryDao;
import com.example.pastries_jee.entities.Pastry;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/add-pastry")
public class AddPastryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/add-pastry-form.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Pastry pastry = new Pastry();
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String imgName = request.getParameter("imgName");
        if (name.equals("") | description.equals("") || imgName.equals("")) {
            request.setAttribute("error", "Tous les champs doivent être remplis");
            request.getRequestDispatcher("/WEB-INF/add-pastry-form.jsp").forward(request, response);
        }
        else {
            pastry.setDescription(description);
            pastry.setName(name);
            pastry.setImgName(imgName);
            FactoryDao.getPastryDao().save(pastry);
            response.sendRedirect("pastry-list");
        }
    }
}
