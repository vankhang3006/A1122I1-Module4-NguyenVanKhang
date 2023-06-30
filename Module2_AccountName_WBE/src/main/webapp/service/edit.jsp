<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %><%--
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
    <style>
        th{
            text-align: left;
        }
    </style>
    <title>Edit Employee</title>
</head>
<center>
    <body>
    <%
        List<Integer> options = Arrays.asList(1, 2, 3);
    %>
    <div>
        <h2>Cập nhật thông tin dịch vụ</h2>
        <h3>
            <a href="service?action=service">Danh sách dịch vụ</a>
        </h3>
        <form method="post">
            <table border="1" cellpadding="5">
                <caption>
                    <h2>Thông tin dịch vụ chi tiết</h2>
                </caption>
                <c:if test="${service != null}">
                    <input type="hidden" name="id" value="<c:out value='${service.id}' />"/>
                </c:if>
                <tr>
                    <th>Tên dịch vụ:</th>
                    <td>
                        <input type="text" name="name" size="45"
                               value="<c:out value='${service.name}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Diện tích:</th>
                    <td>
                        <input type="text" name="area" id="area" value="<fmt:formatNumber type="number" pattern="#.########" value="${service.area}" ></fmt:formatNumber>">
                    </td>
                </tr>
                <tr>
                    <th>Chi phí thuê:</th>
                    <td>
                        <input type="text" name="price" id="price" value="<fmt:formatNumber type="number" pattern="#.########" value="${service.price}" ></fmt:formatNumber>">
                    </td>
                </tr>
                <tr>
                    <th>Số người tối đa:</th>
                    <td>
                        <input type="number" name="maxPeople" size="45"
                               value="<c:out value='${service.maxPeople}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Tiêu chuẩn phòng:</th>
                    <td>
                        <input type="text" name="standardRoom" size="45"
                               value="<c:out value='${service.standardRoom}' />"
                        />                    </td>
                </tr>
                <tr>
                    <th>Mô tả tiện nghi khác:</th>
                    <td>
                        <input type="text" name="description" size="45"
                               value="<c:out value='${service.description}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Diện tích hồ bơi:</th>
                    <td>
                        <input type="text" name="poolArea" size="45"
                               value="<c:out value='${service.poolArea}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Số tầng:</th>
                    <td>
                        <input type="number" name="floorNumber" size="45"
                               value="<c:out value='${service.floorNumber}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Kiểu thuê:</th>
                    <td>
                        <select name="rentTypeId">
                            <c:choose>
                                <c:when test="${service.rentTypeId==1}">
                                    <option value="1" selected>Theo năm</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="1">Theo năm</option>
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${service.rentTypeId==2}">
                                    <option value="2" selected>Theo tháng</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="2">Theo tháng</option>
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${service.rentTypeId==3}">
                                    <option value="3" selected>Theo ngày</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="3">Theo ngày</option>
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${service.rentTypeId==4}">
                                    <option value="4" selected>Theo giờ</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="4">Theo giờ</option>
                                </c:otherwise>
                            </c:choose>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>Loại dịch vụ:</th>
                    <td>
                        <select name="serviceTypeId">
                            <c:choose>
                                <c:when test="${service.serviceTypeId==1}">
                                    <option value="1" selected>Villa</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="1">Villa</option>
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${service.serviceTypeId==2}">
                                    <option value="2" selected>House</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="2">House</option>
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${service.serviceTypeId==3}">
                                    <option value="3" selected>Room</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="3">Room</option>
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
