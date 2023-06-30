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
    <style>
        th{
            text-align: left;
        }
    </style>
    <title>Edit Customer</title>
</head>
<center>
    <body>
    <div>
        <h2>Cập nhật thông tin khách hàng</h2>
        <h3>
            <a href="customer?action=customer">Danh sách khách hàng</a>
        </h3>
        <form method="post">
            <table border="1" cellpadding="5">
                <caption>
                    <h2>Thông tin khách hàng chi tiết</h2>
                </caption>
                <c:if test="${customer != null}">
                    <input type="hidden" name="customerId" value="<c:out value='${customer.customerId}' />"/>
                </c:if>
                <tr>
                    <th>Họ tên:</th>
                    <td>
                        <input type="text" name="customerName" size="45"
                               value="<c:out value='${customer.customerName}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Ngày sinh:</th>
                    <td>
                        <input type="text" name="customerBirthday" size="45"
                               value="<c:out value='${customer.customerBirthday}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Giới tính:</th>
                    <td>
                        <input type="radio" name="customerGender"
                               value="true" ${customer.customerGender=='true'?'checked':''}>Nam
                        <input type="radio" name="customerGender"
                               value="false" ${customer.customerGender=='false'?'checked':''}>Nữ
                    </td>
                </tr>
                <tr>
                    <th>Số cmnd:</th>
                    <td>
                        <input type="text" name="customerIdCard" id="customerIdCard" value="<fmt:formatNumber type="number" pattern="#.########" value="${customer.customerIdCard}" ></fmt:formatNumber>">
                    </td>
                </tr>
                <tr>
                    <th>Số điện thoại:</th>
                    <td>
                        <input type="text" name="customerPhone" size="45"
                               value="<c:out value='${customer.customerPhone}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Email:</th>
                    <td>
                        <input type="text" name="customerEmail" size="45"
                               value="<c:out value='${customer.customerEmail}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Địa chỉ:</th>
                    <td>
                        <input type="text" name="customerAddress" size="45"
                               value="<c:out value='${customer.customerAddress}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Loại khách hàng:</th>
                    <td>
                        <select name="customerType">
                            <c:choose>
                                <c:when test="${customer.customerType==1}">
                                    <option value="1" selected>Diamond</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="1">Diamond</option>
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${customer.customerType==2}">
                                    <option value="2" selected>Platinum</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="2">Platinum</option>
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${customer.customerType==3}">
                                    <option value="3" selected>Gold</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="3">Gold</option>
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${customer.customerType==4}">
                                    <option value="4" selected>Silver</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="4">Silver</option>
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${customer.customerType==5}">
                                    <option value="5" selected>Member</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="5">Member</option>
                                </c:otherwise>
                            </c:choose>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    </body>
</center>

</html>
