package com.example.EmployeeBook.controller;

import com.example.EmployeeBook.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/department")
public class DepartmentController {

    public final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping(path = "/max-salary")
    public String EmployeMaxSalaryWithDepartment(@RequestParam("departmentID") int dept){
        return departmentService.EmployeMaxSalaryWithDepartment(dept).toString();
    }
    @GetMapping(path = "/min-salary")
    public String EmployeMinSalaryWithDepartment(@RequestParam("departmentID") int dept){
        return departmentService.EmployeMinSalaryWithDepartment(dept).toString();
    }
    @GetMapping(path = "/all", params = "departmentID")
    public String allEmployeesByDepartment(@RequestParam("departmentID") int dept){
        return departmentService.allEmployeesByDepartment(dept).toString();
    }
    @GetMapping(path = "/all")
    public String allEmployeesGruopOfDepartment(){
        return departmentService.allEmployeesGruopOfDepartment().toString();
    }
}
