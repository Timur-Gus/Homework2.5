package com.example.EmployeeBook.service;

import com.example.EmployeeBook.employee.Employee;
import com.example.EmployeeBook.myExceptions.EmployeeAlreadyAddedException;
import com.example.EmployeeBook.myExceptions.EmployeeNotFoundException;
import com.example.EmployeeBook.myExceptions.EmployeeStorageIsFullException;
import org.apache.coyote.BadRequestException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.example.EmployeeBook.constants.ConstantsEmployeesBookForTest.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeServiceTest {
    EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        employeeService = new EmployeeService();
    }

    @Test
    void addEmployee() throws BadRequestException {
        Employee actual = employeeService.addEmployee(FIRST_NAME1, LAST_NAME1, DEPARTMENT1, SALARY1);
        Employee expected = new Employee(FIRST_NAME1, LAST_NAME1, DEPARTMENT1, SALARY1);
        Assertions.assertEquals(actual, expected);
    }

    @Test
    void addEmployeeAlreadyAdded() throws BadRequestException {

        EmployeeAlreadyAddedException employeeAlreadyAddedException =
                assertThrows(EmployeeAlreadyAddedException.class, () -> {
                            Employee actual1 = employeeService.addEmployee(FIRST_NAME1, LAST_NAME1, DEPARTMENT1, SALARY1);
                            Employee actual2 = employeeService.addEmployee(FIRST_NAME1, LAST_NAME1, DEPARTMENT1, SALARY1);
                        }
                );

    }

    @Test
    void addEmployeeBadRequestFirstName() {
        Throwable badRequestException =
                assertThrows(BadRequestException.class, () -> {
                            Employee actual1 = employeeService.addEmployee(NAME_BAD_VALUE, LAST_NAME1, DEPARTMENT1, SALARY1);
                        }
                );
    }
    @Test
    void addEmployeeBadRequestLastName() {
        Throwable badRequestException =
                assertThrows(BadRequestException.class, () -> {
                            Employee actual1 = employeeService.addEmployee(FIRST_NAME1, NAME_BAD_VALUE, DEPARTMENT1, SALARY1);
                        }
                );
    }

    @Test
    void addEmployeeLowerCase() throws BadRequestException {
        Employee actual = employeeService.addEmployee(FIRST_NAME_LOWER_CASE, LAST_NAME_LOWER_CASE, DEPARTMENT1, SALARY1);
        Employee expected = new Employee(FIRST_NAME1, LAST_NAME1, DEPARTMENT1, SALARY1);
        Assertions.assertEquals(actual, expected);
    }

    @Test
    void addEmployeeStorageIsFull() throws BadRequestException {
        EmployeeStorageIsFullException employeeStorageIsFullException =
                assertThrows(EmployeeStorageIsFullException.class, () -> {
                    Employee employee1 = employeeService.addEmployee(FIRST_NAME1, LAST_NAME1, DEPARTMENT1, SALARY1);
                    Employee employee2 = employeeService.addEmployee(FIRST_NAME2, LAST_NAME2, DEPARTMENT2, SALARY2);
                    Employee employee3 = employeeService.addEmployee(FIRST_NAME3, LAST_NAME2, DEPARTMENT2, SALARY2);
                    Employee employee4 = employeeService.addEmployee(FIRST_NAME4, LAST_NAME2, DEPARTMENT3, SALARY2);
                    Employee employee5 = employeeService.addEmployee(FIRST_NAME5, LAST_NAME2, DEPARTMENT3, SALARY2);
                    Employee employee6 = employeeService.addEmployee(FIRST_NAME6, LAST_NAME2, DEPARTMENT4, SALARY1);
                    Employee employee7 = employeeService.addEmployee(FIRST_NAME7, LAST_NAME2, DEPARTMENT4, SALARY1);
                    Employee employee8 = employeeService.addEmployee(FIRST_NAME8, LAST_NAME2, DEPARTMENT4, SALARY1);
                    Employee employee9 = employeeService.addEmployee(FIRST_NAME9, LAST_NAME2, DEPARTMENT4, SALARY2);
                    Employee employee10 = employeeService.addEmployee(FIRST_NAME10, LAST_NAME2, DEPARTMENT2, SALARY1);
                    Employee employee11 = employeeService.addEmployee(FIRST_NAME11, LAST_NAME2, DEPARTMENT2, SALARY2);
                });

    }

    @Test
    void delEmployee() throws BadRequestException {
        Employee employeeAdd = employeeService.addEmployee(FIRST_NAME1, LAST_NAME1, DEPARTMENT1, SALARY1);
        Employee employeeDel = employeeService.delEmployee(FIRST_NAME1, LAST_NAME1, DEPARTMENT1, SALARY1);
        Assertions.assertEquals(employeeAdd, employeeDel);
    }

    @Test
    void delEmployeeNotFound() throws BadRequestException {
        EmployeeNotFoundException employeeNotFoundException =
                assertThrows(EmployeeNotFoundException.class, () -> {
                    Employee employeeDel = employeeService.delEmployee(FIRST_NAME1, LAST_NAME1, DEPARTMENT1, SALARY1);
                });
    }

    @Test
    void findEmployee() throws BadRequestException {
        Employee employeeAdd = employeeService.addEmployee(FIRST_NAME1, LAST_NAME1, DEPARTMENT1, SALARY1);
        Employee employeeFind = employeeService.findEmployee(FIRST_NAME1, LAST_NAME1, DEPARTMENT1, SALARY1);
        Assertions.assertEquals(employeeAdd, employeeFind);
    }

    @Test
    void findEmployeeNotFound() throws BadRequestException {
        EmployeeNotFoundException employeeNotFoundException =
                assertThrows(EmployeeNotFoundException.class, () -> {
                    Employee employeeDel = employeeService.findEmployee(FIRST_NAME1, LAST_NAME1, DEPARTMENT1, SALARY1);
                });
    }

    @Test
    void allEmployees() throws BadRequestException {
        Employee employee1 = employeeService.addEmployee(FIRST_NAME1, LAST_NAME1, DEPARTMENT1, SALARY1);
        Employee employee2 = employeeService.addEmployee(FIRST_NAME2, LAST_NAME2, DEPARTMENT2, SALARY2);
        Employee employee3 = employeeService.addEmployee(FIRST_NAME3, LAST_NAME2, DEPARTMENT1, SALARY2);
        Employee employee4 = employeeService.addEmployee(FIRST_NAME4, LAST_NAME2, DEPARTMENT2, SALARY1);
        Employee employee5 = employeeService.addEmployee(FIRST_NAME5, LAST_NAME2, DEPARTMENT3, SALARY2);
        List<Employee> actual = employeeService.allEmployees();
        assertTrue(EMPLOYEES.containsAll(actual));
    }
}