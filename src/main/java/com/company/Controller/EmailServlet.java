package com.company.Controller;

import com.company.Database.Database;
import com.company.Model.Email;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.naming.NamingException;
import java.io.IOException;
import java.sql.SQLException;

public class EmailServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Database database = new Database();
        Email email = new Email();
        String button = req.getParameter("button");
        if (button != null) {
            if (button.equalsIgnoreCase("exit")) {
                HttpSession session = req.getSession(false);
                if (session != null) {
                    session.invalidate();
                }
                resp.sendRedirect("/");
            }
            if (button.equalsIgnoreCase("add")) {
                resp.sendRedirect("/addEmail");
            }
        }
        if (req.getParameter("del") != null) {
            int id = Integer.parseInt(req.getParameter("del"));
            try {
                database.deleteEmail(id);
            } catch (SQLException | NamingException e) {
                e.printStackTrace();
            }
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("email.jsp");
            requestDispatcher.forward(req, resp);
        }
        if (req.getParameter("edit") != null) {
            int id = Integer.parseInt(req.getParameter("edit"));
            EditEmailServlet.id = id;
            try {
                email = database.getEmail(id);
            } catch (SQLException | NamingException e) {
                e.printStackTrace();
            }
            EditEmailServlet.email = email;
            resp.sendRedirect("/editEmail");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("email.jsp");
        requestDispatcher.forward(req, resp);
    }
}
