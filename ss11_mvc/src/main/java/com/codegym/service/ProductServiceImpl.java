package com.codegym.service;


import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService{
    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Iphone 14 Pro Max", 1199, "New seal full box"));
        products.put(2, new Product(2, "Laptop Gaming Asus ROG Strix", 1329, "New seal full box"));
        products.put(3, new Product(3, "Headphone Beats Studio3", 232, "Good as new"));
        products.put(4, new Product(4, "Keychron K10", 128, "Newest version"));
        products.put(5, new Product(5, "Samsung Z Fold 4", 1549, "Hand-carried goods from New York"));
        products.put(6, new Product(6, "Samsung Z Flip 4", 999, "Hand-carried goods from Berlin"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public Product findByName(String name) {
        for (Product product : products.values()) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }

        return null;
    }


    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

}


