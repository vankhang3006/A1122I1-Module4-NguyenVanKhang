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
    <title>Add Service Form</title>
</head>
<center>
    <body>
    <div>
        <h2>Trang thêm mới</h2>
        <p>${mess}</p>
        <h3>
            <a href="service?action=service">Danh sách dịch vụ</a>
        </h3>
        <form action="/service?action=add" method="post">
            <table border="1" cellpadding="5">
                <caption>
                    <h2>Thêm dịch vụ</h2>
                </caption>
                <tr>
                    <th>Tên dịch vụ:</th>
                    <td>
                        <input type="text" name="name" id="name" size="45"/>
                    </td>
                </tr>
                <tr>
                    <th>Diện tích:</th>
                    <td>
                        <input type="text" name="area" id="area" size="45"/>
                    </td>
                </tr>
                <tr>
                    <th>Chi phí thuê:</th>
                    <td>
                        <input type="text" name="price" id="price" size="45"/>
                    </td>
                </tr>
                <tr>
                    <th>Số người tối đa:</th>
                    <td>
                        <input type="text" name="maxPeople" id="maxPeople" size="45"/>
                    </td>
                </tr>
                <tr>
                    <th>Tiêu chuẩn phòng:</th>
                    <td>
                        <input type="text" name="standardRoom" id="standardRoom" size="45"/>
                    </td>
                </tr>
                <tr>
                    <th>Mô tả tiện nghi khác:</th>
                    <td>
                        <input type="text" name="description" id="description" size="45"/>
                    </td>
                </tr>
                <tr>
                    <th>Diện tích hồ bơi:</th>
                    <td>
                        <input type="text" name="poolArea" id="poolArea" size="45"/>
                    </td>
                </tr>
                <tr>
                    <th>Số tầng:</th>
                    <td>
                        <input type="text" name="floorNumber" id="floorNumber" size="45"/>
                    </td>
                </tr>
                <tr>
                    <th>Kiểu thuê:</th>
                    <td>
                        <select name="rentTypeId">
                            <option value="0">--Chọn kiểu thuê--</option>
                            <option value="1">Theo năm</option>
                            <option value="2">Theo tháng</option>
                            <option value="3">Theo ngày</option>
                            <option value="4">Theo giờ</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>Loại dịch vụ:</th>
                    <td>
                        <select name="serviceTypeId">
                            <option value="0">--Chọn loại dịch vụ--</option>
                            <option value="1">Villa</option>
                            <option value="2">House</option>
                            <option value="3">Room</option>
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
