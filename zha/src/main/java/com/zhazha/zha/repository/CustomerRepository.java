package com.zhazha.zha.repository;

import com.zhazha.zha.model.Customer;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends R2dbcRepository<Customer, String>{ 
    Flux<Customer> findByCustomerNumber(String number);

    Flux<Customer> findByCustomerName(String name);

    Flux<Customer> findByCustomerAddress(String address);

    Flux<Customer> findByZip(String zip);

    Mono<Void> deleteByCustomerNumber(String number);
}
