<%@ page import="java.util.ArrayList" %>
<%@ page import="com.company.Model.Email" %>
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
    <h1>Добавление почтового адреса</h1>
</header>
<div class="add">
    <form method="post">
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>
        <label for="name">Имя:</label>
        <input type="text" id="name" name="name" required><br><br>
        <label for="surname">Фамилия:</label>
        <input type="text" id="surname" name="surname" required><br><br>
        <button type="submit" name="button" value="add">Добавить</button>
    </form>
    <form action="/email">
        <button type="submit" value="exit">Выйти</button>
    </form>
</div>
</body>
</html>
