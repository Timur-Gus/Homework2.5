package com.example.EmployeeBook;

import org.springframework.web.bind.annotation.*;
import service.EmployeeService;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private EmployeeService employeeService = new EmployeeService();
    @GetMapping(path = "/all")
    public String employee() {
        return employeeService.allEmployees();
    }

    @GetMapping(path = "/add")
    public String addEmployee(@RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName) {
        return employeeService.addEmployee(firstName, lastName) + "";
    }
    @GetMapping(path = "/remove")
    public String removeEmployee(@RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName) {
        return employeeService.delEmployee(firstName, lastName) + "";
    }
    @GetMapping(path = "/find")
    public String findEmployee(@RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName) {
        return employeeService.findEmployee(firstName, lastName) + "";
    }
}
