package com.example.EmployeeBook.service;

import com.example.EmployeeBook.employee.Employee;
import com.example.EmployeeBook.myExceptions.EmployeeAlreadyAddedException;
import com.example.EmployeeBook.myExceptions.EmployeeNotFoundException;
import com.example.EmployeeBook.myExceptions.EmployeeStorageIsFullException;
import com.example.EmployeeBook.myInterface.EmployeeInterface;
import org.apache.commons.lang3.StringUtils;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService implements EmployeeInterface {
    static final int EMPLOYEES_MAX = 10;
    private final Map<String, Employee> employees;

    public EmployeeService() {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, int dept, double salary) throws BadRequestException {
        if (!StringUtils.isAlpha(firstName) || !StringUtils.isAlpha(lastName)) {
            throw new BadRequestException();
        }
        String capFirstName = StringUtils.capitalize(firstName);
        String capLastName = StringUtils.capitalize(lastName);
        Employee employee = new Employee(capFirstName,capLastName, dept, salary);
        if (employees.containsKey(capFirstName + capLastName)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() < EMPLOYEES_MAX) {
            employees.put(capFirstName + capLastName, employee);
            return employee;
        } else {
            throw new EmployeeStorageIsFullException();
        }
    }

    @Override
    public Employee delEmployee(String firstName, String lastName, int dept, double salary) {
        Employee employee = new Employee(firstName, lastName, dept, salary);
        if (employees.containsKey(firstName + lastName)) {
            employees.remove(employee.getFirstName() + employee.getLastName());
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee findEmployee(String firstName, String lastName, int dept, double salary) {
        Employee employee = new Employee(firstName, lastName, dept, salary);
        if (employees.containsKey(firstName + lastName)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public List<Employee> allEmployees() {
        return new ArrayList<>(employees.values());
    }




}
