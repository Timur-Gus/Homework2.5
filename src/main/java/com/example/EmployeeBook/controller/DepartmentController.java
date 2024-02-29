package com.example.EmployeeBook.controller;

import com.example.EmployeeBook.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    public final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("{id}/employees")
    public String allEmployeesByDepartment(@PathVariable("id") int dept) {
        return departmentService.allEmployeesByDepartment(dept).toString();
    }

    @GetMapping("{id}/salary/sum")
    public String employeesSumSalaryOfDepartment(@PathVariable("id") int dept) {
        return departmentService.employeeSumSalaryWithDepartment(dept).toString();
    }
    @GetMapping("/{id}/salary/max")
    public String employeesMaxSalaryWithDepartment(@PathVariable("id") int dept) {
        return departmentService.employeeMaxSalaryWithDepartment(dept).toString();
    }

    @GetMapping("{id}/salary/min")
    public String employeesMinSalaryWithDepartment(@PathVariable("id") int dept) {
        return departmentService.employeeMinSalaryWithDepartment(dept).toString();
    }

    @GetMapping("/employees")
    public String allEmployeesGroupOfDepartment() {
        return departmentService.allEmployeesGroupOfDepartment().toString();
    }
}
