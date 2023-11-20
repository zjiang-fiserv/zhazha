package com.zhazha.zha.repository;

import com.zhazha.zha.model.OrderDetail;
import com.zhazha.zha.model.CustomerAndTime;
import com.zhazha.zha.model.EmployeeByWeek;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;
import java.time.LocalDateTime;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends R2dbcRepository<OrderDetail, Integer> {
    Mono<OrderDetail> findById(int id);

    Mono<OrderDetail> findByCustomerOrderId(int customerOrderId);

    @Query("SELECT CUSTOMER.CUSTOMER_NAME, CUSTOMER.CUSTOMER_NUMBER, CUSTOMER_ORDER.DATE_TIME, FROM ORDER_DETAIL INNER JOIN CUSTOMER_ORDER ON ORDER_DETAIL.CUSTOMER_ORDER_ID = CUSTOMER_ORDER.ID INNER JOIN CUSTOMER ON CUSTOMER_ORDER.CUSTOMER_NUMBER = CUSTOMER.CUSTOMER_NUMBER WHERE ORDER_DETAIL.ID = :orderDetailID")
    Mono<CustomerAndTime> findCustomerAndTime(
        @Param("orderDetailID") int orderDetailID
    );

    @Query("SELECT CUSTOMER_ORDER.employee_id, CUSTOMER_ORDER.customer_number, CUSTOMER_ORDER.date_time, ORDER_DETAIL.total, ORDER_DETAIL.discount FROM ORDER_DETAIL INNER JOIN CUSTOMER_ORDER ON ORDER_DETAIL.customer_order_id=CUSTOMER_ORDER.id WHERE CUSTOMER_ORDER.employee_id=:employeeID and WEEK(CUSTOMER_ORDER.date_time)=WEEK(CURDATE())")
    Flux<EmployeeByWeek> findEmployeeByWeek(
        @Param("employeeID") int employeeID
    );
    



}
