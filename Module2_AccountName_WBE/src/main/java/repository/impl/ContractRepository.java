package repository.impl;

import model.Contract.Contract;
import repository.BaseRepository;
import repository.IContractRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractRepository implements IContractRepository {
    private final String SELECT_ALL ="SELECT ma_hop_dong,ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc FROM hop_dong;";
    private final String SELECT_CONTRACT_BY_ID= "select ma_hop_dong,ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc from hop_dong where ma_hop_dong =?";
    private final String INSERT_INTO ="insert into hop_dong(ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc) values(?,?,?);";
    private final String DELETE_CONTRACT = "delete from hop_dong where ma_hop_dong = ?;";
    private final String UPDATE_CONTRACT = "update hop_dong set ngay_lam_hop_dong = ?,ngay_ket_thuc = ?,tien_dat_coc = ? where ma_hop_dong = ?;";

    public ContractRepository() {
    }

    @Override
    public boolean insertContract(Contract contract) throws SQLException {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setString(1,contract.getStartDate());
            preparedStatement.setString(2,contract.getEndDate());
            preparedStatement.setDouble(3,contract.getDeposit());
            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Contract selectContract(int id) {
        return null;
    }

    @Override
    public List<Contract> selectAllContracts() {
        List<Contract> contractList = new ArrayList<>();
        // kết nối db
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int contractId = resultSet.getInt("ma_hop_dong");
                String startDate = resultSet.getString("ngay_lam_hop_dong");
                String endDate = resultSet.getString("ngay_ket_thuc");
                double deposit = resultSet.getDouble("tien_dat_coc");
                Contract contract = new Contract(contractId,startDate,endDate,deposit);
                contractList.add(contract);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contractList;
    }

    @Override
    public boolean deleteContract(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = BaseRepository.getConnectDB(); PreparedStatement statement = connection.prepareStatement(DELETE_CONTRACT);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateContract(Contract contract) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = BaseRepository.getConnectDB(); PreparedStatement statement = connection.prepareStatement(UPDATE_CONTRACT);) {
            statement.setString(1,contract.getStartDate());
            statement.setString(2,contract.getEndDate());
            statement.setDouble(3,contract.getDeposit());
            statement.setInt(4,contract.getContractId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}
