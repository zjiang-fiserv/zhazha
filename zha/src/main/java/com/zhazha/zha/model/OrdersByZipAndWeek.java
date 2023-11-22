package com.zhazha.zha.model;

import java.time.LocalDateTime;

public class OrdersByZipAndWeek {
    private int id;
    private String customerNumber;
    private String customerName;
    private String customerAddress;
    private String zip;
    private int employeeId;
    private LocalDateTime dateTime;

    public OrdersByZipAndWeek(){

    };
    

    public OrdersByZipAndWeek(int id, String customerNumber, String customerName, String customerAddress, String zip, int employeeId, LocalDateTime dateTime) {
        this.id = id;
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.zip = zip;
        this.employeeId = employeeId;
        this.dateTime = dateTime;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }


    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }


    public String getCustomerName() {
        return customerName;
    }


    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }


    public String getCustomerAddress() {
        return customerAddress;
    }


    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }


    public String getZip() {
        return zip;
    }


    public void setZip(String zip) {
        this.zip = zip;
    }


    public int getEmployeeId() {
        return employeeId;
    }


    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }


    public LocalDateTime getDateTime() {
        return dateTime;
    }


    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }


    public int getCustomerOrderId() {
        return id;
    }


    public void setCustomerOrderId(int id) {
        this.id = id;
    }

    
}
