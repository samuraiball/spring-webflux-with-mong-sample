package com.demo.reactive.model.repository;

import com.demo.reactive.model.document.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface EmployeeCrudRepository extends ReactiveCrudRepository<Employee, String> {
    Flux<Employee> findAll();
    Flux<Employee> findAllByName(String name);
    Mono<Employee> findFirstById(String id);
}
