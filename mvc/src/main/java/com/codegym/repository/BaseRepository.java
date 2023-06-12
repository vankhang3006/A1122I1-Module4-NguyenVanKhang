package com.codegym.repository;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class BaseRepository {
    private static final String URL ="jdbc:mysql://localhost:3306/demo"; // sửa lại tên của csdl
    private static final String USER ="root";// mặc định của mysql
    private static final String PASS ="abc123456";// do cài đặt khi cài đặt mysql
    public static Connection getConnectDB(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection(URL,USER,PASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        BaseRepository baseRepository = new BaseRepository();
        System.out.println(baseRepository.getConnectDB());
    }
}
;