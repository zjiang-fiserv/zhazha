package com.zhazha.zha.model;

import org.springframework.data.annotation.Id;
import java.time.LocalDateTime;

public class CustomerOrder {
    @Id
    private int id;
    private int employeeId;
    private int customerNumber;
    private LocalDateTime dateTime;

    public CustomerOrder() {
    }

    public CustomerOrder(int employeeId, int customerNumber) {
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

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerId(int customerNumber) {
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
