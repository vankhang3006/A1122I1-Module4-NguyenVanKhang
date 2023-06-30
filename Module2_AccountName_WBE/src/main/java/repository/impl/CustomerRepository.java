package repository.impl;

import model.customer.Customer;
import repository.BaseRepository;
import repository.ICustomerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private final String SELECT_ALL ="SELECT * FROM khach_hang;";
    private final String SELECT_CUSTOMER_BY_ID= "select ma_khach_hang,ho_ten,ngay_sinh,gioi_tinh,so_cmnd,so_dien_thoai,email,dia_chi,ma_loai_khach from khach_hang where ma_khach_hang =?";
    private final String INSERT_INTO ="insert into khach_hang(ho_ten,ngay_sinh,gioi_tinh,so_cmnd,so_dien_thoai,email,dia_chi,ma_loai_khach) values(?,?,?,?,?,?,?,?);";
    private final String DELETE_CUSTOMER = "delete from khach_hang where ma_khach_hang = ?;";
    private final String UPDATE_CUSTOMER = "update khach_hang set ho_ten = ?,ngay_sinh = ?, gioi_tinh = ?, so_cmnd = ?, so_dien_thoai = ?, email = ?, dia_chi = ?, ma_loai_khach = ? where ma_khach_hang = ?;";
    private final String SELECT_CUSTOMER_BY_NAME= "select ma_khach_hang,ho_ten,ngay_sinh,gioi_tinh,so_cmnd,so_dien_thoai,email,dia_chi,ma_loai_khach from khach_hang where ho_ten =?";

    public CustomerRepository() {
    }

    @Override
    public boolean insertCustomer(Customer customer) throws SQLException {

        // kết nối db
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setString(1,customer.getCustomerName());
            preparedStatement.setString(2,customer.getCustomerBirthday());
            preparedStatement.setBoolean(3,customer.isCustomerGender());
            preparedStatement.setDouble(4,customer.getCustomerIdCard());
            preparedStatement.setString(5,customer.getCustomerPhone());
            preparedStatement.setString(6,customer.getCustomerEmail());
            preparedStatement.setString(7,customer.getCustomerAddress());
            preparedStatement.setInt(8,customer.getCustomerType());
            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Customer selectCustomer(int id) {
        Customer customer = null;
        // Step 1: Establishing a Connection
        try (Connection connection = BaseRepository.getConnectDB();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("ho_ten");
                String birthday = rs.getString("ngay_sinh");
                boolean gender =rs.getBoolean("gioi_tinh");
                double idCard = rs.getDouble("so_cmnd");
                String phone = rs.getString("so_dien_thoai");
                String email = rs.getString("email");
                String address = rs.getString("dia_chi");
                int idCustomerType = rs.getInt("ma_loai_khach");
                customer = new Customer(id,name,birthday,gender,idCard,phone,email,address,idCustomerType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;

    }

    @Override
    public List<Customer> selectAllCustomers() {
        List<Customer> customerList = new ArrayList<>();
        // kết nối db
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("ma_khach_hang");
                String name = resultSet.getString("ho_ten");
                String birthday = resultSet.getString("ngay_sinh");
                boolean gender =resultSet.getBoolean("gioi_tinh");
                double idCard = resultSet.getDouble("so_cmnd");
                String phone = resultSet.getString("so_dien_thoai");
                String email = resultSet.getString("email");
                String address = resultSet.getString("dia_chi");
                int idCustomerType = resultSet.getInt("ma_loai_khach");
                Customer customer = new Customer(id,name,birthday,gender,idCard,phone,email,address,idCustomerType);
                customerList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = BaseRepository.getConnectDB(); PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = BaseRepository.getConnectDB(); PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMER);) {
            statement.setString(1,customer.getCustomerName());
            statement.setString(2,customer.getCustomerBirthday());
            statement.setBoolean(3,customer.isCustomerGender());
            statement.setDouble(4,customer.getCustomerIdCard());
            statement.setString(5,customer.getCustomerPhone());
            statement.setString(6,customer.getCustomerEmail());
            statement.setString(7,customer.getCustomerAddress());
            statement.setInt(8,customer.getCustomerType());
            statement.setInt(9,customer.getCustomerId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public Customer searchCustomerByName(String name){
        Customer customer = null;
        // Step 1: Establishing a Connection
        try (Connection connection = BaseRepository.getConnectDB();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_NAME);) {
            preparedStatement.setString(1, name);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("ma_khach_hang");
                String birthday = rs.getString("ngay_sinh");
                boolean gender =rs.getBoolean("gioi_tinh");
                double idCard = rs.getDouble("so_cmnd");
                String phone = rs.getString("so_dien_thoai");
                String email = rs.getString("email");
                String address = rs.getString("dia_chi");
                int idCustomerType = rs.getInt("ma_loai_khach");
                customer = new Customer(id,name,birthday,gender,idCard,phone,email,address,idCustomerType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }
}
