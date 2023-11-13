package com.zhazha.zha.repository;

import com.zhazha.zha.model.Employee;

import reactor.core.publisher.Flux;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends R2dbcRepository<Employee, Integer>{
    Flux<Employee> findByEmployeeID(int number);

    Flux<Employee> findByEmployeeName(String name);

    Flux<Employee> findByEmploymentStatus(String status);

    Flux<Employee> findByEmployeeRole(String role);
}
