package service;

import model.Product;

import repository.IProductRepository;
import repository.ProductRepository;

import java.sql.SQLException;
import java.util.List;

public class ProductService implements IProductService{
    private IProductRepository productRepository = new ProductRepository();
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public boolean edit(Product product) throws SQLException {
        return productRepository.edit(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public boolean deleteProduct(int id) throws SQLException {
        return productRepository.deleteProduct(id);
    }

    @Override
    public boolean insertProduct(Product product) throws SQLException {
        return productRepository.insertProduct(product);
    }

    @Override
    public List<Product> searchProductByName(String name) {
        return productRepository.searchProductByName(name);
    }

    @Override
    public List<Product> searchProductByPrice(double price) {
        return productRepository.searchProductByPrice(price);
    }
}
