package com.zhazha.zha.model;

import org.springframework.data.annotation.Id;

public class Product {
    @Id
    private int id;
    private String productName;
    private String productDescription;
    private float price;

    public Product(){
        
    }
    
    public Product(int id, String name, String description, float price) {
        this.id = id;
        this.productName = name;
        this.productDescription = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setroductName(String name) {
        this.productName = name;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String description) {
        this.productDescription = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    
}
