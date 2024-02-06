package com.example.EmployeeBook.controller;

import org.apache.coyote.BadRequestException;
import org.springframework.web.bind.annotation.*;
import com.example.EmployeeBook.service.EmployeeService;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    public final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping(path = "/all")
    public String employee() {
        return employeeService.allEmployees().toString();
    }

    @GetMapping(path = "/add")
    public String addEmployee(@RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName,
                              @RequestParam("departmentID") int dept,
                              @RequestParam("salary") double salary) throws BadRequestException {
        return employeeService.addEmployee(firstName, lastName, dept, salary) + "";
    }

    @GetMapping(path = "/remove")
    public String removeEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName,
                                 @RequestParam("departmentID") int dept,
                                 @RequestParam("salary") double salary) {
        return employeeService.delEmployee(firstName, lastName, dept, salary) + "";
    }

    @GetMapping(path = "/find")
    public String findEmployee(@RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName,
                               @RequestParam("departmentID") int dept,
                               @RequestParam("salary") double salary) {
        return employeeService.findEmployee(firstName, lastName, dept, salary) + "";
    }
}
