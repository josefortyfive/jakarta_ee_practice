package com.learning.example;


import com.learning.example.model.Category;
import com.learning.example.model.Product;
import com.learning.example.repository.ProductRepositoryImpl;
import com.learning.example.repository.Repository;
import java.util.Date;

public class ExampleJdbc {

    public static void main(String[] args){

        Repository<Product> repository = new ProductRepositoryImpl();
        System.out.println("================= List =================");
        repository.list().forEach(System.out::println);

        System.out.println("================= get by id =================");
        System.out.println(repository.byId(1L));

        System.out.println("================= insert new product  =================");
        Product product = new Product();
        product.setName("HP Omen");
        product.setPrice(3500);
        product.setDateRegister(new Date());
        Category category = new Category();
        category.setId(3L);
        product.setCategory(category);
        repository.save(product);
        System.out.println("Product saved successfully");
        repository.list().forEach(System.out::println);

    }
}
