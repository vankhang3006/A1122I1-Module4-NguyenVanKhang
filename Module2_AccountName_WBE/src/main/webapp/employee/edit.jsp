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
    <title>Edit Employee</title>
</head>
<center>
    <body>
    <div>
        <h2>Cập nhật thông tin nhân viên</h2>
        <p>${mess}</p>
        <h3>
            <a href="employee?action=employee">Danh sách nhân viên</a>
        </h3>
        <form method="post">
            <table border="1" cellpadding="5">
                <caption>
                    <h2>Thông tin nhân viên chi tiết</h2>
                </caption>
                <c:if test="${employee != null}">
                    <input type="hidden" name="employeeId" value="<c:out value='${employee.employeeId}' />"/>
                </c:if>
                <tr>
                    <th>Họ tên:</th>
                    <td>
                        <input type="text" name="employeeName" size="45"
                               value="<c:out value='${employee.employeeName}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Ngày sinh:</th>
                    <td>
                        <input type="text" name="employeeBirthday" size="45"
                               value="<c:out value='${employee.employeeBirthday}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Số cmnd:</th>
                    <td>
                        <input type="text" name="employeeIdCard" id="employeeIdCard" value="<fmt:formatNumber type="number" pattern="#.########" value="${employee.employeeIdCard}" ></fmt:formatNumber>">
                    </td>
                </tr>
                <tr>
                    <th>Lương:</th>
                    <td>
                        <input type="text" name="employeeSalary" id="employeeSalary" value="<fmt:formatNumber type="number" pattern="#.########" value="${employee.employeeSalary}" ></fmt:formatNumber>">
                    </td>
                </tr>
                <tr>
                    <th>Số điện thoại:</th>
                    <td>
                        <input type="text" name="employeePhone" size="45"
                               value="<c:out value='${employee.employeePhone}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Email:</th>
                    <td>
                        <input type="text" name="employeeEmail" size="45"
                               value="<c:out value='${employee.employeeEmail}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Địa chỉ:</th>
                    <td>
                        <input type="text" name="employeeAddress" size="45"
                               value="<c:out value='${employee.employeeAddress}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Vị trí nhân viên:</th>
                    <td>
                        <input type="radio" name="position"
                               value=1 ${employee.position==1?'checked':''}>Quản lý
                        <input type="radio" name="position"
                               value=2 ${employee.position==2?'checked':''}>Nhân viên
                    </td>
                </tr>
                <tr>
                    <th>Học vấn nhân viên:</th>
                    <td>
                        <select name="education">
                            <c:choose>
                                <c:when test="${employee.education==1}">
                                    <option value="1" selected>Trung Cấp</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="1">Trung Cấp</option>
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${employee.education==2}">
                                    <option value="2" selected>Cao Đẳng</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="2">Cao Đẳng</option>
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${employee.education==3}">
                                    <option value="3" selected>Đại Học</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="3">Đại Học</option>
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${employee.education==4}">
                                    <option value="4" selected>Sau Đại Học</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="4">Sau Đại Học</option>
                                </c:otherwise>
                            </c:choose>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>Bộ phận nhân viên:</th>
                    <td>
                        <select name="division">
                            <c:choose>
                                <c:when test="${employee.division==1}">
                                    <option value="1" selected>Sale-Marketing</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="1">Sale-Marketing</option>
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${employee.division==2}">
                                    <option value="2" selected>Hành chính</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="2">Hành chính</option>
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${employee.division==3}">
                                    <option value="3" selected>Phục vụ</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="3">Phục vụ</option>
                                </c:otherwise>
                            </c:choose>
                            <c:choose>
                                <c:when test="${employee.division==4}">
                                    <option value="4" selected>Quản lý</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="4">Quản lý</option>
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
