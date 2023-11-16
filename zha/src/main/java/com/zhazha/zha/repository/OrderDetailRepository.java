package com.zhazha.zha.repository;

import com.zhazha.zha.model.OrderDetail;
import reactor.core.publisher.Mono;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends R2dbcRepository<OrderDetail, Integer> {
    Mono<OrderDetail> findById(int id);

    Mono<OrderDetail> findByCustomerOrderId(int customerOrderId);
}
