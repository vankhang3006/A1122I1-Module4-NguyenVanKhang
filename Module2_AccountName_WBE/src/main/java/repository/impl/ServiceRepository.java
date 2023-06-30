package repository.impl;

import model.service.Service;
import model.service.Service;
import model.service.Service;
import repository.BaseRepository;
import repository.IServiceRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepository implements IServiceRepository {
    private final String SELECT_ALL ="SELECT * FROM dich_vu;";
    private final String SELECT_SERVICE_BY_ID= "select ma_dich_vu,ten_dich_vu,dien_tich,chi_phi_thue,so_nguoi_toi_da,tieu_chuan_phong,mo_ta_tien_nghi_khac,dien_tich_ho_boi,so_tang,ma_kieu_thue,ma_loai_dich_vu from dich_vu where ma_dich_vu =?";
    private final String INSERT_INTO ="insert into dich_vu(ten_dich_vu,dien_tich,chi_phi_thue,so_nguoi_toi_da,tieu_chuan_phong,mo_ta_tien_nghi_khac,dien_tich_ho_boi,so_tang,ma_kieu_thue,ma_loai_dich_vu) values(?,?,?,?,?,?,?,?,?,?);";
    private final String DELETE_SERVICE = "delete from dich_vu where ma_dich_vu = ?;";
    private final String UPDATE_SERVICE = "update dich_vu set ten_dich_vu = ?,dien_tich = ?,chi_phi_thue = ?,so_nguoi_toi_da = ?,tieu_chuan_phong = ?,mo_ta_tien_nghi_khac = ?,dien_tich_ho_boi = ?,so_tang = ?,ma_kieu_thue = ?,ma_loai_dich_vu = ? where ma_dich_vu = ?;";

    public ServiceRepository() {
    }

    @Override
    public boolean insertService(Service service) throws SQLException {
        // kết nối db
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setString(1,service.getName());
            preparedStatement.setDouble(2,service.getArea());
            preparedStatement.setDouble(3,service.getPrice());
            preparedStatement.setInt(4,service.getMaxPeople());
            preparedStatement.setString(5,service.getStandardRoom());
            preparedStatement.setString(6,service.getDescription());
            preparedStatement.setInt(7,service.getPoolArea());
            preparedStatement.setInt(8,service.getFloorNumber());
            preparedStatement.setInt(9,service.getRentTypeId());
            preparedStatement.setInt(10,service.getServiceTypeId());
            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Service selectService(int id) {
        Service service = null;
        // Step 1: Establishing a Connection
        try (Connection connection = BaseRepository.getConnectDB();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SERVICE_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (resultSet.next()) {
                String name = resultSet.getString("ten_dich_vu");
                double area = resultSet.getDouble("dien_tich");
                double price = resultSet.getDouble("chi_phi_thue");
                int maxPeople = resultSet.getInt("so_nguoi_toi_da");
                String standardRoom = resultSet.getString("tieu_chuan_phong");
                String description = resultSet.getString("mo_ta_tien_nghi_khac");
                int poolArea = resultSet.getInt("dien_tich_ho_boi");
                int floorNumber = resultSet.getInt("so_tang");
                int rentTypeId = resultSet.getInt("ma_kieu_thue");
                int serviceTypeId = resultSet.getInt("ma_loai_dich_vu");
                service = new Service(id,name,area,price,maxPeople,standardRoom,description,poolArea,floorNumber,rentTypeId,serviceTypeId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return service;
    }

    @Override
    public List<Service> selectAllServices() {
        List<Service> serviceList = new ArrayList<>();
        // kết nối db
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("ma_dich_vu");
                String name = resultSet.getString("ten_dich_vu");
                double area = resultSet.getDouble("dien_tich");
                double price = resultSet.getDouble("chi_phi_thue");
                int maxPeople = resultSet.getInt("so_nguoi_toi_da");
                String standardRoom = resultSet.getString("tieu_chuan_phong");
                String description = resultSet.getString("mo_ta_tien_nghi_khac");
                int poolArea = resultSet.getInt("dien_tich_ho_boi");
                int floorNumber = resultSet.getInt("so_tang");
                int rentTypeId = resultSet.getInt("ma_kieu_thue");
                int serviceTypeId = resultSet.getInt("ma_loai_dich_vu");
                Service service = new Service(id,name,area,price,maxPeople,standardRoom,description,poolArea,floorNumber,rentTypeId,serviceTypeId);
                serviceList.add(service);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceList;
    }

    @Override
    public boolean deleteService(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = BaseRepository.getConnectDB(); PreparedStatement statement = connection.prepareStatement(DELETE_SERVICE);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateService(Service service) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = BaseRepository.getConnectDB(); PreparedStatement statement = connection.prepareStatement(UPDATE_SERVICE);) {
            statement.setString(1,service.getName());
            statement.setDouble(2,service.getArea());
            statement.setDouble(3,service.getPrice());
            statement.setInt(4,service.getMaxPeople());
            statement.setString(5,service.getStandardRoom());
            statement.setString(6,service.getDescription());
            statement.setInt(7,service.getPoolArea());
            statement.setInt(8,service.getFloorNumber());
            statement.setInt(9,service.getRentTypeId());
            statement.setInt(10,service.getServiceTypeId());
            statement.setInt(11,service.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}
