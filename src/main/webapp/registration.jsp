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
    <h1>Регистрация</h1>
</header>
<%
    String login = (String) request.getAttribute("log");
    if (login == null) login = "";
    String password = (String) request.getAttribute("pass");
    if (password == null) password = "";
%>
<div class="userReg">
    <form method="post">
        <label for="login">Введите логин:</label>
        <input type="text" id="login" name="login" value="<%=login%>" required><br><br>
        <label for="password">Пароль:</label>
        <input type="password" id="password" name="password" value="<%=password%>" required><br><br>
        <button type="submit" name="button" value="registration">Зарегистрироваться</button>
    </form>
    <a href="/" class="authorization">Авторизация</a>
    <p>
        <%
            if (!login.equals("")) {
                out.println("Аккаунт с таким логином существует");
            }
        %>
    </p>
</div>
</body>
</html>
