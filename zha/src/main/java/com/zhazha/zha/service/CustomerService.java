package com.zhazha.zha.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhazha.zha.model.Customer;
import com.zhazha.zha.repository.CustomerRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public Flux<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Mono<Customer> findByCustomerNumber(int number) {
        return customerRepository.findById(number);
    }

    public Flux<Customer> findByCustomerName(String name) {
        return customerRepository.findByCustomerName(name);
    }

    public Flux<Customer> findByCustomerAddress(String address) {
        return customerRepository.findByCustomerAddress(address);
    }

    public Flux<Customer> findByZip(int zip) {
        return customerRepository.findByZip(zip);
    }

    public Mono<Customer> save(Customer customer) {
        return customerRepository.save(customer);
    }

    public Mono<Customer> update(int number, Customer customer) {
        return customerRepository.findById(number).map(Optional::of).defaultIfEmpty(Optional.empty())
                .flatMap(optionalCustomer -> {
                    if (optionalCustomer.isPresent()) {
                        customer.setCustomerNumber(number);
                        return customerRepository.save(customer);
                    }
                    return Mono.empty();
                });
    }

    public Mono<Void> deleteByNumber(int number) {
        return customerRepository.deleteById(number);
    }
}
