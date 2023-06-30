package service;

import model.Contract.Contract;


import java.sql.SQLException;
import java.util.List;

public interface IContractService {
    public boolean insertContract(Contract contract) throws SQLException;

    public Contract selectContract(int id);

    public List<Contract> selectAllContracts();

    public boolean deleteContract(int id) throws SQLException;

    public boolean updateContract(Contract contract) throws SQLException;
}
