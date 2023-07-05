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
    <title>Employee Management</title>
    <link href="style.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
</head>
<body>
<h1 style="text-align: center">Trang danh sách hợp đồng</h1>
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
                    <a class="nav-link" href="service">Dịch vụ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="contract">Hợp đồng</a>
                </li>

            </ul>
        </div>
    </div>
</nav>
<button type="button" class="btn btn-primary" onclick="window.location.href='/contract?action=add'">
    <span class="bi bi-plus-circle"></span> Thêm mới
</button>
    <p style="color: red">${mess}</p>

<table class="table table-dark table-striped">
    <tr>
        <th>Mã hợp đồng</th>
        <th>Ngày làm hợp đồng</th>
        <th>Ngày kết thúc</th>
        <th>Tiền đặt cọc</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="contract" items="${contractList}" >
        <tr>
            <td>${contract.contractId}</td>
            <td>${contract.startDate}</td>
            <td>${contract.endDate}</td>
            <td><fmt:formatNumber type="number" pattern="#.########" value="${contract.deposit}" ></fmt:formatNumber> </td>
              <td>
                  <button type="button" class="btn btn-danger" onclick="window.location.href='/contract?action=delete&id=${contract.contractId}'">
                      <span class="bi bi-trash"></span> Xoá
                  </button>

                  <button type="button" class="btn btn-primary" onclick="window.location.href='/contract?action=edit&id=${contract.contractId}'">
                      <span class="bi bi-pencil"></span> Sửa
                  </button>
              </td>
        </tr>
    </c:forEach>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
