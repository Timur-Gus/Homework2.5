package com.example.EmployeeBook.myInterface;

import com.example.EmployeeBook.employee.Employee;

import java.util.List;

public interface EmployeeInterface {

    Employee addEmployee(String firstName, String lastName, int dept, double salary);

    Employee delEmployee(String firstName, String lastName, int dept, double salary);

    Employee findEmployee(String firstName, String lastName, int dept, double salary);

    List<Employee> allEmployees();


}
