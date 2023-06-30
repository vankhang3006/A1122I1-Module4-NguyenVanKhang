<%--
  Created by IntelliJ IDEA.
  User: KhangNguyen
  Date: 19/6/2023
  Time: 6:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Service Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link href="style.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>
<h1 style="text-align: center">Trang danh sách dịch vụ</h1>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="index.jsp">Trang chủ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="employee">Nhân viên</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="customer">Khách hàng</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="service">Dịch vụ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="contract">Hợp đồng</a>
                </li>

            </ul>
        </div>
    </div>
</nav>
<a href="/service?action=add">Thêm mới</a>
<p style="color: red">${mess}</p>

<table class="table table-dark table-striped">
    <tr>
        <th>Mã dịch vụ</th>
        <th>Tên dịch vụ</th>
        <th>Diện tích</th>
        <th>Chi phí thuê</th>
        <th>Số người tối đa</th>
        <th>Tiêu chuẩn phòng</th>
        <th>Mô tả tiện nghi khác</th>
        <th>Diện tích hồ bơi</th>
        <th>Số tầng</th>
        <th>Kiểu thuê</th>
        <th>Loại dịch vụ</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="service" items="${serviceList}" >
        <tr>
            <td>${service.id}</td>
            <td>${service.name}</td>
            <td><fmt:formatNumber type="number" pattern="#.########" value="${service.area}" ></fmt:formatNumber> </td>
            <td><fmt:formatNumber type="number" pattern="#.########" value="${service.price}" ></fmt:formatNumber> </td>
            <td>${service.maxPeople}</td>
            <td>${service.standardRoom}</td>
            <td>${service.description}</td>
            <td>${service.poolArea}</td>
            <td>${service.floorNumber}</td>
            <td>
                <c:choose>
                    <c:when test="${service.rentTypeId == 1 }">Theo năm</c:when>
                    <c:when test="${service.rentTypeId == 2 }">Theo tháng</c:when>
                    <c:when test="${service.rentTypeId == 3 }">Theo ngày</c:when>
                    <c:when test="${service.rentTypeId == 4 }">Theo giờ</c:when>
                </c:choose>
            </td>
            <td>
                <c:choose>
                    <c:when test="${service.serviceTypeId == 1 }">Villa</c:when>
                    <c:when test="${service.serviceTypeId == 2 }">House</c:when>
                    <c:when test="${service.serviceTypeId == 3 }">Room</c:when>
                </c:choose>
            </td>
            <td>
                <a href="/service?action=delete&id=${service.id}">Xoá</a>
                <a href="/service?action=edit&id=${service.id}">Sửa</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
