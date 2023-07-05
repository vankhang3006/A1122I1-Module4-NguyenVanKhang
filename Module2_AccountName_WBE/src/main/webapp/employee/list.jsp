
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Employee Management</title>
    <link href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
    <link href="style.css" rel="stylesheet">
</head>
<body>
<h1 style="text-align: center">Trang danh sách nhân viên</h1>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="index.jsp">Trang chủ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="employee">Nhân viên</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="customer">Khách hàng</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="service">Dịch vụ</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="contract">Hợp đồng</a>
                </li>

            </ul>
            <form class="d-flex">
                <input class="form-control me-2" id="search-name" type="input" placeholder="Search By Name" aria-label="Search">
                <button class="btn btn-outline-success" type="button" onclick="searchEmployee()">Search</button>
            </form>
        </div>
    </div>
</nav>
<button type="button" class="btn btn-primary" onclick="window.location.href='/employee?action=add'">
    <span class="bi bi-plus-circle"></span> Thêm mới
</button>
    <p style="color: red">${mess}</p>
<table id="employeeTable" class="table table-dark table-striped">
    <thead>
    <tr>
        <th>Id</th>
        <th>Họ tên</th>
        <th>Ngày sinh</th>
        <th>Số CMND</th>
        <th>Lương</th>
        <th>Số điện thoại</th>
        <th>Email</th>
        <th>Địa chỉ</th>
        <th>Vị trí</th>
        <th>Trình độ</th>
        <th>Bộ phận</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="employee" items="${employeeList}" >
        <tr>
            <td>${employee.employeeId}</td>
            <td>${employee.employeeName}</td>
            <td>${employee.employeeBirthday}</td>
            <td><fmt:formatNumber type="number" pattern="#.########" value="${employee.employeeIdCard}" ></fmt:formatNumber> </td>
            <td><fmt:formatNumber type="number" pattern="#.########" value="${employee.employeeSalary}" ></fmt:formatNumber> </td>
            <td>${employee.employeePhone}</td>
            <td>${employee.employeeEmail}</td>
            <td>${employee.employeeAddress}</td>
            <td>
                <c:choose>
                    <c:when test="${employee.position == 1 }">Quản Lý</c:when>
                    <c:when test="${employee.position == 2 }">Nhân Viên</c:when>
                </c:choose>
            </td>
            <td>
                <c:choose>
                    <c:when test="${employee.education == 1 }">Trung Cấp</c:when>
                    <c:when test="${employee.education == 2 }">Cao đẳng</c:when>
                    <c:when test="${employee.education == 3 }">Đại học</c:when>
                    <c:when test="${employee.education == 4 }">Sau Đại Học</c:when>
                </c:choose>
            </td>
            <td>
                <c:choose>
                    <c:when test="${employee.division == 1 }">Sale-Marketing</c:when>
                    <c:when test="${employee.division == 2 }">Hành chính</c:when>
                    <c:when test="${employee.division == 3 }">Phục vụ</c:when>
                    <c:when test="${employee.division == 4 }">Quản lý</c:when>
                </c:choose>
            </td>
            <td>
                <button type="button" class="btn btn-danger" onclick="window.location.href='/employee?action=delete&id=${employee.employeeId}'">
                    <span class="bi bi-trash"></span> Xoá
                </button>

                <button type="button" class="btn btn-primary" onclick="window.location.href='/employee?action=edit&id=${employee.employeeId}'">
                    <span class="bi bi-pencil"></span> Sửa
                </button>
            </td>
        </tr>
    </c:forEach>
    </tbody>

</table>
<script>
    $(document).ready(function() {
        $('#employeeTable').DataTable({
            "paging": true, // Hiển thị phân trang
            "lengthChange": false, // Ẩn chức năng thay đổi số lượng bản ghi trên một trang
            "searching": false, // Ẩn chức năng tìm kiếm
            "ordering": true, // Sắp xếp các bản ghi
            "info": false, // Hiển thị thông tin số bản ghi và số trang
            "autoWidth": true, // Tắt tính năng tự động thay đổi độ rộng cột
            "pageLength": 3, // Số bản ghi hiển thị trên mỗi trang
            "language": { // Văn bản trên các nút và câu thông báo
                "paginate": {
                    "first": "Đầu",
                    "last": "Cuối",
                    "next": "Sau",
                    "previous": "Trước"
                },
            }
        });
    });
    function searchEmployee() {
        // Lấy giá trị tên sản phẩm từ input
        var name = document.getElementById("search-name").value;
        // Chuyển hướng tới trang hiển thị kết quả tìm kiếm
        window.location.href = "/employee?action=find&name=" + name;
    }
</script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
