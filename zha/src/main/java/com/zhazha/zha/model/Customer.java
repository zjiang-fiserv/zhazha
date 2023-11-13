package com.zhazha.zha.model;

// @Entity
public class Customer {
    private int customerNumber;
    private String customerAddress;
    private int zip;
    private String customerName;

    // @ManyToOne
    private CustomerOrder customerOrder;


    public Customer() {

    }

    public Customer(int customerNumber, String customerAddress, int zip, String customerName) {
        this.customerNumber = customerNumber;
        this.customerAddress = customerAddress;
        this.zip = zip;
        this.customerName = customerName;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setcustomerName(String customerName) {
        this.customerName = customerName;
    }

    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }

    
}
