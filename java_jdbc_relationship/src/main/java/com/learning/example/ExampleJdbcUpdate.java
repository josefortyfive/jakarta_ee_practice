package com.learning.example;


import com.learning.example.model.Category;
import com.learning.example.model.Product;
import com.learning.example.repository.ProductRepositoryImpl;
import com.learning.example.repository.Repository;
import com.learning.example.util.ConnectionBaseData;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class ExampleJdbcUpdate {

    public static void main(String[] args){

        try (Connection connection = ConnectionBaseData.getInstance()){
            Repository<Product> repository = new ProductRepositoryImpl();
            System.out.println("================= List =================");
            repository.list().forEach(System.out::println);

            System.out.println("================= get by id =================");
            System.out.println(repository.byId(1L));

            System.out.println("================= edit ExampleJdbcUpdateproduct  =================");
            Product product = new Product();
            product.setId(5L);
            product.setName("Football ball");
            product.setPrice(700);
            Category category = new Category();
            category.setId(2L);
            product.setCategory(category);
            repository.save(product);
            System.out.println("Product edit successfully");
            repository.list().forEach(System.out::println);

        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
