package service;

import myExceptions.EmployeeAlreadyAddedException;
import myExceptions.EmployeeNotFoundException;
import myExceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;
import employee.Employee;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    List<Employee> employees = new ArrayList<>();
    static final int EMPLOYEES_MAX = 10;
    public void addEmployee(String firstName, String lastName) {
            for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)){
             throw new EmployeeAlreadyAddedException();
            }}
            if (employees.size() < EMPLOYEES_MAX) {
            Employee employee = new Employee(firstName, lastName);
            employees.add(employee);
            } else {
            throw new EmployeeStorageIsFullException();
        }
    }
    public void delEmployee(String firstName, String lastName) {
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)){
                employees.remove(employee);
                return;
            }
        }
        throw new EmployeeNotFoundException();
    }
    public Employee findEmployee(String firstName, String lastName){
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)){
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }

}
