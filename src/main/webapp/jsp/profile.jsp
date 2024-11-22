<%--
  Created by IntelliJ IDEA.
  User: ruslankhairullov
  Date: 16.11.2024
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>профиль</title>
</head>
<body>
${login} - ${age}
<form method="post" action="${pageContext.request.contextPath}/weather">
    <label for="cityName">Введите название города</label>
    <input type="text" name="cityName" id="cityName" required>
    <button type="submit">получить погоду</button>
</form>
</body>
</html>
