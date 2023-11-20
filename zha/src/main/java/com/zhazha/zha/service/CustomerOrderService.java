package com.zhazha.zha.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public Mono<CustomerOrder> findById(int id) {
        return customerOrderRepository.findById(id);
    }

    public Mono<CustomerOrder> findByCustomerNumber(String customerNumber) {
        return customerOrderRepository.findByCustomerNumber(customerNumber);
    }
    
    public Mono<CustomerOrder> findByEmployeeId(int employeeId) {
        return customerOrderRepository.findByEmployeeId(employeeId);
    }

    public Mono<CustomerOrder> save(CustomerOrder customerOrder) {
        return customerOrderRepository.save(customerOrder);
    }

    public Mono<CustomerOrder> update(int id, CustomerOrder customerOrder) {
        return customerOrderRepository.findById(id).map(Optional::of).defaultIfEmpty(Optional.empty())
                .flatMap(optionalCustomerOrder -> {
                    if (optionalCustomerOrder.isPresent()) {
                        CustomerOrder updatedOrder = new CustomerOrder(
                            customerOrder.getEmployeeId(), 
                            customerOrder.getCustomerNumber());
                        updatedOrder.setId(id);
                        return customerOrderRepository.save(updatedOrder);
                    }
                    return Mono.empty();
                });
    }

    public Mono<Void> deleteById(int id) {
        return customerOrderRepository.deleteById(id);
    }
}
