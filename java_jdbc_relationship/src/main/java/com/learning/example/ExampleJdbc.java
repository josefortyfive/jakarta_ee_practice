package com.learning.example;


import com.learning.example.model.Category;
import com.learning.example.model.Product;
import com.learning.example.repository.ProductRepositoryImpl;
import com.learning.example.repository.Repository;
import com.learning.example.util.ConnectionBaseData;

import java.sql.Connection;
import java.util.Date;
import java.sql.SQLException;

public class ExampleJdbc {

    public static void main(String[] args){

        try (Connection connection = ConnectionBaseData.getInstance()){
            Repository<Product> repository = new ProductRepositoryImpl();
            System.out.println("================= List =================");
            repository.list().forEach(System.out::println);

            System.out.println("================= get by id =================");
            System.out.println(repository.byId(1L));

            System.out.println("================= insert new product  =================");
            Product product = new Product();
            product.setName("Basketball Ball");
            product.setPrice(500);
            product.setDateRegister(new Date());
            Category category = new Category();
            category.setId(1L);
            product.setCategory(category);
            repository.save(product);
            System.out.println("Product saved successfully");
            repository.list().forEach(System.out::println);

        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
