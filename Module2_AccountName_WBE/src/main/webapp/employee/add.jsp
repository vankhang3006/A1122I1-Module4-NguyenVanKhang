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
    <title>Add Employee Form</title>
</head>
<center>
    <body>
    <div>
        <h2>Trang thêm mới</h2>
        <p>${mess}</p>
        <h3>
            <a href="employee?action=employee">Danh sách nhân viên</a>
        </h3>
        <form action="/employee?action=add" method="post">
            <table border="1" cellpadding="5">
                <caption>
                    <h2>Thêm nhân viên</h2>
                </caption>
                <tr>
                    <th>Họ tên:</th>
                    <td>
                        <input type="text" name="employeeName" id="employeeName" size="45"/>
                    </td>
                </tr>
                <tr>
                    <th>Ngày sinh:</th>
                    <td>
                        <input type="text" name="employeeBirthday" id="employeeBirthday" size="45"/>
                    </td>
                </tr>
                <tr>
                    <th>Số cmnd:</th>
                    <td>
                        <input type="text" name="employeeIdCard" id="employeeIdCard" size="45"/>
                    </td>
                </tr>
                <tr>
                    <th>Lương:</th>
                    <td>
                        <input type="text" name="employeeSalary" id="employeeSalary" size="45"/>
                    </td>
                </tr>
                <tr>
                    <th>Số điện thoại:</th>
                    <td>
                        <input type="text" name="employeePhone" id="employeePhone" size="45"/>
                    </td>
                </tr>
                <tr>
                    <th>Email:</th>
                    <td>
                        <input type="text" name="employeeEmail" id="employeeEmail" size="45"/>
                    </td>
                </tr>
                <tr>
                    <th>Địa chỉ:</th>
                    <td>
                        <input type="text" name="employeeAddress" id="employeeAddress" size="45"/>
                    </td>
                </tr>
                <tr>
                    <th>Vị trí:</th>
                    <td>
                        <select name="position">
                            <option value="0">--Chọn vị trí nhân viên--</option>
                            <option value="1">Quản Lý</option>
                            <option value="2">Nhân viên</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>Trình độ:</th>
                    <td>
                        <select name="education">
                            <option value="0">--Chọn trình độ nhân viên--</option>
                            <option value="1">Trung Cấp</option>
                            <option value="2">Cao Đẳng</option>
                            <option value="3">Đại Học</option>
                            <option value="4">Sau Đại Học</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>Bộ phận:</th>
                    <td>
                        <select name="division">
                            <option value="0">--Chọn bộ phận nhân viên--</option>
                            <option value="1">Sale-Marketing</option>
                            <option value="2">Hành chính</option>
                            <option value="3">Phục vụ</option>
                            <option value="4">Quản lý</option>
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
