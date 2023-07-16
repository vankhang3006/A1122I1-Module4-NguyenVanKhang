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
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
</head>
<body>
<h1>Mail Box Detail</h1>
ID
<p>${mail.id}</p>
Languages
<p>${mail.language}</p>
Page Sizes
<p>${mail.page}</p>
Spams filter
<p>${mail.filter}</p>
Signature
<p>${mail.signature}</p>
</body>
</html>
