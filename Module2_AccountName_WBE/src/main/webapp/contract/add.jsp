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
    <title>Add Contract Form</title>
</head>
<center>
    <body>
    <div>
        <h2>Trang thêm mới</h2>
        <p>${mess}</p>
        <h3>
            <a href="contract?action=contract">Danh sách hợp đồng</a>
        </h3>
        <form action="/contract?action=add" method="post">
            <table border="1" cellpadding="5">
                <caption>
                    <h2>Thêm hợp đồng</h2>
                </caption>
                <tr>
                    <th>Ngày làm hợp đồng:</th>
                    <td>
                        <input type="text" name="startDate" id="startDate" size="45"/>
                    </td>
                </tr>
                <tr>
                    <th>Ngày kết thúc:</th>
                    <td>
                        <input type="text" name="endDate" id="endDate" size="45"/>
                    </td>
                </tr>
                <tr>
                    <th>Tiền đặt cọc:</th>
                    <td>
                        <input type="text" name="deposit" id="deposit" size="45"/>
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
