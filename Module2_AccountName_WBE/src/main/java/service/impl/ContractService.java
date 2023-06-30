package service.impl;

import model.Contract.Contract;
import repository.IContractRepository;
import repository.impl.ContractRepository;
import service.IContractService;

import java.sql.SQLException;
import java.util.List;

public class ContractService implements IContractService {
    private IContractRepository contractRepository = new ContractRepository();
    @Override
    public boolean insertContract(Contract contract) throws SQLException {
        return contractRepository.insertContract(contract);
    }

    @Override
    public Contract selectContract(int id) {
        return contractRepository.selectContract(id);
    }

    @Override
    public List<Contract> selectAllContracts() {
        return contractRepository.selectAllContracts();
    }

    @Override
    public boolean deleteContract(int id) throws SQLException {
        return contractRepository.deleteContract(id);
    }

    @Override
    public boolean updateContract(Contract contract) throws SQLException {
        return contractRepository.updateContract(contract);
    }
}
