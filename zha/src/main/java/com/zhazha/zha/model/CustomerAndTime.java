package com.zhazha.zha.model;

import org.springframework.data.annotation.Id;
import java.time.LocalDateTime;

public class CustomerAndTime {
    public LocalDateTime dateTime;
    public String customerNumber;
    public String customerName;
   
    public CustomerAndTime() {
    }

    public CustomerAndTime(String customerName, String customerNumber, LocalDateTime dateTime){
        this.customerName=customerName;
        this.customerNumber=customerNumber;
        this.dateTime=dateTime;
    }
}
