package com.zhazha.zha.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhazha.zha.model.Customer;
import com.zhazha.zha.model.CustomerOrder;
import com.zhazha.zha.repository.CustomerOrderRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerOrderService {
    @Autowired
    CustomerOrderRepository customerOrderRepository;

    public Flux<CustomerOrder> findAll() {
        return customerOrderRepository.findAll();
    }

    public Mono<CustomerOrder> findByCustomerOrderId(int id) {
        return customerOrderRepository.findById(id);
    }

    public Flux<CustomerOrder> findByCustomerId(int customerId) {
        return customerOrderRepository.findByCustomerId(customerId);
    }

    public Mono<CustomerOrder> save(CustomerOrder customerOrder) {
        return customerOrderRepository.save(customerOrder);
    }

    public Mono<CustomerOrder> update(int id, CustomerOrder customerOrder) {
        return customerOrderRepository.findById(id).map(Optional::of).defaultIfEmpty(Optional.empty())
                .flatMap(optionalCustomer -> {
                    if (optionalCustomer.isPresent()) {
                        customerOrder.setCustomerId(id);
                        return customerOrderRepository.save(customerOrder);
                    }
                    return Mono.empty();
                });
    }

    public Mono<Void> deleteByCustomerOrderId(int id) {
        return customerOrderRepository.deleteById(id);
    }
    // SELECT
    //     co.customerOrderId,
    //     co.employeeId,
    //     co.customerNumber,
    //     co.dateTime,
    // FROM
    //     CustomerOrder co
    // JOIN
    //     Customer c ON co.customerNumber = c.customerNumber
    // WHERE
    //     c.customerNumber = [desired_customer_number];
    //sqlquery for selecting customerorder with customer phone number
}
