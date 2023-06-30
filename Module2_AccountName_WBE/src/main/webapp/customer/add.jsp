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
    <title>Add Customer Form</title>
</head>
<center>
    <body>
    <div>
        <h2>Trang thêm mới</h2>
        <p>${mess}</p>
        <h3>
            <a href="customer?action=customer">Danh sách khách hàng</a>
        </h3>
        <form action="/customer?action=add" method="post">
            <table border="1" cellpadding="5">
                <caption>
                    <h2>Thêm khách hàng</h2>
                </caption>
                <tr>
                    <th>Họ tên:</th>
                    <td>
                        <input type="text" name="customerName" id="customerName" size="45"/>
                    </td>
                </tr>
                <tr>
                    <th>Ngày sinh:</th>
                    <td>
                        <input type="text" name="customerBirthday" id="customerBirthday" size="45"/>
                    </td>
                </tr>
                <tr>
                    <th>Giới tính:</th>
                    <td>
                        <input type="radio" name="status" value="true"> Nam
                        <input type="radio" name="status" value="false"> Nữ<br>
                    </td>
                </tr>
                <tr>
                    <th>Số cmnd:</th>
                    <td>
                        <input type="text" name="customerIdCard" id="customerIdCard" size="45"/>
                    </td>
                </tr>
                <tr>
                    <th>Số điện thoại:</th>
                    <td>
                        <input type="text" name="customerPhone" id="customerPhone" size="45"/>
                    </td>
                </tr>
                <tr>
                    <th>Email:</th>
                    <td>
                        <input type="text" name="customerEmail" id="customerEmail" size="45"/>
                    </td>
                </tr>
                <tr>
                    <th>Địa chỉ:</th>
                    <td>
                        <input type="text" name="customerAddress" id="customerAddress" size="45"/>
                    </td>
                </tr>
                <tr>
                    <th>Loại khách hàng:</th>
                    <td>
                        <select name="customerType">
                            <option value="0">Chọn loại khách hàng</option>
                            <option value="1">Diamond</option>
                            <option value="2">Platinum</option>
                            <option value="3">Gold</option>
                            <option value="4">Silver</option>
                            <option value="5">Member</option>
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
