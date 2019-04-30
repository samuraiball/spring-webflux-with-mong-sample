package com.demo.reactive.controller;

import com.demo.reactive.model.document.Employee;
import com.demo.reactive.model.repository.EmployeeCrudRepository;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/employees")
public class EmployeesReactiveController {

    private final EmployeeCrudRepository repository;

    EmployeesReactiveController(EmployeeCrudRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    private Mono<Employee> getEmployeeById(
            @PathVariable String id
    ) {
        return repository.findFirstById(id);
    }

    @GetMapping
    private Flux<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @PutMapping("/update")
    private Mono<Employee> updateEmployee(
            @RequestBody Employee employee
    ) {
        //FIXME: update
        return Mono.just(employee);
    }

}
