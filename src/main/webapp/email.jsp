<%@ page import="com.company.Model.Email" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.company.Database.Database" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="javax.naming.NamingException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/style.css">
    <title>lab8</title>
</head>
<body>
<header>
    <h1>Почтовые адреса</h1>
</header>
<%
    Database database = new Database();
    ArrayList<Email> emails = null;
    try {
        emails = database.getEmails();
    } catch (SQLException | NamingException e) {
        e.printStackTrace();
    }
    if (emails.size() != 0) {
        for (Email e : emails) {


%>
<div class="emails">
    <h2>
        <%=e.getAddress()%>
    </h2>
    <p>Имя: <%=e.getName()%></p>
    <p>Фамилия: <%=e.getSurname()%></p>
    <form method="post">
        <button type="submit" name="edit" value="<%=e.getId()%>">Изменить</button>
    </form>
    <form method="post">
        <button type="submit" name="del" value="<%=e.getId()%>">Удалить</button>
    </form>
</div>
<%
        }
    }
%>
<br><br>
<div class="buttons">
    <form method="post">
        <button type="submit" name="button" value="exit">Выйти</button>
    </form>
    <form method="post">
        <button type="submit" name="button" value="add">Добавить</button>
    </form>
</div>
</body>
</html>
