package com.company.Controller;

import com.company.Database.Database;
import com.company.Model.Email;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.naming.NamingException;
import java.io.IOException;
import java.sql.SQLException;

public class AddEmailServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Database database = new Database();
        String button = req.getParameter("button");
        String email = req.getParameter("email");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        if (button.equalsIgnoreCase("add")) {
            Email email1 = new Email(email, name, surname);
            try {
                database.addEmail(email1);
            } catch (SQLException | NamingException e) {
                e.printStackTrace();
            }
            resp.sendRedirect("/email");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("addEmail.jsp");
        dispatcher.forward(req, resp);
    }
}
