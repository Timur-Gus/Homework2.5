package service;

import employee.Employee;

public interface EmployeeInterface {
    Employee addEmployee(String firstName, String lastName);
    Employee delEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);
    String allEmployees();
}
