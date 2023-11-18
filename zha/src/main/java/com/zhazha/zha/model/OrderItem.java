package com.zhazha.zha.model;

import org.springframework.data.annotation.Id;

public class OrderItem {
    @Id
    private int id;
    private int productId;
    private int customerOrderId;
    private int quantity;
    
    public OrderItem(int productId, int customerOrderId, int quantity) {
        this.productId = productId;
        this.customerOrderId = customerOrderId;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(int customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
}
