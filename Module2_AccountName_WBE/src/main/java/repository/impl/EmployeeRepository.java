package repository.impl;



import model.employee.Employee;
import repository.BaseRepository;
import repository.IEmployeeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private final String SELECT_ALL ="SELECT * FROM nhan_vien;";
    private final String SELECT_EMPLOYEE_BY_ID= "select ma_nhan_vien,ho_ten,ngay_sinh,so_cmnd,luong,so_dien_thoai,email,dia_chi,ma_vi_tri,ma_trinh_do,ma_bo_phan from nhan_vien where ma_nhan_vien =?";
    private final String INSERT_INTO ="insert into nhan_vien(ho_ten,ngay_sinh,so_cmnd,luong,so_dien_thoai,email,dia_chi,ma_vi_tri,ma_trinh_do,ma_bo_phan) values(?,?,?,?,?,?,?,?,?,?);";
    private final String DELETE_EMPLOYEE = "delete from nhan_vien where ma_nhan_vien = ?;";
    private final String UPDATE_EMPLOYEE = "update nhan_vien set ho_ten = ?,ngay_sinh = ?,so_cmnd = ?,luong = ?,so_dien_thoai = ?,email = ?,dia_chi = ?,ma_vi_tri = ?,ma_trinh_do = ?,ma_bo_phan = ? where ma_nhan_vien = ?;";
    private final String SELECT_EMPLOYEE_BY_NAME= "select ma_nhan_vien,ho_ten,ngay_sinh,so_cmnd,luong,so_dien_thoai,email,dia_chi,ma_vi_tri,ma_trinh_do,ma_bo_phan from nhan_vien where ho_ten =?";

    public EmployeeRepository() {
    }

    @Override
    public boolean insertEmployee(Employee employee) throws SQLException {
        // kết nối db
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setString(1,employee.getEmployeeName());
            preparedStatement.setString(2,employee.getEmployeeBirthday());
            preparedStatement.setDouble(3,employee.getEmployeeIdCard());
            preparedStatement.setDouble(4,employee.getEmployeeSalary());
            preparedStatement.setString(5,employee.getEmployeePhone());
            preparedStatement.setString(6,employee.getEmployeeEmail());
            preparedStatement.setString(7,employee.getEmployeeAddress());
            preparedStatement.setInt(8,employee.getPosition());
            preparedStatement.setInt(9,employee.getEducation());
            preparedStatement.setInt(10,employee.getDivision());
            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Employee selectEmployee(int id) {
        Employee employee = null;
        // Step 1: Establishing a Connection
        try (Connection connection = BaseRepository.getConnectDB();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("ho_ten");
                String birthday = rs.getString("ngay_sinh");
                double idCard = rs.getDouble("so_cmnd");
                double salary = rs.getDouble("luong");
                String phone = rs.getString("so_dien_thoai");
                String email = rs.getString("email");
                String address = rs.getString("dia_chi");
                int position = rs.getInt("ma_vi_tri");
                int education = rs.getInt("ma_trinh_do");
                int division = rs.getInt("ma_bo_phan");
                employee = new Employee(id,name,birthday,idCard,salary,phone,email,address,position,education,division);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> selectAllEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        // kết nối db
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("ma_nhan_vien");
                String name = resultSet.getString("ho_ten");
                String birthday = resultSet.getString("ngay_sinh");
                double idCard = resultSet.getDouble("so_cmnd");
                double salary = resultSet.getDouble("luong");
                String phone = resultSet.getString("so_dien_thoai");
                String email = resultSet.getString("email");
                String address = resultSet.getString("dia_chi");
                int position = resultSet.getInt("ma_vi_tri");
                int education = resultSet.getInt("ma_trinh_do");
                int division = resultSet.getInt("ma_bo_phan");
                Employee employee = new Employee(id,name,birthday,idCard,salary,phone,email,address,position,education,division);
                employeeList.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = BaseRepository.getConnectDB(); PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEE);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = BaseRepository.getConnectDB(); PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEE);) {
            statement.setString(1,employee.getEmployeeName());
            statement.setString(2,employee.getEmployeeBirthday());
            statement.setDouble(3,employee.getEmployeeIdCard());
            statement.setDouble(4,employee.getEmployeeSalary());
            statement.setString(5,employee.getEmployeePhone());
            statement.setString(6,employee.getEmployeeEmail());
            statement.setString(7,employee.getEmployeeAddress());
            statement.setInt(8,employee.getPosition());
            statement.setInt(9,employee.getEducation());
            statement.setInt(10,employee.getDivision());
            statement.setInt(11,employee.getEmployeeId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public Employee searchEmployeeByName(String name) {
        Employee employee = null;
        // Step 1: Establishing a Connection
        try (Connection connection = BaseRepository.getConnectDB();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_NAME);) {
            preparedStatement.setString(1, name);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("ma_nhan_vien");
                String birthday = rs.getString("ngay_sinh");
                double idCard = rs.getDouble("so_cmnd");
                double salary = rs.getDouble("luong");
                String phone = rs.getString("so_dien_thoai");
                String email = rs.getString("email");
                String address = rs.getString("dia_chi");
                int position = rs.getInt("ma_vi_tri");
                int education = rs.getInt("ma_trinh_do");
                int division = rs.getInt("ma_bo_phan");
                employee = new Employee(id,name,birthday,idCard,salary,phone,email,address,position,education,division);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> getEmployeesByPage(int startRecord, int recordsPerPage) {
        List<Employee> listEmployee = new ArrayList<>();
        try {
            Connection connection = BaseRepository.getConnectDB();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM nhan_vien LIMIT ?, ?");
            statement.setInt(1, startRecord);
            statement.setInt(2, recordsPerPage);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Employee employee = new Employee(resultSet.getString("ho_ten"), resultSet.getString("ngay_sinh"), resultSet.getDouble("so_cmnd"),resultSet.getDouble("luong"),resultSet.getString("so_dien_thoai"), resultSet.getString("email"), resultSet.getString("dia_chi"),resultSet.getInt("ma_vi_tri"),resultSet.getInt("ma_trinh_do"),resultSet.getInt("ma_bo_phan"));
                listEmployee.add(employee);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listEmployee;
    }
}
