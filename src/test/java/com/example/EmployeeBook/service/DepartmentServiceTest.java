package com.example.EmployeeBook.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
    void employeeMinSalaryWithDepartment() {
        when(employeeMock.allEmployees())
                .thenReturn(EMPLOYEES);
        assertEquals(EMPLOYEE2, out.employeeMinSalaryWithDepartment(2));
    }
    @Test
    void employeeSumSalaryWithDepartment() {
        when(employeeMock.allEmployees())
                .thenReturn(EMPLOYEES);
        assertEquals(SALARY1 + SALARY2, out.employeeSumSalaryWithDepartment(1));
    }
    @Test
    void allEmployeesByDepartment() {
        when(employeeMock.allEmployees())
                .thenReturn(EMPLOYEES);
        assertIterableEquals(EMPLOYEES_BY_DEPARTMENT, out.allEmployeesByDepartment(2));
    }
}
