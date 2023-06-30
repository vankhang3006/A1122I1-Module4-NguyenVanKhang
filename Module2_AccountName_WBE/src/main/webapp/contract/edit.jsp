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
        <h2>Cập nhật thông tin hợp đồng</h2>
        <h3>
            <a href="contract?action=contract">Danh sách hợp đồng</a>
        </h3>
        <form method="post">
            <table border="1" cellpadding="5">
                <caption>
                    <h2>Thông tin hợp đồng chi tiết</h2>
                </caption>
                <c:if test="${contract != null}">
                    <input type="hidden" name="contractId" value="<c:out value='${contract.contractId}' />"/>
                </c:if>
                <tr>
                    <th>Ngày làm hợp đồng:</th>
                    <td>
                        <input type="text" name="contractName" size="45"
                               value="<c:out value='${contract.startDate}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Ngày kết thúc:</th>
                    <td>
                        <input type="text" name="contractBirthday" size="45"
                               value="<c:out value='${contract.endDate}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Tiền đặt cọc:</th>
                    <td>
                        <input type="text" name="deposit" id="deposit" value="<fmt:formatNumber type="number" pattern="#.########" value="${contract.deposit}" ></fmt:formatNumber>">
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
