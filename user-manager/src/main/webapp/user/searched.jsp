<%--
  Created by IntelliJ IDEA.
  User: KhangNguyen
  Date: 10/6/2023
  Time: 5:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="users?action=users">List All Users</a>
    </h2>
</center>
<div align="center">
    <form>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Searched User
                </h2>
            </caption>

            <tr>
                <th>User Name:</th>
                <td><c:out value="${user.name}"/></td>
            </tr>
            <tr>
                <th>User Email:</th>
                <td><c:out value="${user.email}" /></td>
            </tr>
            <tr>
                <th>Country:</th>
                <td>
                    <c:if test="${user != null}">
                        <c:out value="${user.country}"/>
                    </c:if>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
