package com.demo.reactive.model.repository;


import com.demo.reactive.model.document.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeCrudRepositoryTest {

    @Autowired
    EmployeeCrudRepository employeeCrudRepository;

    @Test
    public void 正常_登録と検索() {

        employeeCrudRepository.save(new Employee(null, "heno")).block();
        Flux<Employee> employeeFlux = employeeCrudRepository.findAllByName("heno");

        StepVerifier
                .create(employeeFlux)
                .assertNext(employee -> {
                    assertThat(employee.getId()).isNotNull();
                    assertThat(employee.getName()).isEqualTo("heno");
                })
                .expectComplete()
                .verify();
    }
}