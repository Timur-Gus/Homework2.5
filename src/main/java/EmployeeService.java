import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    List<Employee> employees = new ArrayList<>();
    static final int EMPLOYEES_MAX = 10;
    public void addEmployee(String firstName, String lastName) {
        if (employees.size() < EMPLOYEES_MAX) {
            Employee employee = new Employee(firstName, lastName);
            employees.add(employee);
        }
    }
    public void delEmployee(String firstName, String lastName) {
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)){
                employees.remove(employee);
            }
        }
    }
    public String findEmployee(String firstName, String lastName){
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)){
                return employee.toString();
            }
        }
        return "Сотрудник не найден";
    }

}
