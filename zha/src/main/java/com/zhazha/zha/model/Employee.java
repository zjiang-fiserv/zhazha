package com.zhazha.zha.model;

import org.springframework.data.annotation.Id;

public class Employee {
    @Id
    private int employeeId;
    private String name;
    private int pin;
    private String role;
    
    public Employee(int employeeId, String name, int pin, String role) {
        this.employeeId = employeeId;
        this.name = name;
        this.pin = pin;
        this.role = role;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    
}
