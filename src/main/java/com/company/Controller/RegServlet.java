package com.company.Controller;

import com.company.Database.Database;
import com.company.Model.User;
import com.mysql.cj.Session;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.naming.NamingException;
import java.io.IOException;
import java.sql.SQLException;

public class RegServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = "";
        Database database = new Database();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String buttonClick = req.getParameter("button");
        User user = new User(login, password);
        if (buttonClick.equalsIgnoreCase("registration")) {
            try {
                message = database.getUserLogin(login);
            } catch (SQLException | NamingException e) {
                e.printStackTrace();
            }
            if (message.equalsIgnoreCase("user")) {
                req.setAttribute("log", login);
                req.setAttribute("pass", password);
                RequestDispatcher dispatcher = req.getRequestDispatcher("registration.jsp");
                dispatcher.forward(req, resp);
            } else {
                try {
                    database.signUp(user);
                } catch (SQLException | NamingException e) {
                    e.printStackTrace();
                }
                resp.sendRedirect("/");
            }
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("registration.jsp");
        dispatcher.forward(req, resp);
    }
}
