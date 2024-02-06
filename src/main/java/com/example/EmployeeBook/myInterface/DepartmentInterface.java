package com.example.EmployeeBook.myInterface;

import com.example.EmployeeBook.employee.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentInterface {
    Employee EmployeMaxSalaryWithDepartment(int dept);

    Employee EmployeMinSalaryWithDepartment(int dept);

    List<Employee> allEmployeesByDepartment(int dept);

    Map<Integer,List<Employee>> allEmployeesGruopOfDepartment();
}
