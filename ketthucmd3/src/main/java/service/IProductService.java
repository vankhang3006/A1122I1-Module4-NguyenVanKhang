package service;

import model.Product;


import java.sql.SQLException;
import java.util.List;

public interface IProductService {
    List<Product> findAll();
    public boolean edit(Product product) throws SQLException;
    Product findById(int id);
    public boolean deleteProduct(int id) throws SQLException;
    public boolean insertProduct(Product product) throws SQLException;
    public List<Product> searchProductByName(String name) ;

    public List<Product> searchProductByPrice(double price) ;
}
