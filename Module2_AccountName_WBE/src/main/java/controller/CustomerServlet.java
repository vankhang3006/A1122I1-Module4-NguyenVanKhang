package controller;

import model.customer.Customer;
import service.ICustomerService;
import service.impl.CustomerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "controller.CustomerServlet", value = "/customer")
public class CustomerServlet extends HttpServlet {
    private ICustomerService customerService = new CustomerService();
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
                    deleteCustomer(request, response);
                    break;
                case "find":
                    findCustomerByName(request, response);
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
        List<Customer> customerList = customerService.selectAllCustomers();
        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("customer/list.jsp").forward(request, response);
    }
    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("customer/add.jsp").forward(request, response);
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer existingCustomer = customerService.selectCustomer(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/edit.jsp");
        request.setAttribute("customer", existingCustomer);
        dispatcher.forward(request, response);
    }
    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        customerService.deleteCustomer(id);

        List<Customer> listCustomer = customerService.selectAllCustomers();
        request.setAttribute("listCustomer", listCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        dispatcher.forward(request, response);
    }
    private void findCustomerByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Customer customer = this.customerService.searchCustomerByName(name);
        RequestDispatcher dispatcher;
        if(customer == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("customer", customer);
            dispatcher = request.getRequestDispatcher("customer/view.jsp");
        }
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
                    editCustomer(request,response);
                    break;

            }
        }catch (SQLException ex){
            throw new ServletException(ex);
        }
    }
    private void editCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("customerId"));
        String name = request.getParameter("customerName");
        String birthday = request.getParameter("customerBirthday");
        boolean gender = Boolean.parseBoolean(request.getParameter("customerGender"));
        double idCard = Double.parseDouble(request.getParameter("customerIdCard"));
        String phone = request.getParameter("customerPhone");
        String email = request.getParameter("customerEmail");
        String address = request.getParameter("customerAddress");
        int customerType = Integer.parseInt(request.getParameter("customerType"));
        Customer book = new Customer(id, name, birthday, gender,idCard, phone, email, address, customerType);
        customerService.updateCustomer(book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/edit.jsp");
        dispatcher.forward(request, response);
    }


    private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String name = request.getParameter("customerName");
        String birthday = request.getParameter("customerBirthday");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        double idCard = Double.parseDouble(request.getParameter("customerIdCard"));
        String phone = request.getParameter("customerPhone");
        String email = request.getParameter("customerEmail");
        String address = request.getParameter("customerAddress");
        int customerType = Integer.parseInt(request.getParameter("customerType"));
        Customer newCustomer = new Customer(name, birthday, gender,idCard, phone, email, address, customerType);
        boolean check = customerService.insertCustomer(newCustomer);
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
