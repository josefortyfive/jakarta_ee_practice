package com.learning.example.repository;

import com.learning.example.model.Product;
import com.learning.example.util.ConnectionBaseData;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements Repository<Product> {

    private Connection getConnection() throws SQLException {
        return ConnectionBaseData.getInstance();
    }

    @Override
    public List<Product> list() {

        List<Product> products = new ArrayList<>();

        try(Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM products")){

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

        try(PreparedStatement statement = getConnection().
                prepareStatement("SELECT * FROM products WHERE id = ?")){
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
            sql = "UPDATE products SET name=?, price=? WHERE id=? ";
        } else {
            sql = "INSERT INTO products (name, price, date_register) VALUES (?,?,?)";
        }
        try(PreparedStatement statement = getConnection().prepareStatement(sql)){
            statement.setString(1, product.getName());
            statement.setInt(2, product.getPrice());

            if (product.getId() != null && product.getId() > 0) {
                statement.setLong(3, product.getId());
            } else {
                statement.setDate(3, new Date(product.getDateRegister().getTime()));
            }

            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Long id) {
        try(PreparedStatement statement = getConnection().prepareStatement("DELETE FROM products WHERE id =?")){
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
        return product;
    }
}
