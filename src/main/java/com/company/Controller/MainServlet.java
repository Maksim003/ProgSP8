package com.company.Controller;

import com.company.Database.Database;
import com.company.Model.Email;
import com.company.Model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.naming.NamingException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class MainServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = new User(login, password);
        Database database = new Database();
        String message = "";
        try {
            message = database.getUser(user);
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        if(message.equalsIgnoreCase("user")) {
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("/email");
        }
        else {
            req.setAttribute("log", login);
            req.setAttribute("pass", password);
            RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
        dispatcher.forward(req, resp);
    }
}
