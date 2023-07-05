<%--
  Created by IntelliJ IDEA.
  User: KhangNguyen
  Date: 4/7/2023
  Time: 10:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Sandwich Condiments</title>
</head>

<body>
<h1>Sandwich Condiments</h1>
<form method="post" action="/save">
    <input type="checkbox" name="condiment" value="lettuce">Lettuce
    <input type="checkbox" name="condiment" value="tomato">Tomato
    <input type="checkbox" name="condiment" value="mustard">Mustard
    <input type="checkbox" name="condiment" value="sprouts">Sprouts
    <hr style="width: 20%; margin-left: 0;">
    <input type="submit" id="submit" value="Save">
</form>
</body>
</html>
