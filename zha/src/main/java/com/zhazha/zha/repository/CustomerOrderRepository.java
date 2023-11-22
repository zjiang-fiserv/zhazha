package com.zhazha.zha.repository;

import com.zhazha.zha.model.CustomerOrder;
import com.zhazha.zha.model.OrdersByZipAndWeek;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerOrderRepository extends R2dbcRepository<CustomerOrder, Integer> {
    Mono<CustomerOrder> findById(int id);

    Mono<CustomerOrder> findByCustomerNumber(String customerNumber);

    Mono<CustomerOrder> findByEmployeeId(int employeeId);

    @Query("SELECT co.id, c.customer_number, c.customer_name, " + 
    "c.customer_address, c.zip, co.employee_id, co.date_time " + 
    "FROM CUSTOMER_ORDER AS co " + 
    "INNER JOIN CUSTOMER AS c ON co.customer_number = c.customer_number " + 
    "WHERE c.zip = :zip AND co.date_time >= DATEADD('DAY', -7, CURRENT_DATE)")
    Mono<OrdersByZipAndWeek> findOrdersByZipAndWeek (@Param("zip") String zip);
}
