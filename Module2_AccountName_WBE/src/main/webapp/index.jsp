<%--
  Created by IntelliJ IDEA.
  User: KhangNguyen
  Date: 17/6/2023
  Time: 10:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Furama Resort Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <link href="style.css" rel="stylesheet">
  </head>
  <div class="container">
    <header>
      <div class="header">
        <img src="logo.jpg" height="150px" width="150px">
        <h1 style="padding-left: 200px">Furama Resort Management</h1>
      </div>
    </header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <div class="container-fluid">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="index.jsp">Trang chủ</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="employee">Nhân viên</a>
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
            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success" type="submit">Search</button>
          </form>
        </div>
      </div>
    </nav>
    <aside>
      <a class="nav-link" href="login.jsp">Đăng nhập</a><br>
      <a href="https://codegym.vn">Liên hệ</a><br>
      <a href="https://codegym.vn">Giới thiệu</a>
    </aside>
    <article>
    </article>
    <footer>
      <p style="padding-top: 15px;">Bản quyền &copy; 2023 Trang web của tôi. Đã đăng ký bản quyền.</p>
    </footer>
  </div>
</html>
