<%--
  Created by IntelliJ IDEA.
  User: KhangNguyen
  Date: 19/6/2023
  Time: 9:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <style>
        th{
            text-align: left;
        }
    </style>
    <title>Searched Customer</title>
</head>
<center>
    <body>
    <div>
        <h2>Tìm kiếm khách hàng</h2>
        <h3>
            <a href="customer?action=customer">Danh sách khách hàng</a>
        </h3>
        <form>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>Thông tin khách hàng</h2>
                </caption>
                <tr>
                    <th>Mã khách hàng:</th>
                    <td>${requestScope["customer"].getCustomerId()}</td>
                </tr>
                <tr>
                    <th>Họ tên:</th>
                    <td>${requestScope["customer"].getCustomerName()}</td>
                </tr>
                <tr>
                    <th>Ngày sinh:</th>
                    <td>
                        ${requestScope["customer"].getCustomerBirthday()}
                    </td>
                </tr>
                <tr>
                    <th>Giới tính:</th>
                    <c:if test="${customer.isCustomerGender()}">
                        <td>Nam</td>
                    </c:if>
                    <c:if test="${!customer.isCustomerGender()}">
                        <td>Nữ</td>
                    </c:if>
                </tr>
                <tr>
                    <th>Số cmnd:</th>
                    <td>
                        <fmt:formatNumber type="number" pattern="#.########" value="${customer.getCustomerIdCard()}" ></fmt:formatNumber>
                    </td>
                </tr>
                <tr>
                    <th>Số điện thoại:</th>
                    <td>
                        ${requestScope["customer"].getCustomerPhone()}
                    </td>
                </tr>
                <tr>
                    <th>Email:</th>
                    <td>
                        ${requestScope["customer"].getCustomerEmail()}
                    </td>
                </tr>
                <tr>
                    <th>Địa chỉ:</th>
                    <td>
                        ${requestScope["customer"].getCustomerAddress()}
                    </td>
                </tr>
                <tr>
                    <th>Loại khách hàng:</th>
                    <td>
                        <c:choose>
                            <c:when test="${customer.getCustomerType() == 1 }">Diamond</c:when>
                            <c:when test="${customer.getCustomerType() == 2 }">Platinum</c:when>
                            <c:when test="${customer.getCustomerType() == 3 }">Gold</c:when>
                            <c:when test="${customer.getCustomerType() == 4 }">Silver</c:when>
                            <c:when test="${customer.getCustomerType() == 5 }">Member</c:when>
                        </c:choose>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    </body>
</center>

</html>
