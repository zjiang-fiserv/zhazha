package com.zhazha.zha.model;

import org.springframework.data.annotation.Id;

public class CustomerOrder {
    @Id
    private int customerOrderId;
    private int employeeId;
    private int customerId;
    private String dateTime;

    public CustomerOrder(int employeeId, int customerId, int customerOrderId, String dateTime) {
        this.employeeId = employeeId;
        this.customerId = customerId;
        this.customerOrderId = customerOrderId;
        this.dateTime = dateTime;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getcustomerOrderId() {
        return customerOrderId;
    }

    public void setcustomerOrderId(int customerOrderId) {
        this.customerOrderId = customerOrderId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    
}
