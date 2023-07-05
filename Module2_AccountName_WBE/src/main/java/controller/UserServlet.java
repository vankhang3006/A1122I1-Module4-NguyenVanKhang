package controller;

import model.user.User;
import repository.BaseRepository;
import service.IUserService;
import service.impl.UserService;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet(name = "controller.UserServlet", value="/login")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IUserService userService = new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();

        String username = request.getParameter("username"); // Lấy tên đăng nhập từ form
        String password = request.getParameter("password"); // Lấy mật khẩu từ form
        User user = this.userService.selectUser(username, password);
        RequestDispatcher dispatcher;
        if(user == null){
            String message = "Tên đăng nhập hoặc mật khẩu không đúng!";
            request.setAttribute("message", message); // Đặt thông báo lỗi vào request
            request.getSession().setAttribute("username", username);
            request.getSession().setAttribute("password", password);

            dispatcher=request.getRequestDispatcher("login.jsp"); // Điều hướng người dùng quay lại trang đăng nhập
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("user", user);
            dispatcher = request.getRequestDispatcher("index.jsp");
        }
        dispatcher.forward(request, response);
        // Thực hiện kết nối tới cơ sở dữ liệu
//        try (Connection conn = BaseRepository.getConnectDB()) {
//
//            // Tạo truy vấn SQL
//            PreparedStatement pstmt = conn.prepareStatement("SELECT real_name FROM user WHERE username = ? AND password = ?");
//            pstmt.setString(1, username);
//            pstmt.setString(2, password);
//
//            // Thực hiện truy vấn và lấy kết quả
//            ResultSet rs = pstmt.executeQuery();
//
//            if (rs.next()) { // Nếu có kết quả trả về từ truy vấn
//                String realName = rs.getString("real_name"); // Lấy tên đầy đủ của người dùng từ cột "real_name" trong bảng "user"
//
//                // Lưu tên đăng nhập và tên đầy đủ của người dùng vào đối tượng Session
//                request.getSession().setAttribute("username", username);
//                request.getSession().setAttribute("realName", realName);
//
//                // Chuyển hướng người dùng đến trang chủ của hệ thống
//                response.sendRedirect("index.jsp");
//            }
//            // Nếu không tìm thấy người dùng với tên đăng nhập hoặc mật khẩu không đúng
//            if (!rs.next()) {
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            out.println("<h2>Lỗi kết nối cơ sở dữ liệu!</h2>");
//        }
    }
}
