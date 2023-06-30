package controller;

import model.Product;
import model.Product;
import model.Product;
import model.Product;
import service.IProductService;
import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "controller.ProductServlet", value = "/product")
public class ProductServlet extends HttpServlet {
    private IProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null){
            action ="";
        }
        try {
            switch (action){
                case "edit":
                    showEditForm(request,response);
                    break;
                case "add":
                    showAddForm(request,response);
                    break;
                case "findName":
                    findProductByName(request, response);
                    break;
                case "findPrice":
                    findProductByPrice(request, response);
                    break;
                default:
                    showList(request,response);

            }
        }catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }

    private void findProductByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String name = request.getParameter("name");
        List<Product> productSearchList = this.productService.searchProductByName(name);
        RequestDispatcher dispatcher;
        if(productSearchList == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("productSearchList", productSearchList);
            dispatcher = request.getRequestDispatcher("product/searchResult.jsp");
        }
        dispatcher.forward(request, response);
    }
    private void findProductByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        double price = Double.parseDouble(request.getParameter("price"));
        List<Product> productSearchList = this.productService.searchProductByPrice(price);
        RequestDispatcher dispatcher;
        if(productSearchList == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("productSearchList", productSearchList);
            dispatcher = request.getRequestDispatcher("product/searchResult.jsp");
        }
        dispatcher.forward(request, response);
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        Product existingProduct = productService.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/edit.jsp");
        request.setAttribute("product", existingProduct);
        dispatcher.forward(request, response);
    }
    private void showAddForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("product/add.jsp").forward(request, response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        List<Product> productList = productService.findAll();
        request.setAttribute("productList", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
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
                    editProduct(request,response);
                    break;
                case "delete":
                    deleteProduct(request,response);
                    break;

            }
        }catch (SQLException ex){
            throw new ServletException(ex);
        }

    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        Product book = new Product(id,name,price,quantity,color,categoryId);
        boolean check = productService.edit(book);
        String mess ="Cập nhật thành công";
        if (!check){
            mess= "Cập nhật không thành công";
            request.setAttribute("mess", mess);
            showEditForm(request,response);
        }
        request.setAttribute("mess", mess);
        showList(request,response);
//        productService.edit(book);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("product/edit.jsp");
//        dispatcher.forward(request, response);
    }
    

    private void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        Product newProduct = new Product(id,name,price,quantity,color,categoryId);
        boolean check = productService.insertProduct(newProduct);
        String mess ="Thêm mới thành công";
        if (!check){
            mess= "Thêm mới không thành công";
            request.setAttribute("mess", mess);
            showAddForm(request,response);
        }
        request.setAttribute("mess", mess);
        showList(request,response);

    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        int idDelete = Integer.parseInt(request.getParameter("idDelete"));
        boolean check = productService.deleteProduct(idDelete);
        response.sendRedirect("/product?delM="+ check);
    }
}
