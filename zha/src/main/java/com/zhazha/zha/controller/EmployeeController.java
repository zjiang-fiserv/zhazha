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
import com.zhazha.zha.model.Employee;
import com.zhazha.zha.service.EmployeeService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Employee> getAllEmployees(@RequestParam(required = false) String employmentStatus, String role) {
        if (employmentStatus != null)
            return employeeService.findByStatus(employmentStatus);
        else if (role != null)
            return employeeService.findByRole(role);
        else 
            return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Employee> getEmployeeById(@PathVariable("id") int id) {
        return employeeService.findByEmployeeId(id);
    }

    @PostMapping("/employees")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Employee> createEmployee(@RequestBody Employee employee) {
        return employeeService.save(new Employee(employee.getEmployeeName(), employee.getEmploymentStatus(),
                employee.getPin(), employee.getEmployeeRole()));
    }

    @PutMapping("/employees/{number}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Employee> updateEmployee(@PathVariable("number") int number,
            @RequestBody Employee employee) {
        return employeeService.update(number, employee);
    }

    @DeleteMapping("/employees/{number}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteEmployee(@PathVariable("number") int number) {
        return employeeService.deleteByID(number);
    }
}
