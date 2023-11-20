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
import com.zhazha.zha.model.OrderDetail;
import com.zhazha.zha.service.OrderDetailService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class OrderDetailController {
    @Autowired
    OrderDetailService orderDetailService;

    @GetMapping("/order_details")
    @ResponseStatus(HttpStatus.OK)
    public Flux<OrderDetail> getAllOrderDetails() {
        return orderDetailService.findAll();
    }

    @GetMapping("/order_details/")
    @ResponseStatus(HttpStatus.OK)
    public Mono<OrderDetail> getOrderDetailByCustomerOrderId(
        @RequestParam(required = false) int customerOrderId) {
        return orderDetailService.findById(customerOrderId);
    }

    //arguably useless end point currently, will revise
    @GetMapping("/order_details/{orderDetailId}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<OrderDetail> getOrderDetailById(@PathVariable("orderDetailId") int orderDetailId) {
        return orderDetailService.findById(orderDetailId);
    }

    @PostMapping("/order_details")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<OrderDetail> createOrderDetail(@RequestBody OrderDetail orderDetail) {
        return orderDetailService.save(new OrderDetail(orderDetail.getCustomerOrderId(),
                orderDetail.getDiscount(),orderDetail.getTotal()));
        // concluded to have the front end calculate the total and pass as paramenter.
    }

    @PutMapping("/order_details/{orderDetailId}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<OrderDetail> updateOrderDetail(@PathVariable("orderDetailId") int orderDetailId,
            @RequestBody OrderDetail orderDetail) {
        return orderDetailService.update(orderDetailId,  orderDetail);
    }

    @DeleteMapping("/order_details/{orderDetailId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteOrderDetail(@PathVariable("orderDetailId") int orderDetailId) {
        return orderDetailService.deleteById(orderDetailId);
    }
}
