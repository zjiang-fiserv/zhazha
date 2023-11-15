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
import com.zhazha.zha.model.Product;
import com.zhazha.zha.service.ProductService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/products")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Product> getAllProducts(@RequestParam(required = false) String name) {
        if (name == null)
            return productService.findAll();
        else
            return productService.findByProductName(name);
    }

    @GetMapping("/products/{number}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Product> getId(@PathVariable("number") int id) {
        return productService.findById(id);
    }

    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Product> createProduct(@RequestBody Product product) {
        return productService.save(new Product(product.getId(), product.getProductName(),
                product.getProductDescription(), product.getPrice()));
    }

    @PutMapping("/products/{number}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Product> updateProduct(@PathVariable("number") int number, @RequestBody Product product) {
        return productService.update(number, product);
    }

    @DeleteMapping("/products/{number}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteProduct(@PathVariable("number") int number) {
        return productService.deleteByNumber(number);
    }

}

