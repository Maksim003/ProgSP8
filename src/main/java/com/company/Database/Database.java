package com.company.Database;


import com.company.Model.Email;
import com.company.Model.User;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

public class Database {

    private static BasicDataSource ds = new BasicDataSource();

    static {
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/progsp8?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT&useSSL=false&allowPublicKeyRetrieval=true");
        ds.setUsername("root");
        ds.setPassword("tankdollar");
    }

    public Connection createDbConnection() throws NamingException, SQLException {
        Connection connection = ds.getConnection();
        return connection;
    }


    public ResultSet getData(String select, Statement statement) {
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(select);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void updateData(String select, Statement statement) {
        try {
            statement.executeUpdate(select);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void signUp(User user) throws SQLException, NamingException {
        Connection connection = createDbConnection();
        Statement statement = connection.createStatement();
        String insertFields = "INSERT INTO users(login, password) VALUES ('";
        String insertValues = user.getLogin() + "','" + user.getPassword() + "')";
        String insert = insertFields + insertValues;
        updateData(insert, statement);
        connection.close();
    }

    public void addEmail(Email email) throws SQLException, NamingException {
        Connection connection = createDbConnection();
        Statement statement = connection.createStatement();
        String insertFields = "INSERT INTO emails(email, name, surname) VALUES ('";
        String insertValues = email.getAddress() + "','" + email.getName() + "','" + email.getSurname() + "')";
        String insert = insertFields + insertValues;
        updateData(insert, statement);
        connection.close();
    }

    public String getUserLogin(String log) throws SQLException, NamingException {
        Connection connection = createDbConnection();
        Statement statement = connection.createStatement();
        String select = "SELECT * FROM users WHERE login = " + "\"" + log + "\"";
        String message = "";
        ResultSet resultSet = getData(select, statement);
        try {
            if (resultSet.next()) {
                message = "user";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connection.close();
        return message;
    }

    public ArrayList<Email> getEmails() throws SQLException, NamingException {
        Connection connection = createDbConnection();
        Statement statement = connection.createStatement();
        ArrayList<Email> emails = new ArrayList<>();
        String select = "SELECT * FROM emails";
        ResultSet resultSet = getData(select, statement);
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String email = resultSet.getString("email");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            emails.add(new Email(id, email, name, surname));
        }
        connection.close();
        return emails;
    }

    public void deleteEmail(int id) throws SQLException, NamingException {
        Connection connection = createDbConnection();
        Statement statement = connection.createStatement();
        String select = "DELETE FROM emails" + " WHERE id = " + id;
        updateData(select, statement);
        connection.close();
    }

    public void changeDataEmail(Email email) throws SQLException, NamingException {
        Connection connection = createDbConnection();
        Statement statement = connection.createStatement();
        String select = "UPDATE emails SET email = " + "\"" + email.getAddress() + "\"" + " , name = " + "\"" + email.getName() + "\"" + " , surname = " + "\"" + email.getSurname() + "\"" + " WHERE id = " + email.getId();
        updateData(select, statement);
        connection.close();
    }

    public Email getEmail(int id) throws SQLException, NamingException {
        Email email = new Email();
        Connection connection = createDbConnection();
        Statement statement = connection.createStatement();
        String select = "SELECT * FROM emails" + " WHERE id = " + id;
        ResultSet resultSet = getData(select, statement);
        if (resultSet.next()) {
            email.setAddress(resultSet.getString("email"));
            email.setName(resultSet.getString("name"));
            email.setSurname(resultSet.getString("surname"));
        }
        connection.close();
        return email;
    }

    public String getUser(User user) throws SQLException, NamingException {
        Connection connection = createDbConnection();
        Statement statement = connection.createStatement();
        String select = "SELECT * FROM users WHERE login = " + "\"" + user.getLogin() + "\"" + " AND password = " + "\"" + user.getPassword() + "\"";
        ResultSet resultSet = getData(select, statement);
        String message = "";
        try {
            if (resultSet.next()) {
                message = "user";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connection.close();
        return message;
    }


}