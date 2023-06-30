package service;

import model.employee.Employee;

import java.sql.SQLException;
import java.util.List;

public interface IEmployeeService {
    public boolean insertEmployee(Employee employee) throws SQLException;

    public Employee selectEmployee(int id);

    public List<Employee> selectAllEmployees();

    public boolean deleteEmployee(int id) throws SQLException;

    public boolean updateEmployee(Employee employee) throws SQLException;

    public Employee searchEmployeeByName(String name);

    public List<Employee> getEmployeesByPage(int startRecord, int recordsPerPage) ;
}
