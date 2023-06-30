<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Đăng nhập - Furama Resort Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <h1 class="text-center">Đăng nhập</h1>
    <%
        String message = (String)request.getAttribute("message"); // Lấy thông báo lỗi từ request nếu có
        if (message != null && !message.isEmpty()) { // Nếu có thông báo lỗi thì hiển thị
    %>
    <div class="alert alert-danger" role="alert">
        <%= message %>
    </div>
    <% } %>
    <form action="login" method="POST">
        <div class="mb-3">
            <label for="username" class="form-label">Tên đăng nhập:</label>
            <input type="text" class="form-control" id="username" name="username">
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Mật khẩu:</label>
            <input type="password" class="form-control" id="password" name="password">
        </div>
        <div class="d-grid gap-2">
            <button type="submit" class="btn btn-primary">Đăng nhập</button>
        </div>
    </form>
</div>
</body>
</html>