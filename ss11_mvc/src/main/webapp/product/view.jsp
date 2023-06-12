<%--
  Created by IntelliJ IDEA.
  User: KhangNguyen
  Date: 5/6/2023
  Time: 6:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">

</head>
<body>
<h1 style="text-align: center">Product details</h1>
<p>
    <a style="text-decoration: none" href="/products">Back to product list</a>
</p>
<table class="table table-dark table-striped">
    <tr>
        <th>Name: </th>
        <td>${requestScope["product"].getName()}</td>
    </tr>
    <tr>
        <th>Price: </th>
        <td><fmt:formatNumber type="number" pattern="###$" value="${requestScope['product'].getPrice()}"></fmt:formatNumber> </td>
    </tr>
    <tr>
        <th>Description: </th>
        <td>${requestScope["product"].getDescription()}</td>
    </tr>
</table>
</body>
</html>
