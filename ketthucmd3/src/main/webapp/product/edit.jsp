<%--
  Created by IntelliJ IDEA.
  User: KhangNguyen
  Date: 25/6/2023
  Time: 11:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Edit Product</title>
</head>
<center>
    <body>
    <p style="color: red">${mess}</p>
    <h2>
        <a href="product?action=product">List All Products</a>
    </h2>
    <div>
        <form method="post">
            <table border="1" cellpadding="5">
                <caption>
                    <h2>Sửa thông tin mặt hàng</h2>
                </caption>
                <c:if test="${product != null}">
                    <input type="hidden" name="id" value="<c:out value='${product.id}' />"/>
                </c:if>
                <tr>
                    <th>Tên sản phẩm:</th>
                    <td>
                        <input type="text" name="name" size="45"
                               value="<c:out value='${product.name}' />" required
                        />
                    </td>
                </tr>
                <tr>
                    <th>Price:</th>
                    <td>
                        <input type="text" name="price" size="45"
                               value="<c:out value='${product.price}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Quantity:</th>
                    <td>
                        <input  type="text" name="quantity" size="45"
                               value="<c:out value='${product.quantity}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Color:</th>
                    <td>
                        <input type="text" name="color" size="45"
                               value="<c:out value='${product.color}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Category ID:</th>
                    <td>
                        <input type="text" name="categoryId" size="45"
                               value="<c:out value='${product.categoryId}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th></th>
                    <td>
                        <input type="submit" value="Sửa"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    </body>
</center>
</html>
<%--<input type="tel" id="phone" name="phone" pattern="[0-9]{10}" placeholder="Nhập số điện thoại của bạn" required>--%>
<%--<input type="email" id="email" name="email" placeholder="Nhập địa chỉ email của bạn" required>--%>