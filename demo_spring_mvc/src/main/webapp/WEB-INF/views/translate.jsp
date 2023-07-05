<%--
  Created by IntelliJ IDEA.
  User: KhangNguyen
  Date: 4/7/2023
  Time: 9:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Từ điển</title>
</head>
<body>
<h1>Từ điển</h1>
<form method="post" action="/dictionary">
    <select name="id">
        <option value="">Chọn từ tiếng Việt</option>
        <c:choose>
            <c:when test="${id==1}">
                <option value="1" selected>quả táo</option>
            </c:when>
            <c:otherwise>
                <option value="1">quả táo</option>
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${id==2}">
                <option value="2" selected>con mèo</option>
            </c:when>
            <c:otherwise>
                <option value="2">con mèo</option>
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${id==3}">
                <option value="3" selected>con chó</option>
            </c:when>
            <c:otherwise>
                <option value="3">con chó</option>
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${id==4}">
                <option value="4" selected>bông hoa</option>
            </c:when>
            <c:otherwise>
                <option value="4">bông hoa</option>
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${id==5}">
                <option value="5" selected>con chim</option>
            </c:when>
            <c:otherwise>
                <option value="5">con chim</option>
            </c:otherwise>
        </c:choose>
    </select>
    <input type="submit" id="submit" value="Translate">
    <input readonly type="text" value="${english}">
</form>
</body>
</html>
