package com.empapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.empapp.services.IDepartmentService;
import com.empapp.services.IProjectService;

@SpringBootApplication
public class SpringProductapp1Application implements CommandLineRunner {

    @Autowired
    private IDepartmentService departmentService;

    @Autowired
    private IProjectService projectService;

    public static void main(String[] args) {
        SpringApplication.run(SpringProductapp1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Your code that uses departmentService or projectService
        System.out.println("Spring Boot is running!");
    }
}
