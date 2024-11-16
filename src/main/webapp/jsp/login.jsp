<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Вход</title>

</head>
<body>
<form method="POST" action="${pageContext.request.contextPath}/login">
    <label for="login">логин : </label>
    <input type="text"   name="login" id="login" required>

    <label for="password">пароль: </label>
    <input type="password"  name="password" id="password" required>

    <button  type="submit">войти</button>
    <a href="${pageContext.request.contextPath}/registration"></a>

</form>

</body>
</html>
