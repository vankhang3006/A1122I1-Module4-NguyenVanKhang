<%--
  Created by IntelliJ IDEA.
  User: KhangNguyen
  Date: 10/7/2023
  Time: 3:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Settings</title>
</head>
<body>
<h1>Settings</h1>
<form:form modelAttribute="mail" action="/mail/create" method="post">
    <table>
        <tr>
            <td></td>
            <td><form:hidden path="id" /></td>
        </tr>
        <tr>
            <td><b><label for="language">Languages</label></b></td>
            <td>
                <form:select id="language" path="language">
                    <form:option value="English">English</form:option>
                    <form:option value="Chinese">Chinese</form:option>
                    <form:option value="Vietnamese">Vietnamese</form:option>
                    <form:option value="Japanese">Japanese</form:option>
                </form:select>
            </td>
        </tr>
        <tr>
            <td><b><label for="page">Page Size:</label></b></td>
            <td>
                Show
                <form:select id="page" path="page">
                    <form:option value="5">5</form:option>
                    <form:option value="10">10</form:option>
                    <form:option value="15">15</form:option>
                    <form:option value="25">25</form:option>
                    <form:option value="50">50</form:option>
                    <form:option value="100">100</form:option>
                </form:select>
                emails per page
            </td>
        </tr>
        <tr>
            <td><b><label for="filter">Spams filter:</label></b></td>
            <td><form:checkbox id="filter" path="filter" />Enable spams filter</td>
        </tr>
        <tr>
            <td><b><label for="signature">Signature:</label></b></td>
            <td><form:textarea id="signature" path="signature" /></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button type="submit">Update</button>
                &nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;
                <button type="reset">Cancel</button>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
