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
    <style>
        th{
            text-align: left;
        }
    </style>
    <title>Searched Employee</title>
</head>
<center>
    <body>
    <div>
        <h2>Tìm kiếm nhân viên</h2>
        <h3>
            <a href="employee?action=employee">Danh sách nhân viên</a>
        </h3>
        <form>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>Thông tin nhân viên</h2>
                </caption>
                <tr>
                    <th>Mã nhân viên:</th>
                    <td>${requestScope["employee"].getEmployeeId()}</td>
                </tr>
                <tr>
                    <th>Họ tên:</th>
                    <td>${requestScope["employee"].getEmployeeName()}</td>
                </tr>
                <tr>
                    <th>Ngày sinh:</th>
                    <td>
                        ${requestScope["employee"].getEmployeeBirthday()}
                    </td>
                </tr>
                <tr>
                    <th>Số cmnd:</th>
                    <td>
                        <fmt:formatNumber type="number" pattern="#.########" value="${employee.getEmployeeIdCard()}" ></fmt:formatNumber>
                    </td>
                </tr>
                <tr>
                    <th>Lương:</th>
                    <td>
                        <fmt:formatNumber type="number" pattern="#.########" value="${employee.getEmployeeSalary()}" ></fmt:formatNumber>
                    </td>
                </tr>
                <tr>
                    <th>Số điện thoại:</th>
                    <td>
                        ${requestScope["employee"].getEmployeePhone()}
                    </td>
                </tr>
                <tr>
                    <th>Email:</th>
                    <td>
                        ${requestScope["employee"].getEmployeeEmail()}
                    </td>
                </tr>
                <tr>
                    <th>Địa chỉ:</th>
                    <td>
                        ${requestScope["employee"].getEmployeeAddress()}
                    </td>
                </tr>
                <tr>
                    <th>Vị trí:</th>
                    <td>
                        <c:choose>
                            <c:when test="${employee.getPosition() == 1 }">Quản lý</c:when>
                            <c:when test="${employee.getPosition() == 2 }">Nhân viên</c:when>
                        </c:choose>
                    </td>
                </tr>
                <tr>
                    <th>Học vấn:</th>
                    <td>
                        <c:choose>
                            <c:when test="${employee.getEducation() == 1 }">Trung Cấp</c:when>
                            <c:when test="${employee.getEducation()  == 2 }">Cao Đẳng</c:when>
                            <c:when test="${employee.getEducation()  == 3 }">Đại Học</c:when>
                            <c:when test="${employee.getEducation()  == 4 }">Sau Đại Học</c:when>
                        </c:choose>
                    </td>
                </tr>
                <tr>
                    <th>Bộ phận:</th>
                    <td>
                        <c:choose>
                            <c:when test="${employee.getDivision() == 1 }">Sale-Marketing</c:when>
                            <c:when test="${employee.getDivision() == 2 }">Hành chính</c:when>
                            <c:when test="${employee.getDivision() == 3 }">Phục vụ</c:when>
                            <c:when test="${employee.getDivision() == 4 }">Quản lý</c:when>
                        </c:choose>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    </body>
</center>

</html>
