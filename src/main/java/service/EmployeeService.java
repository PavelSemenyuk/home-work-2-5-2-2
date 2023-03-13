package service;

import object.Department;
import object.Employee;
import static object.Department.DEPARTMENT_BY_ID;
import exeption.EmployeeAlreadyAddedException;
import exeption.EmployeeNotFoundException;
import exeption.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.HashMap;

import java.util.*;

@Service
public class EmployeeService {

    private final int MAX_EMPLOYEES_COUNT = 2;
    private final Map<String, Employee> employees = new HashMap<>();

    public Employee add(String firstName, String lastName, String salary, int departmentId) {

        if (employees.size() == MAX_EMPLOYEES_COUNT) {
            throw new EmployeeStorageIsFullException("Массив сотрудников переполнен");
        }
        Employee employee = new Employee(firstName, lastName, salary, DEPARTMENT_BY_ID.get(departmentId));
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("В массиве уже есть такой сотрудник");
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    public Employee find(String firstName, String lastName, String salary, Department department) {
        Employee employee = new Employee(firstName,  lastName,  salary,  department);
            if (employees.containsKey(employee.getFullName())) {
        return employees.get(employee.getFullName());
    }
    throw new EmployeeNotFoundException("Такой сотрудник не найден");
    }
    public Employee remove(String firstName, String lastName, String salary, Department department) {
        Employee employee = new Employee( firstName,  lastName,  salary,  department);
        employees.remove(employee.getFullName());
        throw new EmployeeNotFoundException("Такой сотрудник не найден");
    }

    public Collection<Employee> getAll() {
        return Collections.unmodifiableCollection(employees.values());
    }
}
