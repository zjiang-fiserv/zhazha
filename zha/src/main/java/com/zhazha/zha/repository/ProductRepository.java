package com.zhazha.zha.repository;

import com.zhazha.zha.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends R2dbcRepository<Product, Integer>{
    Mono<Product> findById(int id);

    Flux<Product> findByProductName(String name);

    Flux<Product> findByProductDescription(String des);
}

