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
import com.zhazha.zha.model.OrderItem;
import com.zhazha.zha.service.OrderItemService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class CustomerOrderController {
    @Autowired
    CustomerOrderService customerOrderService;
    @Autowired
    OrderItemService orderItemService;

    @GetMapping("/customer_orders")
    @ResponseStatus(HttpStatus.OK)
    public Flux<CustomerOrder> getAllCustomerOrders() {
        return customerOrderService.findAll();
    }

    @GetMapping("/customer_orders/")
    @ResponseStatus(HttpStatus.OK)
    public Flux<CustomerOrder> getOrderByCustomerNumber(@RequestParam(required = false) String customerNumber) {
        return customerOrderService.findByCustomerNumber(customerNumber);
    }

    @GetMapping("/customer_orders/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<CustomerOrder> getCustomerOrderById(@PathVariable("id") int id) {
        return customerOrderService.findById(id);
    }

    @GetMapping("/customer_orders/{CUSTOMER_ORDER_ID}/orders")
    @ResponseStatus(HttpStatus.OK)
    public Flux<OrderItem> getByCustomerOrderId(@PathVariable("CUSTOMER_ORDER_ID") int customerOrderId) {
        return orderItemService.findByCustomerOrderId(customerOrderId);
    }

    @PostMapping("/customer_orders")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<CustomerOrder> createCustomerOrder(@RequestBody CustomerOrder customerOrder) {
        return customerOrderService.save(new CustomerOrder(customerOrder.getEmployeeId(),
                customerOrder.getCustomerNumber()));
    }

    @PostMapping("/customer_orders/orders")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<OrderItem> createOrderItem(
        @RequestParam(required = true) int productId, int customerOrderId, int quantity) {
        return orderItemService.save(new OrderItem(
            customerOrderId,
            productId,
            quantity));
    }

    //Potentially update method for OrderItem

    @PutMapping("/customer_orders/{customerOrderId}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<CustomerOrder> updateCustomerOrder(@PathVariable("customerOrderId") int customerOrderId,
            @RequestBody CustomerOrder customerOrder) {
        return customerOrderService.update(customerOrderId, customerOrder);
    }

    @DeleteMapping("/customer_orders/{customerOrderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteCustomerOrder(@PathVariable("customerOrderId") int customerOrderId) {
        return customerOrderService.deleteById(customerOrderId);
    }
}
