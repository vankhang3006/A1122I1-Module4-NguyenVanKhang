package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService{
    private static List<Product> products = new ArrayList<>();
    static {
        products.add(new Product(1,"IPhone X", 799, "New Seal", "Apple"));
        products.add(new Product(2,"IPhone 14", 1399, "New Seal, Full option", "Apple"));
        products.add(new Product(3,"Samsung Z Flip", 899, "Best option", "Samsung"));
        products.add(new Product(4,"Samsung Z Fold", 1299, "Best Seller", "Samsung"));
        products.add(new Product(5,"Redmi Note 13", 599, "New Product", "Redmi"));
    }
    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id-1);
    }

    @Override
    public List<Product> searchByName(String searchName) {
        List<Product> searchList = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().toLowerCase().contains(searchName.toLowerCase())) {
                searchList.add(product);
            }
        }
        return searchList;
    }

    @Override
    public void update(int id, Product product) {
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            if (p.getId() == id) {
                products.set(i, product);
                break;
            }
        }
    }

    @Override
    public void remove(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.remove(i);
                break;
            }
        }
    }
}
