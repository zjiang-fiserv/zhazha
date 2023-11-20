package com.zhazha.zha.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhazha.zha.model.OrderDetail;
import com.zhazha.zha.repository.OrderDetailRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderDetailService {
    @Autowired
    OrderDetailRepository orderDetailRepository;

    public Flux<OrderDetail> findAll() {
        return orderDetailRepository.findAll();
    }

    public Mono<OrderDetail> findById(int id) {
        return orderDetailRepository.findById(id);
    }

    public Mono<OrderDetail> findByCustomerOrderId(int customerOrderId) {
        return orderDetailRepository.findByCustomerOrderId(customerOrderId);
    }

    public Mono<OrderDetail> save(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    public Mono<OrderDetail> update(int id, OrderDetail orderDetail) {
        return orderDetailRepository.findById(id).map(Optional::of).defaultIfEmpty(Optional.empty())
                .flatMap(optionalOrderDetail -> {
                    if (optionalOrderDetail.isPresent()) {
                        orderDetail.setId(id);
                        return orderDetailRepository.save(orderDetail);
                    }
                    return Mono.empty();
                });
    }

    public Mono<Void> deleteById(int id) {
        return orderDetailRepository.deleteById(id);
    }
}
