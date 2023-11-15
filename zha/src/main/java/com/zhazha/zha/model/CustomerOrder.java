package com.zhazha.zha.model;

import org.springframework.data.annotation.Id;

public class CustomerOrder {
    @Id
    private int customerOrderId;
    private int employeeId;
    private int customerNumber;
    private String dateTime;

    public CustomerOrder(int employeeId, int customerNumber, int customerOrderId, String dateTime) {
        this.employeeId = employeeId;
        this.customerNumber = customerNumber;
        this.customerOrderId = customerOrderId;
        this.dateTime = dateTime;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerId(int customerNumber) {
        this.customerNumber = customerNumber;
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
