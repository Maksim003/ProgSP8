<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/style.css">
    <title>lab8</title>
</head>
<body>
<!--<form action="/">
    <select id="choice" name="language">
        <option value="english">English</option>
        <option value="russian">Русский</option>
    </select>
</form>-->
<header>
    <h1>Авторизация</h1>
</header>
<%
    String login = (String) request.getAttribute("log");
    if (login == null) login = "";
    String password = (String) request.getAttribute("pass");
    if (password == null) password = "";
%>
<div class="signIn">
    <form method="post">
        <label for="login">Имя пользователя:</label>
        <input type="text" id="login" name="login" value="<%=login%>" required><br><br>
        <label for="password">Пароль:</label>
        <input type="password" id="password" name="password" value="<%=password%>" required><br><br>
        <button type="submit" name="button" value="signIn">Войти</button>
    </form>
    <a href="/reg" class="registration">Регистрация</a>
    <p>
        <%
            if (!login.equals("")) {
                out.println("Данного аккаунта не существует");
            }
        %>
    </p>
</div>
</body>
</html>
