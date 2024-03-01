package com.example.EmployeeBook.constants;

import com.example.EmployeeBook.employee.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConstantsEmployeesBookForTest {
    public static final String FIRST_NAME1 = "Имя";
    public static final String FIRST_NAME2 = "ИмяДва";
    public static final String FIRST_NAME3 = "ИмяТри";
    public static final String FIRST_NAME4 = "ИмяЧетыре";
    public static final String FIRST_NAME5 = "ИмяПять";
    public static final String FIRST_NAME6 = "ИмяШесть";
    public static final String FIRST_NAME7 = "ИмяСемь";
    public static final String FIRST_NAME8 = "ИмяВосемь";
    public static final String FIRST_NAME9 = "ИмяДевять";
    public static final String FIRST_NAME10 = "ИмяДесять";
    public static final String FIRST_NAME11 = "ИмяОдиннадцать";
    public static final String NAME_BAD_VALUE = "№4224Э";

    public static final String FIRST_NAME_LOWER_CASE = "имя";
    public static final String LAST_NAME1 = "Фамилия";
    public static final String LAST_NAME2 = "ФамилияДва";
    public static final String LAST_NAME_LOWER_CASE = "фамилия";

    public static final int DEPARTMENT1 = 1;
    public static final int DEPARTMENT2 = 2;
    public static final int DEPARTMENT3 = 3;
    public static final int DEPARTMENT4 = 4;
    public static final double SALARY1 = 60000.00;
    public static final double SALARY2 = 45000.00;
    public static final Employee EMPLOYEE1 = new Employee(FIRST_NAME1, LAST_NAME1, DEPARTMENT1, SALARY1);
    public static final Employee EMPLOYEE2 = new Employee(FIRST_NAME2, LAST_NAME2, DEPARTMENT2, SALARY2);
    public static final Employee EMPLOYEE3 = new Employee(FIRST_NAME3, LAST_NAME2, DEPARTMENT1, SALARY2);
    public static final Employee EMPLOYEE4 = new Employee(FIRST_NAME4, LAST_NAME2, DEPARTMENT2, SALARY1);
    public static final Employee EMPLOYEE5 = new Employee(FIRST_NAME5, LAST_NAME2, DEPARTMENT3, SALARY2);

    public static final List<Employee> EMPLOYEES = new ArrayList<>(List.of(
            EMPLOYEE1, EMPLOYEE2, EMPLOYEE3, EMPLOYEE4, EMPLOYEE5
    ));
    public static final List<Employee> EMPLOYEES_BY_DEPARTMENT1 = new ArrayList<>(List.of(
            EMPLOYEE1, EMPLOYEE3
    ));
    public static final List<Employee> EMPLOYEES_BY_DEPARTMENT2 = new ArrayList<>(List.of(
            EMPLOYEE2, EMPLOYEE4
    ));
    public static final List<Employee> EMPLOYEES_BY_DEPARTMENT3 = new ArrayList<>(List.of(
            EMPLOYEE5
    ));
    public static  final Map<Integer,List<Employee>> EMPLOYEES_GROUPING_OF_DEPT = new HashMap<>(Map.of(
            1, EMPLOYEES_BY_DEPARTMENT1,
            2, EMPLOYEES_BY_DEPARTMENT2,
            3, EMPLOYEES_BY_DEPARTMENT3
    ));
}


