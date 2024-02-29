package com.example.EmployeeBook.service;

import com.example.EmployeeBook.employee.Employee;
import com.example.EmployeeBook.myInterface.DepartmentInterface;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService implements DepartmentInterface {
    public final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @Override
    public Employee employeeMaxSalaryWithDepartment(int dept) {
        return employeeService.allEmployees().stream()
                .filter(d -> d.getDept() == dept)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();
    }
    @Override
    public Double employeeSumSalaryWithDepartment(int dept) {
        return employeeService.allEmployees().stream()
                .filter(e -> e.getDept() == dept)
                .mapToDouble(Employee::getSalary)
                .sum();
    }

    @Override
    public Employee employeeMinSalaryWithDepartment(int dept) {
        return employeeService.allEmployees().stream()
                .filter(d -> d.getDept() == dept)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();
    }

    @Override
    public List<Employee> allEmployeesByDepartment(int dept) {
        return employeeService.allEmployees().stream()
                .filter(d -> d.getDept() == dept)
                .collect(Collectors.toList());

    }
    @Override
    public Map<Integer, List<Employee>> allEmployeesGroupOfDepartment() {
        return employeeService.allEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDept));
    }
}
