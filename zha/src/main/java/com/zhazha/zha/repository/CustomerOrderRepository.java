package com.zhazha.zha.repository;

import com.zhazha.zha.model.CustomerOrder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerOrderRepository extends R2dbcRepository<CustomerOrder, Integer> {
    Mono<CustomerOrder> findById(int id);

    Flux<CustomerOrder> findByCustomerNumber(int customerNumber);
}
