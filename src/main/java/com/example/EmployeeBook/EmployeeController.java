package com.example.EmployeeBook;

import org.springframework.web.bind.annotation.RestController;
import service.EmployeeService;

@RestController
public class EmployeeController {
    EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}
