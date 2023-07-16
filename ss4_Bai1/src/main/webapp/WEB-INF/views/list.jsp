<%--
  Created by IntelliJ IDEA.
  User: KhangNguyen
  Date: 10/7/2023
  Time: 3:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
</head>
<body>
<a href="/mail/create">Thêm mới</a>
<p>${mess}</p>
<table class="table table">
    <tr>
        <th>STT</th>
        <th>Id</th>
        <th>Language</th>
        <th>Page size</th>
        <th>Spam filter</th>
        <th>Signature</th>
        <th>Detail2-PathVariable</th>
        <th>Edit</th>
    </tr>
    <c:forEach items="${mailList}" var="mail" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${mail.id}</td>
            <td>${mail.language}</td>
            <td>${mail.page}</td>
            <td>
                <c:choose>
                    <c:when test="${mail.filter == true }">Enable</c:when>
                    <c:when test="${mail.filter == false }">Disable</c:when>
                </c:choose>
            </td>
            <td>${mail.signature}</td>
            <td><a href="/mail/detail?id=${mail.id}">Detail</a></td>
            <td><a href="/mail/update?id=${mail.id}">Edit</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
