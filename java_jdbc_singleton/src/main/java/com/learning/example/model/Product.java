package com.learning.example.model;

import java.util.Date;

public class Product {

    private Long id;
    private String name;
    private Integer price;
    private Date dateRegister;

    public Product(){

    }
    public Product(Long id, String name, Integer price, Date dateRegister) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.dateRegister = dateRegister;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(Date dateRegister) {
        this.dateRegister = dateRegister;
    }

    @Override
    public String toString() {
        return
                id +
                " | " + name  +
                " | " + price +
                " | " + dateRegister
                ;
    }
}
