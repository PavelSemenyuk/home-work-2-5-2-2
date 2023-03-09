package service;

import employee.Employee;

import exeption.EmployeeAlreadyAddedException;
import exeption.EmployeeNotFoundException;
import exeption.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {

    private final int MAX_EMPLOYEES_COUNT = 2;
    private final Map<String, Employee> employees = new HashMap();

    public Employee add(String firstName, String lastName) {

        if (employees.size() == MAX_EMPLOYEES_COUNT) {
            throw new EmployeeStorageIsFullException("Массив сотрудников переполнен");
        }
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee)) {
            throw new EmployeeAlreadyAddedException("В массиве уже есть такой сотрудник");
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    public Employee find(String firstName, String lastName) {
        Employee employee = null;
            if (employees.containsKey(employee.getFullName())) {
        return employees.get(employee.getFullName());
    }
    throw new EmployeeNotFoundException("Такой сотрудник не найден");
    }
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            employees.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException("Такой сотрудник не найден");
    }

    public Collection<Employee> getAll() {
        return Collections.unmodifiableCollection(employees.values());
    }
}
