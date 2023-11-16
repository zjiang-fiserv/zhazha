package com.zhazha.zha.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhazha.zha.model.OrderItem;
import com.zhazha.zha.repository.OrderItemRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderItemService {
    @Autowired
    OrderItemRepository orderItemRepository;

    // public Mono<OrderItem> findById(int id) {
    //     return orderItemRepository.findById(id);
    // }

    public Flux<OrderItem> findByCustomerOrderId(int customerOrderId) {
        return orderItemRepository.findByCustomerOrderId(customerOrderId);
    }

    public Mono<OrderItem> save(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    public Mono<OrderItem> update(int id, int quantity, OrderItem orderItem) {
        return orderItemRepository.findById(id).map(Optional::of).defaultIfEmpty(Optional.empty())
                .flatMap(optionalOrderItem -> {
                    if (optionalOrderItem.isPresent()) {
                        orderItem.setQuantity(quantity);
                        return orderItemRepository.save(orderItem);
                    }
                    return Mono.empty();
                });
    }

    public Mono<Void> deleteById(int id) {
        return orderItemRepository.deleteById(id);
    }
}

