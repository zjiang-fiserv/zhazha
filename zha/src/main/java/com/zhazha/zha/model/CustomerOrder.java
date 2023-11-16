package com.zhazha.zha.model;

import org.springframework.data.annotation.Id;
import java.time.LocalDateTime;

public class CustomerOrder {
    @Id
    private int id;
    private int employeeId;
    private String customerNumber;
    private LocalDateTime dateTime;

    public CustomerOrder() {
    }

    public CustomerOrder(int employeeId, String customerNumber) {
        this.employeeId = employeeId;
        this.customerNumber = customerNumber;
        this.dateTime = LocalDateTime.now();
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerId(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int Id) {
        this.id = Id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

}
