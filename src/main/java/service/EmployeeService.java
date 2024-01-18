package service;

import employee.Employee;
import myExceptions.EmployeeAlreadyAddedException;
import myExceptions.EmployeeNotFoundException;
import myExceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService implements EmployeeInterface{
    static final int EMPLOYEES_MAX = 10;
    private final Map<String,Employee> employees;
    public EmployeeService() {
        this.employees = new HashMap<>();
    }
    @Override
    public Employee addEmployee(String firstName, String lastName) {
            Employee employee = new Employee(firstName, lastName);
            if (employees.containsKey(firstName + lastName)){
             throw new EmployeeAlreadyAddedException();
            }
            if (employees.size() < EMPLOYEES_MAX) {
                employees.put(firstName + lastName, employee);
            return employee;
            } else {
            throw new EmployeeStorageIsFullException();
        }
    }
    @Override
    public Employee delEmployee(String firstName, String lastName) {
            Employee employee = new Employee(firstName, lastName);
            if (employees.containsKey(firstName + lastName)){
                employees.remove(employee.getFirstName() + employee.getLastName());
                return employee;
            }
            throw new EmployeeNotFoundException();
    }
    @Override
    public Employee findEmployee(String firstName, String lastName){
            Employee employee = new Employee(firstName, lastName);
            if (employees.containsKey(firstName + lastName)){
                return employee;
            }
            throw new EmployeeNotFoundException();
    }
    @Override
    public String allEmployees() {
        return employees.toString();
    }

}
