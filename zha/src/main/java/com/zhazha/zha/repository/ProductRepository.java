package com.zhazha.zha.repository;

import com.zhazha.zha.model.Customer;
import com.zhazha.zha.model.Product;
import reactor.core.publisher.Flux;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends R2dbcRepository<Product, Integer>{
    Flux<Product> findByProductId(int id);

    Flux<Product> findByName(String name);

    Flux<Product> findByDescription(String des);

    Flux<Product> findByPrice(float price);
}

