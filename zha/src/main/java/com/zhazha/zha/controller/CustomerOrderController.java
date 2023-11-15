package com.zhazha.zha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.zhazha.zha.model.CustomerOrder;
import com.zhazha.zha.service.CustomerOrderService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class CustomerOrderController {
    @Autowired
    CustomerOrderService customerOrderService;

    @GetMapping("/customer_orders")
    @ResponseStatus(HttpStatus.OK)
    public Flux<CustomerOrder> getAllCustomerOrders(@RequestParam(required = false) int customerId) {
        return customerOrderService.findByCustomerId(customerId);
    }

    @GetMapping("/customer_orders/{customerOrderId}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<CustomerOrder> getOrderByOrderId(@PathVariable("customerOrderId") int customerOrderId) {
        return customerOrderService.findByCustomerOrderId(customerOrderId);
    }

    @PostMapping("/customer_orders")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<CustomerOrder> createCustomerOrder(@RequestBody CustomerOrder customerOrder) {
        return customerOrderService.save(new CustomerOrder(customerOrder.getEmployeeId(), 
                customerOrder.getCustomerNumber(), customerOrder.getcustomerOrderId(), 
                customerOrder.getDateTime()));
    }

    @PutMapping("/customer_orders/{customerOrderId}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<CustomerOrder> updateCustomerOrder(@PathVariable("customerOrderId") int customerOrderId, 
        @RequestBody CustomerOrder customerOrder) {
        return customerOrderService.update(customerOrderId, customerOrder);
    }

    @DeleteMapping("/customer_orders/{customerOrderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteCustomer(@PathVariable("customerOrderId") int customerOrderId) {
        return customerOrderService.deleteByCustomerOrderId(customerOrderId);
    }
}