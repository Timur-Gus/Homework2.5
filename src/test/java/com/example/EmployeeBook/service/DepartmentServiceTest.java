package com.example.EmployeeBook.service;

import com.example.EmployeeBook.employee.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static com.example.EmployeeBook.constants.ConstantsEmployeesBookForTest.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {
    @Mock
    private EmployeeService employeeMock;
    @InjectMocks
    private DepartmentService out;

    @Test
    void employeeMaxSalaryWithDepartment() {
        when(employeeMock.allEmployees())
                .thenReturn(EMPLOYEES);
        assertEquals(EMPLOYEE1, out.employeeMaxSalaryWithDepartment(1));

    }

    @Test
    void employeeMaxSalaryDepartmentNoSuchElement() {
        when(employeeMock.allEmployees())
                .thenReturn(EMPLOYEES);
        assertThrows(NoSuchElementException.class, () ->
                out.employeeMaxSalaryWithDepartment(1000));
    }

    @Test
    void employeeMinSalaryWithDepartment() {
        when(employeeMock.allEmployees())
                .thenReturn(EMPLOYEES);
        assertEquals(EMPLOYEE2, out.employeeMinSalaryWithDepartment(2));
    }
    @Test
    void employeeMinSalaryDepartmentNoSuchElement() {
        when(employeeMock.allEmployees())
                .thenReturn(EMPLOYEES);
        assertThrows(NoSuchElementException.class, () ->
                out.employeeMinSalaryWithDepartment(1000));
    }

    @Test
    void employeeSumSalaryWithDepartment() {
        when(employeeMock.allEmployees())
                .thenReturn(EMPLOYEES);
        assertEquals(SALARY1 + SALARY2, out.employeeSumSalaryWithDepartment(1));
    }

    @Test
    void employeeSumSalaryDepartmentNoSuchElement() {
        when(employeeMock.allEmployees())
                .thenReturn(EMPLOYEES);
        assertEquals(0,out.employeeSumSalaryWithDepartment(1000));
    }

    @Test
    void allEmployeesByDepartment() {
        when(employeeMock.allEmployees())
                .thenReturn(EMPLOYEES);
        assertIterableEquals(EMPLOYEES_BY_DEPARTMENT, out.allEmployeesByDepartment(2));
    }
    @Test
    void  allEmployeesDepartmentNoSuchElement() {
        when(employeeMock.allEmployees())
                .thenReturn(EMPLOYEES);
        List<Employee> emptyList = new ArrayList<>();
        assertEquals(emptyList, out.allEmployeesByDepartment(1000));
    }

}
