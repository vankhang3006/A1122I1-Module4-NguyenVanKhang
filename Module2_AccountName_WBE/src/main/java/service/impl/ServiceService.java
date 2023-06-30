package service.impl;

import model.service.Service;
import repository.IEmployeeRepository;
import repository.IServiceRepository;
import repository.impl.EmployeeRepository;
import repository.impl.ServiceRepository;
import service.IServiceService;

import java.sql.SQLException;
import java.util.List;

public class ServiceService implements IServiceService {
    private IServiceRepository serviceRepository = new ServiceRepository();
    @Override
    public boolean insertService(Service service) throws SQLException {
        return serviceRepository.insertService(service);
    }

    @Override
    public Service selectService(int id) {
        return serviceRepository.selectService(id);
    }

    @Override
    public List<Service> selectAllServices() {
        return serviceRepository.selectAllServices();
    }

    @Override
    public boolean deleteService(int id) throws SQLException {
        return serviceRepository.deleteService(id);
    }

    @Override
    public boolean updateService(Service service) throws SQLException {
        return serviceRepository.updateService(service);
    }
}
