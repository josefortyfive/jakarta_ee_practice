package com.learning.example.repository;

import com.learning.example.model.Category;
import com.learning.example.model.Product;
import com.learning.example.util.ConnectionBaseData;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements Repository<Product> {

    private Connection getConnection() throws SQLException {
        return ConnectionBaseData.getConnection();
    }

    @Override
    public List<Product> list() {

        List<Product> products = new ArrayList<>();

        try(Connection connection = getConnection();
                Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT p.*, c.name as category FROM products as p " +
                    "inner join category as c  ON (p.category_id = c.id)")){

            while(resultSet.next()) {
                Product product = createProduct(resultSet);
                products.add(product);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return products;
    }



    @Override
    public Product byId(Long id) {
        Product product = null;

        try(Connection connection = getConnection();
                PreparedStatement statement = connection.
                prepareStatement("SELECT p.*, c.name as category FROM products as p " +
                        "inner join category as c  ON (p.category_id = c.id) WHERE p.id = ?")){
            statement.setLong(1, id);
            try(ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    product = createProduct(resultSet);

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }

    @Override
    public void save(Product product) {
        String sql = null;
        if (product.getId() != null && product.getId() > 0) {
            sql = "UPDATE products SET name=?, price=?, category_id=? WHERE id=? ";
        } else {
            sql = "INSERT INTO products (name, price, category_id, date_register) VALUES (?,?,?,?)";
        }
        try(Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setString(1, product.getName());
            statement.setLong(2, product.getPrice());
            statement.setLong(3, product.getCategory().getId());

            if (product.getId() != null && product.getId() > 0) {
                statement.setLong(4, product.getId());
            } else {
                statement.setDate(4, new Date(product.getDateRegister().getTime()));
            }

            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Long id) {
        try(Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement("DELETE FROM products WHERE id =?")){
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    private static Product createProduct(ResultSet resultSet) throws SQLException {
        Product product = new Product();
        product.setId(resultSet.getLong("id"));
        product.setName(resultSet.getString("name"));
        product.setPrice(resultSet.getInt("price"));
        product.setDateRegister(resultSet.getDate("date_register"));
        Category category = new Category();
        category.setId(resultSet.getLong("category_id"));
        category.setName(resultSet.getString("category"));
        product.setCategory(category);
        return product;
    }
}
