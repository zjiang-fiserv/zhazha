package com.zhazha.zha.model;

import org.springframework.data.annotation.Id;

public class OrderDetail {
    @Id
    private int id;
    private int customerOrderId;
    private int discount;
    private float total;
    
    public OrderDetail(int customerOrderId, int discount) {
        this.customerOrderId = customerOrderId;
        this.discount = discount;
    }

    public int getID() {
        return id;
    }

    public int getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(int customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public void calcTotal() {
        // this.total = impelment getting all items on order from order item table
    }

    
}
