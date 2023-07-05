<%--
  Created by IntelliJ IDEA.
  User: KhangNguyen
  Date: 4/7/2023
  Time: 11:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Condiment List</title>
</head>
<body>
<h1>Sandwich Condiment List</h1>
<ul>
    <c:forEach items="${condiments}" var="condiment">
        <li>${condiment}</li>
    </c:forEach>
</ul>
</body>
</html>
