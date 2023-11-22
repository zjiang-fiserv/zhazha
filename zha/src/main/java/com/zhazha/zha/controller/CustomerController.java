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
import com.zhazha.zha.model.Customer;
import com.zhazha.zha.service.CustomerService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Customer> getAllCustomers(
        @RequestParam(required = false) String customerNumber, String customerName, String zip) {
        if (customerNumber != null)
            return customerService.findByCustomerNumber(customerNumber);
        else if (customerName != null)
            return customerService.findByCustomerName(customerName);
        else if (zip != null)
            return customerService.findByZip(zip);
        else
            return customerService.findAll();
    }

    @GetMapping("/customer/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Customer> getCustomerByNumber(@PathVariable("id") String id) {
        return customerService.findByCustomerNumber((id));
    }

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Customer> createCustomer(@RequestBody Customer customer) {
        return customerService.save(new Customer(customer.getCustomerNumber(), customer.getCustomerAddress(),
<<<<<<< Updated upstream
                customer.getZip(), customer.getCustomerName()));
=======
                customer.getZip(), customer.getCustomerName()))
                .thenReturn(ResponseEntity.status(HttpStatus.CREATED).body("Customer created successfully"))
                .onErrorResume(DuplicateKeyException.class, e ->
                        Mono.just(ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT)
                                .body("Bad input: Duplicate customer number"))
                )
                .onErrorResume(Exception.class, e ->
                        Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .body("An error occurred"))
                );
>>>>>>> Stashed changes
    }

    @PutMapping("/customers/{number}")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Customer> updateCustomer(
        @PathVariable("number") String number, 
        @RequestBody Customer customer) {
        return customerService.update(number, customer);
    }

    @DeleteMapping("/customers/{number}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteCustomer(@PathVariable("number") String number) {
        return customerService.deleteByCustomerNumber(number);
    }

}
