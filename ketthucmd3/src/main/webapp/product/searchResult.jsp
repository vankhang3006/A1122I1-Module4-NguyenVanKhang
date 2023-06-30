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
    <title>Family Management</title>
    <%--    <link href="style.css" rel="stylesheet">--%>
    <%--    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>--%>
    <%--    <script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>--%>
    <%--    <link href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css" rel="stylesheet">--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>
<body>
<h1 style="text-align: center">Danh sách mặt hàng</h1>
<a href="/product?action=add">Thêm mới</a>
<form class="d-flex">
    <input class="form-control me-2" id="search-name" type="input" placeholder="Tìm theo tên" aria-label="Search">
    <button class="btn btn-outline-success" type="button" onclick="searchProductByName()">Search</button>
</form>
<form class="d-flex">
    <input class="form-control me-2" id="search-price" type="input" placeholder="Tìm theo giá" aria-label="Search">
    <button class="btn btn-outline-success" type="button" onclick="searchProductByPrice()">Search</button>
</form>
<p style="color: red">${mess}</p>

<table class="table table-success table-striped">
    <thead>
    <tr>
        <th>STT</th>
        <th>Product Name</th>
        <th>Price</th>
        <th>Quantity</th>
        <th>Color</th>
        <th>Category</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${productSearchList}" >
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.quantity}</td>
            <td>${product.color}</td>
            <td>${product.categoryId}</td>
            <td>
                <button class="btn btn-warning">Edit</button>
                <!-- Button trigger modal -->
                <button type="button" onclick="showInfoDelete('${product.getId()}')"
                        class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deleteModal">
                    Delete
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
    <%--Delete Modal--%>
    <div class=" modal fade" id="deleteModal" tabindex="-1" aria-labelledby="deleteModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form action="/product?action=delete" method="post">
                    <div class="modal-header">
                        <h5 class="modal-title" id="deleteModalLabel">Xoá mặt hàngg</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <input readonly type="text" id="idDelete" name="idDelete">
                        <span>Bạn có muốn xóa mặt hàng này?</span>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No
                        </button>
                        <button type="submit" class="btn btn-primary">Yes</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script>

    function searchProductByName() {
        // Lấy giá trị tên sản phẩm từ input
        var name = document.getElementById("search-name").value;
        // Chuyển hướng tới trang hiển thị kết quả tìm kiếm
        window.location.href = "/product?action=findName&name=" + name;
    }
    function searchProductByPrice() {
        // Lấy giá trị tên sản phẩm từ input
        var price = document.getElementById("search-price").value;
        // Chuyển hướng tới trang hiển thị kết quả tìm kiếm
        window.location.href = "/product?action=findPrice&price=" + price;
    }

    function showInfoDelete(id) {
        document.getElementById("idDelete").value = id;
    }
</script>

</body>
</html>
