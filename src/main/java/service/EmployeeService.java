package service;

import myExceptions.EmployeeAlreadyAddedException;
import myExceptions.EmployeeNotFoundException;
import myExceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;
import employee.Employee;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements EmployeeInterface{
    static final int EMPLOYEES_MAX = 10;
    private final List<Employee> employees;
    public EmployeeService() {
        this.employees = new ArrayList<>();
    }
    @Override
    public Employee addEmployee(String firstName, String lastName) {
            Employee employee = new Employee(firstName, lastName);
            if (employees.contains(employee)){
             throw new EmployeeAlreadyAddedException();
            }
            if (employees.size() < EMPLOYEES_MAX) {
            employees.add(employee);
            return employee;
            } else {
            throw new EmployeeStorageIsFullException();
        }
    }
    @Override
    public Employee delEmployee(String firstName, String lastName) {
            Employee employee = new Employee(firstName, lastName);
            if (employees.contains(employee)){
                employees.remove(employee);
                return employee;
            }
            throw new EmployeeNotFoundException();
    }
    @Override
    public Employee findEmployee(String firstName, String lastName){
            Employee employee = new Employee(firstName, lastName);
            if (employees.contains(employee)){
                return employee;
            }
            throw new EmployeeNotFoundException();
    }
    @Override
    public String allEmployees() {
        return "" + employees;
    }

}
