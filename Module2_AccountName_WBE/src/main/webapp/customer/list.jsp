<%--
  Created by IntelliJ IDEA.
  User: KhangNguyen
  Date: 18/6/2023
  Time: 9:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Customer Management</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
    <link href="style.css" rel="stylesheet">
</head>
<body>
<h1 style="text-align: center">Trang danh sách khách hàng</h1>
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
                    <a class="nav-link  active" href="customer">Khách hàng</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="service">Dịch vụ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="contract">Hợp đồng</a>
                </li>
            </ul>
            <form class="d-flex">
                <input class="form-control me-2" id="search-name" type="input" placeholder="Search By Name" aria-label="Search">
                <button class="btn btn-outline-success" type="button" onclick="searchCustomer()">Search</button>
            </form>
        </div>
    </div>
</nav>
<button type="button" class="btn btn-primary" onclick="window.location.href='/customer?action=add'">
    <span class="bi bi-plus-circle"></span> Thêm mới
</button>
<p style="color: red">${mess}</p>

<table class="table table-dark table-striped">
    <tr>
        <th>Id</th>
        <th>Họ tên</th>
        <th>Ngày sinh</th>
        <th>Giới tính</th>
        <th>Số CMND</th>
        <th>Số điện thoại</th>
        <th>Email</th>
        <th>Địa chỉ</th>
        <th>Loại khách hàng</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="customer" items="${customerList}" >
        <tr>
            <td>${customer.customerId}</td>
            <td>${customer.customerName}</td>
            <td>${customer.customerBirthday}</td>
            <c:if test="${customer.isCustomerGender()}">
                <td>Nam</td>
            </c:if>
            <c:if test="${!customer.isCustomerGender()}">
                <td>Nữ</td>
            </c:if>
            <td><fmt:formatNumber type="number" pattern="#.########" value="${customer.customerIdCard}" ></fmt:formatNumber> </td>
            <td>${customer.customerPhone}</td>
            <td>${customer.customerEmail}</td>
            <td>${customer.customerAddress}</td>
            <td>
                <c:choose>
                    <c:when test="${customer.customerType == 1 }">Diamond</c:when>
                    <c:when test="${customer.customerType == 2 }">Platinum</c:when>
                    <c:when test="${customer.customerType == 3 }">Gold</c:when>
                    <c:when test="${customer.customerType == 4 }">Silver</c:when>
                    <c:when test="${customer.customerType == 5 }">Member</c:when>
                </c:choose>
            </td>
            <td>
                <button type="button" class="btn btn-danger" onclick="window.location.href='/customer?action=delete&id=${customer.customerId}'">
                    <span class="bi bi-trash"></span> Xoá
                </button>

                <button type="button" class="btn btn-primary" onclick="window.location.href='/customer?action=edit&id=${customer.customerId}'">
                    <span class="bi bi-pencil"></span> Sửa
                </button>
            </td>
        </tr>
    </c:forEach>
</table>
<script>
    function searchCustomer() {
        // Lấy giá trị tên sản phẩm từ input
        var name = document.getElementById("search-name").value;
        // Chuyển hướng tới trang hiển thị kết quả tìm kiếm
        window.location.href = "/customer?action=find&name=" + name;
    }
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
