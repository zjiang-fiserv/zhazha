package com.zhazha.zha.model;

import org.springframework.data.annotation.Id;

public class OrderDetail {
    @Id
    private int orderDetailId;
    private int customerOrderId;
    private float discount;
    private float total;
    
    public OrderDetail(int orderDetailId, int customerOrderId, float discount) {
        this.orderDetailId = orderDetailId;
        this.customerOrderId = customerOrderId;
        this.discount = discount;
    }

    public int getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(int orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public int getCustomerOrderId() {
        return customerOrderId;
    }

    public void setCustomerOrderId(int customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    
}
