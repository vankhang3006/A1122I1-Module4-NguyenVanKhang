package controller;


import model.Contract.Contract;


import service.IContractService;
import service.impl.ContractService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "controller.ContractServlet", value = "/contract")
public class ContractServlet extends HttpServlet {
    private IContractService contractService = new ContractService();
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
                    deleteContract(request, response);
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
        List<Contract> contractList = contractService.selectAllContracts();
        request.setAttribute("contractList", contractList);
        request.getRequestDispatcher("contract/list.jsp").forward(request, response);
    }
    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("contract/add.jsp").forward(request, response);
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Contract existingContract = contractService.selectContract(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contract/edit.jsp");
        request.setAttribute("contract", existingContract);
        dispatcher.forward(request, response);
    }
    private void deleteContract(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        contractService.deleteContract(id);

        List<Contract> listContract = contractService.selectAllContracts();
        request.setAttribute("listContract", listContract);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contract/list.jsp");
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
                    editContract(request,response);
                    break;

            }
        }catch (SQLException ex){
            throw new ServletException(ex);
        }
    }
    private void editContract(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int contractId = Integer.parseInt(request.getParameter("contractId"));
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        double deposit = Double.parseDouble(request.getParameter("deposit"));
        Contract book = new Contract(contractId, startDate, endDate, deposit);
        contractService.updateContract(book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("contract/edit.jsp");
        dispatcher.forward(request, response);
    }


    private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        double deposit = Double.parseDouble(request.getParameter("deposit"));
        Contract newContract = new Contract(startDate,endDate,deposit);
        boolean check = contractService.insertContract(newContract);
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
