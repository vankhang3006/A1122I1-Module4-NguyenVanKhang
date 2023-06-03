
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<c:import url="header.jsp"></c:import>
<style>
    * { /* reset lại margin và padding cho các tag */
        margin: 0;
        padding: 0;
    }
    img{
        height: 100px;
        width: 100px;
    }
    .tableStyle {
        width: 100%;
    }
    .tableStyle td {
        height: 60px;
        padding: 10px;
    }
    .vAlignC { vertical-align: middle; }
</style>
<body>
<center>
    <h1>Danh sách khách hàng</h1>
    <table class="table table-light">
        <tr>
            <th>Tên</th>
            <th>Ngày sinh</th>
            <th>Địa chỉ</th>
            <th>Ảnh</th>
        </tr>
        <c:forEach var="customer" items="${customerList}" varStatus="status">
            <tr>
                <td class="vAlignC">${customer.getName()}</td>
                <td class="vAlignC">${customer.getBirthday()}</td>
                <td class="vAlignC">${customer.getAddress()}</td>
                <td class="vAlignC"><img src="${customer.getImg()}"></td>
            </tr>
        </c:forEach>
    </table>
</center>

</body>
</html>
