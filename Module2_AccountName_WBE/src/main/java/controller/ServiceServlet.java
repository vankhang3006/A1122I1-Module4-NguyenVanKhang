package controller;

import model.service.Service;
import model.service.Service;
import service.IServiceService;
import service.IServiceService;
import service.impl.ServiceService;
import service.impl.ServiceService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "controller.ServiceServlet", value = "/service")
public class ServiceServlet extends HttpServlet {
    private IServiceService serviceService = new ServiceService();
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
                    deleteService(request, response);
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
        List<Service> serviceList = serviceService.selectAllServices();
        request.setAttribute("serviceList", serviceList);
        request.getRequestDispatcher("service/list.jsp").forward(request, response);
    }
    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("service/add.jsp").forward(request, response);
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Service existingService = serviceService.selectService(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/edit.jsp");
        request.setAttribute("service", existingService);
        dispatcher.forward(request, response);
    }
    private void deleteService(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        serviceService.deleteService(id);

        List<Service> listService = serviceService.selectAllServices();
        request.setAttribute("listService", listService);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/list.jsp");
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
                    editService(request,response);
                    break;

            }
        }catch (SQLException ex){
            throw new ServletException(ex);
        }
    }
    private void editService(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double area = Double.parseDouble(request.getParameter("area"));
        double price = Double.parseDouble(request.getParameter("price"));
        int maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
        String standardRoom = request.getParameter("standardRoom");
        String description = request.getParameter("description");
        int poolArea = Integer.parseInt(request.getParameter("poolArea"));
        int floorNumber = Integer.parseInt(request.getParameter("floorNumber"));
        int rentTypeId = Integer.parseInt(request.getParameter("rentTypeId"));
        int serviceTypeId = Integer.parseInt(request.getParameter("serviceTypeId"));
        Service book = new Service(id, name, area, price, maxPeople, standardRoom, description, poolArea, floorNumber, rentTypeId, serviceTypeId);
        serviceService.updateService(book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("service/edit.jsp");
        dispatcher.forward(request, response);
    }


    private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String name = request.getParameter("name");
        double area = Double.parseDouble(request.getParameter("area"));
        double price = Double.parseDouble(request.getParameter("price"));
        int maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
        String standardRoom = request.getParameter("standardRoom");
        String description = request.getParameter("description");
        int poolArea = Integer.parseInt(request.getParameter("poolArea"));
        int floorNumber = Integer.parseInt(request.getParameter("floorNumber"));
        int rentTypeId = Integer.parseInt(request.getParameter("rentTypeId"));
        int serviceTypeId = Integer.parseInt(request.getParameter("serviceTypeId"));
        Service newService = new Service(name, area, price, maxPeople, standardRoom, description, poolArea, floorNumber, rentTypeId, serviceTypeId);
        boolean check = serviceService.insertService(newService);
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
