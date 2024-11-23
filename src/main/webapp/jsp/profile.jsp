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
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script>
        $(document).on("click", "#ajax-button", function () {
                console.log("Debug");
                $.get("/weather?cityName=" + $('#cityName').val(), function (response) {
                    $("#ajax-response").text(response)
                })
            }
        )
    </script>
</head>
<body>
${login} - ${age}

<div id="ajax-response">

</div>

<form>
    <label for="cityName">Введите название города</label>
    <input type="text" name="cityName" id="cityName" required>
    <button id="ajax-button" type="button">получить погоду</button>
</form>


</body>
</html>
