package com.zhazha.zha.model;

import org.springframework.data.annotation.Id;
import java.time.LocalDateTime;

public class EmployeeByWeek {
    public int employeeId;
    public String customerNumber;
    public LocalDateTime dateTime;
    public int discount;
    public float total;
   
    public EmployeeByWeek() {
    }

    public EmployeeByWeek(int employeeId, String customerNumber, LocalDateTime dateTime, int discount, float total){
        this.employeeId=employeeId;
        this.customerNumber=customerNumber;
        this.dateTime=dateTime;
        this.discount=discount;
        this.total=total;
    }
}
