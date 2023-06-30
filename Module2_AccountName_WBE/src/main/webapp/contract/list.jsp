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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link href="style.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
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
    <a href="/contract?action=add">Thêm mới</a>
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
                <a href="/contract?action=delete&id=${contract.contractId}">Xoá</a>
                <a href="/contract?action=edit&id=${contract.contractId}">Sửa</a>
              </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
