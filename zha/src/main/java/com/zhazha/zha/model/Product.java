package com.zhazha.zha.model;

import org.springframework.data.annotation.Id;

public class Product {
    @Id
    private int productId;
    private String productName;
    private String productDescription;
    private float price;
    
    public Product(int productId, String name, String description, float price) {
        this.productId = productId;
        this.productName = name;
        this.productDescription = description;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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
