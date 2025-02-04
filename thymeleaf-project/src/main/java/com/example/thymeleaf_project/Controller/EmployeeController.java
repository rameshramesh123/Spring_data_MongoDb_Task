package com.example.thymeleaf_project.Controller;

import com.example.thymeleaf_project.Model.Employee;
import com.example.thymeleaf_project.Repository.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
 private EmployeeRepository employeeRepository;

    // Show form
    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "index";
    }

    // Save employee
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/employees/all";  // Redirect to all employees list
    }

     //Display all employees
    @GetMapping("/all")
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeRepository.findAll());
        return "employees";
    }

    @GetMapping("/view/{id}")
    public String viewEmployee(@PathVariable String id, Model model) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        model.addAttribute("employee", employee);
        return "employee-details";
    }

}

