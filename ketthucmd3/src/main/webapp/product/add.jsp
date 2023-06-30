<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %><%--
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
    <title>Add Product Form</title>
    <link href="https://cdn.datatables.net/1.13.4/css/dataTables.bootstrap5.min.css" rel="stylesheet"
          crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
    <link href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css" rel="stylesheet">
</head>

<body>
<h2>Add new product</h2>
<p>${mess}</p>
<form action="/product?action=add" method="post">
    <table border="1" cellpadding="5">
        <tr>
            <th>Id:</th>
            <td>
                <input type="text" name="id" id="id" size="45" required/>
            </td>
        </tr>
        <tr>
            <th>Name:</th>
            <td>
                <input type="text" name="name" id="name" size="45" required/>
            </td>
        </tr>
        <tr>
            <th>Price:</th>
            <td>
                <input type="text" name="price" id="price" size="45"/>
                <span id="errorMsg" style="color: red;"></span>

            </td>
        </tr>
        <th>Quantity:</th>
        <td>
            <input type="text" name="quantity" id="quantity" size="45" required/>
        </td>
        <tr>
            <th>Color:</th>
            <td>
                <select name="color">
                    <option value="Đỏ">Đỏ</option>
                    <option value="Xanh">Xanh</option>
                    <option value="Đen">Đen</option>
                    <option value="Trắng">Trắng</option>
                    <option value="Vàng">Vàng</option>
                </select>

            </td>
        </tr>
        <tr>
            <th>Description:</th>
            <td>
                <input type="text" size="45"/>
            </td>
        </tr>
        <tr>
            <th>Category:</th>
            <td>
                <select name="categoryId">
                    <option value="1">Phone</option>
                    <option value="2">Tivi</option>
                    <option value="3">Tủ lạnh</option>
                    <option value="4">Máy giặt</option>
                    <option value="5">Máy tính</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Create"/>
            </td>
            <td>
                <a href="product?action=product">Back</a>
            </td>
        </tr>
    </table>
</form>
<script>

    const priceInput = document.getElementById('price');

    // Add event listener to the area input
    priceInput.addEventListener('input', (event) => {
        const inputValue = event.target.value;

        // Check if the input value is greater than 20
        if (inputValue > 300) {
            priceInput.setCustomValidity('');
        } else {
            priceInput.setCustomValidity('The price must be greater than 10000000.');
        }
    });
    const quantityInput = document.getElementById('quantity');

    // Add event listener to the area input
    quantityInput.addEventListener('input', (event) => {
        const inputValue = event.target.value;

        // Check if the input value is greater than 20
        if (inputValue > 0) {
            quantityInput.setCustomValidity('');
        } else {
            quantityInput.setCustomValidity('Quantity must be greater than 0.');
        }
    });


</script>
</body>
</html>
