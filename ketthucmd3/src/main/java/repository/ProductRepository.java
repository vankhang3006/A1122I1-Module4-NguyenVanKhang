package repository;

import model.Product;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository{
    private final String SELECT_ALL ="SELECT * FROM product;";
    private final String UPDATE_PRODUCT ="update product set name = ?,price = ?,quantity = ?, color = ?, category_id = ? where id = ?;";
    private final String SELECT_PRODUCT_BY_ID= "select id, name, price, quantity, color, category_id from product where id =?";
    private final String DELETE_PRODUCT = "delete from product where id = ?;";
    private final String INSERT_INTO ="insert into product(id,name,price,quantity,color,category_id) values(?,?,?,?,?,?);";
    private final String SELECT_PRODUCT_BY_NAME= "select id, name, price, quantity, color, category_id from product where name like ?";
    private final String SELECT_PRODUCT_BY_PRICE= "select id, name, price, quantity, color, category_id from product where price =?";

    public ProductRepository() {
    }

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        // kết nối db
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                int categoryId = resultSet.getInt("category_id");
                Product product = new Product(id,name,price,quantity,color,categoryId);
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public boolean edit(Product product) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = BaseRepository.getConnectDB(); PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCT);) {
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setInt(3,product.getQuantity());
            statement.setString(4, product.getColor());
            statement.setInt(5,product.getCategoryId());
            statement.setInt(6,product.getId());
            System.out.println(statement);
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public Product findById(int id) {
        Product product = null;
        // Step 1: Establishing a Connection
        try (Connection connection = BaseRepository.getConnectDB();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name =rs.getString("name");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                int categoryId = rs.getInt("category_id");
                product = new Product(id,name,price,quantity,color,categoryId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public boolean deleteProduct(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = BaseRepository.getConnectDB(); PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean insertProduct(Product product) throws SQLException {
        // kết nối db
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setInt(1,product.getId());
            preparedStatement.setString(2,product.getName());
            preparedStatement.setDouble(3,product.getPrice());
            preparedStatement.setInt(4,product.getQuantity());
            preparedStatement.setString(5,product.getColor());
            preparedStatement.setInt(6,product.getCategoryId());
            return preparedStatement.executeUpdate()>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Product> searchProductByName(String name) {

        List<Product> productList = new ArrayList<>();
        // kết nối db
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_NAME);
            preparedStatement.setString(1,"%" + name +"%");
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String resultSearchName = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                int categoryId = resultSet.getInt("category_id");
                Product product = new Product(id,resultSearchName,price,quantity,color,categoryId);
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public List<Product> searchProductByPrice(double price) {
        List<Product> productList = new ArrayList<>();
        // kết nối db
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_PRICE);
            preparedStatement.setDouble(1,price);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String resultSearchName = resultSet.getString("name");
                double resultPrice = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                int categoryId = resultSet.getInt("category_id");
                Product product = new Product(id,resultSearchName,resultPrice,quantity,color,categoryId);
                productList.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
}
