package com.zhazha.zha.model;

import org.springframework.data.annotation.Id;

public class OrderDetail {
    @Id
    private int id;
    private int customerOrderId;
    private int discount;
    private float total;

    public OrderDetail() {
    };

    public OrderDetail(int customerOrderId, int discount, float total) {
        this.customerOrderId = customerOrderId;
        this.discount = discount;
        this.total = total;
    }

    public int getID() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(int customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
        // calcTotal() would be called here
    }

    public int getDiscount() {
        return this.discount;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getTotal() {
        return this.total;
    }

}
