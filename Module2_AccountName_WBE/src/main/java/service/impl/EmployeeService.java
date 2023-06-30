package service.impl;

import model.employee.Employee;
import repository.IEmployeeRepository;
import repository.impl.EmployeeRepository;
import service.IEmployeeService;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService implements IEmployeeService {
    private IEmployeeRepository employeeRepository = new EmployeeRepository();
    @Override
    public boolean insertEmployee(Employee employee) throws SQLException {
        return employeeRepository.insertEmployee(employee);
    }

    @Override
    public Employee selectEmployee(int id) {
        return employeeRepository.selectEmployee(id);
    }

    @Override
    public List<Employee> selectAllEmployees() {
        return employeeRepository.selectAllEmployees();
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        return employeeRepository.deleteEmployee(id);
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        return employeeRepository.updateEmployee(employee);
    }

    @Override
    public Employee searchEmployeeByName(String name) {
        return employeeRepository.searchEmployeeByName(name);
    }

    @Override
    public List<Employee> getEmployeesByPage(int startRecord, int recordsPerPage) {
        return employeeRepository.getEmployeesByPage(startRecord,recordsPerPage);
    }
}
