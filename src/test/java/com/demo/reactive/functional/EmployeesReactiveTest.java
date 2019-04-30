package com.demo.reactive.functional;

import com.demo.reactive.controller.EmployeesReactiveController;
import com.demo.reactive.model.document.Employee;
import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeesReactiveTest {

    @Autowired
    EmployeesReactiveController controller;

    @Autowired
    MongoTemplate mongoTemplate;


    @Test
    public void 正常_Id検索() {
        Employee employee = new Employee("1", "heno");
        Employee createdEmployee = mongoTemplate.save(employee);


        WebTestClient client =
                WebTestClient.bindToController(controller).build();

        client.get()
                .uri("/employees/1")
                .exchange()
                .expectStatus().isOk()
                .expectBody(Employee.class).isEqualTo(createdEmployee);
    }

}
