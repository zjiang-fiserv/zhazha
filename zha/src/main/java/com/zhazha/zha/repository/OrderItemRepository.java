package com.zhazha.zha.repository;

import com.zhazha.zha.model.OrderItem;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends R2dbcRepository<OrderItem, Integer> {

    Flux<OrderItem> findByCustomerOrderId(int customerOrderId);
    
}