<%--
  Created by IntelliJ IDEA.
  User: KhangNguyen
  Date: 3/7/2023
  Time: 6:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>currency converter</title>
</head>
<body>
<form method="post" action="/converter">
    <label>Rate: </label>
    <input type="text" name="rate" placeholder="Rate" value="23710"><br>
    <label>USD: </label>
    <input type="text" name="usd" placeholder="USD" value="0"><br>
    <input type="submit" id="submit" value="Converter"></br>
    <c:if test="${not empty result1}">
        RESULT: ${result1}
    </c:if>
</form>
</body>
</html>
