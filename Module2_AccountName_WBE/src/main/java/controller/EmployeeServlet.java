package controller;

import model.employee.Employee;
import model.employee.Employee;
import model.employee.Employee;
import service.IEmployeeService;
import service.impl.EmployeeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "controller.EmployeeServlet", value = "/employee")
public class EmployeeServlet extends HttpServlet {
    private IEmployeeService employeeService = new EmployeeService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action ="";
        }
        try {
            switch (action){
                case "add":
                    showAddForm(request,response);
                    break;
                case "edit":
                    showEditForm(request,response);
                    break;
                case "delete":
                    deleteEmployee(request, response);
                    break;
                case "find":
                    findEmployeeByName(request, response);
                    break;
                case "page":
                    pagination(request, response);
                    break;
                default:
                    showList(request,response);
                    break;
            }
        }catch (SQLException ex){
            throw new ServletException(ex);
        }
    }
    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employeeList = employeeService.selectAllEmployees();
        request.setAttribute("employeeList", employeeList);
        request.getRequestDispatcher("employee/list.jsp").forward(request, response);
    }
    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("employee/add.jsp").forward(request, response);
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee existingEmployee = employeeService.selectEmployee(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/edit.jsp");
        request.setAttribute("employee", existingEmployee);
        dispatcher.forward(request, response);
    }
    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        employeeService.deleteEmployee(id);

        List<Employee> listEmployee = employeeService.selectAllEmployees();
        request.setAttribute("listEmployee", listEmployee);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
        dispatcher.forward(request, response);
    }
    private void findEmployeeByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Employee employee = this.employeeService.searchEmployeeByName(name);
        RequestDispatcher dispatcher;
        if(employee == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("employee", employee);
            dispatcher = request.getRequestDispatcher("employee/view.jsp");
        }
        dispatcher.forward(request, response);

    }
    private void pagination(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String currentPageParam = request.getParameter("page");
        int currentPage = Integer.parseInt(currentPageParam);
        int recordsPerPage = 3; // Số bản ghi trên mỗi trang
        int startRecord = (currentPage - 1) * recordsPerPage; // Chỉ số bắt đầu của các bản ghi cần lấy
        List<Employee> listEmployee = employeeService.getEmployeesByPage(startRecord, recordsPerPage);
        int totalRecords = listEmployee.size(); // Tổng số bản ghi
        int totalPages = (int) Math.ceil((double) totalRecords / recordsPerPage); // Tổng số trang
        request.setAttribute("listEmployee", listEmployee); // Danh sách các Employee
        request.setAttribute("currentPage", currentPage); // Trang hiện tại
        request.setAttribute("totalPages", totalPages); // Tổng số trang
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
        dispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action ="";
        }
        try {
            switch (action){
                case "add":
                    save(request,response);
                    break;
                case "edit":
                    editEmployee(request,response);
                    break;

            }
        }catch (SQLException ex){
            throw new ServletException(ex);
        }
    }
    private void editEmployee(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("employeeId"));
        String name = request.getParameter("employeeName");
        String birthday = request.getParameter("employeeBirthday");
        double idCard = Double.parseDouble(request.getParameter("employeeIdCard"));
        double salary = Double.parseDouble(request.getParameter("employeeSalary"));
        String phone = request.getParameter("employeePhone");
        String email = request.getParameter("employeeEmail");
        String address = request.getParameter("employeeAddress");
        int position = Integer.parseInt(request.getParameter("position"));
        int education = Integer.parseInt(request.getParameter("education"));
        int division = Integer.parseInt(request.getParameter("division"));
        Employee book = new Employee(id, name, birthday, idCard, salary, phone, email, address, position, education, division);
        boolean check = employeeService.updateEmployee(book);
        String mess ="Cập nhật thành công";
        if (!check){
            mess= "Cập nhật không thành công";
            request.setAttribute("mess", mess);
            showEditForm(request,response);
        }
        request.setAttribute("mess", mess);
        showList(request,response);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/edit.jsp");
        dispatcher.forward(request, response);
    }


    private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String name = request.getParameter("employeeName");
        String birthday = request.getParameter("employeeBirthday");
        double idCard = Double.parseDouble(request.getParameter("employeeIdCard"));
        double salary = Double.parseDouble(request.getParameter("employeeSalary"));
        String phone = request.getParameter("employeePhone");
        String email = request.getParameter("employeeEmail");
        String address = request.getParameter("employeeAddress");
        int position = Integer.parseInt(request.getParameter("position"));
        int education = Integer.parseInt(request.getParameter("education"));
        int division = Integer.parseInt(request.getParameter("division"));
        Employee newEmployee = new Employee(name, birthday, idCard, salary, phone, email, address, position, education, division);
        boolean check = employeeService.insertEmployee(newEmployee);
        String mess ="Thêm mới thành công";
        if (!check){
            mess= "Thêm mới không thành công";
            request.setAttribute("mess", mess);
            showAddForm(request,response);
        }
        request.setAttribute("mess", mess);
        showList(request,response);
    }
}
