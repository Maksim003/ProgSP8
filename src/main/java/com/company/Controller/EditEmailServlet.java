package com.company.Controller;

import com.company.Database.Database;
import com.company.Model.Email;
import com.company.Model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.naming.NamingException;
import java.io.IOException;
import java.sql.SQLException;

public class EditEmailServlet extends HttpServlet {

    public static int id = 0;
    public static Email email;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("editEmail.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Database database = new Database();
        String e = req.getParameter("email");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String button = req.getParameter("button");
        Email email1 = new Email(id, e, name, surname);
        if (button != null) {
            if (button.equalsIgnoreCase("edit")) {
                try {
                    System.out.println(email1.getName());
                    database.changeDataEmail(email1);
                } catch (SQLException | NamingException ex) {
                    ex.printStackTrace();
                }
                resp.sendRedirect("/email");
            }
        }
    }
}
