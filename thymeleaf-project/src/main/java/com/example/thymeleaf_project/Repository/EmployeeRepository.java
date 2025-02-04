package com.example.thymeleaf_project.Repository;

import com.example.thymeleaf_project.Model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
}