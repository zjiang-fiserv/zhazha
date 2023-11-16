package com.zhazha.zha.model;

import org.springframework.data.annotation.Id;

public class OrderItem {
    @Id
    private int id;
    private int productId;
    private int CustomerOrderId;
    private int quantity;
    
    public OrderItem(int productId, int customerOrderId, int quantity) {
        this.productId = productId;
        CustomerOrderId = customerOrderId;
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
        return CustomerOrderId;
    }

    public void setCustomerOrderId(int customerOrderId) {
        CustomerOrderId = customerOrderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
}
