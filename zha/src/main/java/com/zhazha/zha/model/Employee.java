package com.zhazha.zha.model;

import org.springframework.data.annotation.Id;

public class Employee {
    @Id
    private int id;
    private String employeeName;
    private String employmentStatus;
    private int pin;
    private String employeeRole;
    
    public Employee(){

    }

    public Employee(String employeeName, String employmentStatus, int pin, String employeeRole) {
        this.employeeName = employeeName;
        this.employmentStatus = employmentStatus;
        this.pin = pin;
        this.employeeRole = employeeRole;
    }

    public int getEmployeeId() {
        return this.id;
    }

    public void setId(int employeeId) {
        this.id = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(String employeeRole) {
        this.employeeRole = employeeRole;
    }

    public String getEmploymentStatus(){
        return employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus){
        this.employmentStatus = employmentStatus;
    }

    
}
