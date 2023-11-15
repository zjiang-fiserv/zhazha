package com.zhazha.zha.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhazha.zha.model.Product;
import com.zhazha.zha.repository.ProductRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Flux<Product> findAll() {
        return productRepository.findAll();
    }

    public Mono<Product> findById(int id) {
        return productRepository.findById(id);
    }

    public Flux<Product> findByProductName(String name) {
        return productRepository.findByProductName(name);
    }

    public Flux<Product> findByProductDescription(String des) {
        return productRepository.findByProductDescription(des);
    }

    public Mono<Product> save(Product product) {
        return productRepository.save(product);
    }

    public Mono<Product> update(int id, Product product) {
        return productRepository.findById(id).map(Optional::of).defaultIfEmpty(Optional.empty())
                .flatMap(optionalProduct -> {
                    if (optionalProduct.isPresent()) {
                        product.setId(id);
                        return productRepository.save(product);
                    }
                    return Mono.empty();
                });
    }

    public Mono<Void> deleteByNumber(int id) {
        return productRepository.deleteById(id);
    }
}
