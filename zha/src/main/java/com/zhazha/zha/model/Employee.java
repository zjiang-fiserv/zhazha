package com.zhazha.zha.model;

import org.springframework.data.annotation.Id;

public class Employee {
    @Id
    private int employeeId;
    private String employeeName;
    private int pin;
    private String employeeRole;
    
    public Employee(int employeeId, String employeeName, int pin, String employeeRole) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.pin = pin;
        this.employeeRole = employeeRole;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getemployeeName() {
        return employeeName;
    }

    public void setemployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getemployeeRole() {
        return employeeRole;
    }

    public void setemployeeRole(String employeeRole) {
        this.employeeRole = employeeRole;
    }

    
}
