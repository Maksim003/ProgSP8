<%@ page import="com.company.Model.Email" %>
<%@ page import="com.company.Controller.EditEmailServlet" %>
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
    <h1>Изменение почтового адреса</h1>
</header>
<%
    if (EditEmailServlet.id != 0) {
        Email email = EditEmailServlet.email;
%>
<div class="edit">
    <form method="post">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="<%=email.getAddress()%>"  required><br><br>
        <label for="name">Имя:</label>
        <input type="text" id="name" name="name" value="<%=email.getName()%>" required><br><br>
        <label for="surname">Фамилия:</label>
        <input type="text" id="surname" name="surname" value="<%=email.getSurname()%>" required><br><br>
        <button type="submit" name="button" value="edit">Изменить</button>
    </form>
    <form action="/email">
        <button type="submit" value="exit">Выйти</button>
    </form>
</div>
<%
    }
%>
</body>
</html>
