package com.example.EmployeeBook.myInterface;

import com.example.EmployeeBook.employee.Employee;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface EmployeeInterface {

    Employee addEmployee(String firstName, String lastName, int dept, double salary) throws BadRequestException;

    Employee delEmployee(String firstName, String lastName, int dept, double salary);

    Employee findEmployee(String firstName, String lastName, int dept, double salary);

    List<Employee> allEmployees();


}
