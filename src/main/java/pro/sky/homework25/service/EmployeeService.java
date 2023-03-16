package pro.sky.homework25.service;

import org.apache.commons.lang3.StringUtils;
import pro.sky.homework25.exeption.EmployeeWrongTextEntryException;
import pro.sky.homework25.object.Department;
import pro.sky.homework25.object.Employee;

import static pro.sky.homework25.object.Department.DEPARTMENT_BY_ID;

import pro.sky.homework25.exeption.EmployeeAlreadyAddedException;
import pro.sky.homework25.exeption.EmployeeNotFoundException;
import pro.sky.homework25.exeption.EmployeeStorageIsFullException;
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

        if ((StringUtils.startsWith(firstName, firstName.toLowerCase())) ||
                (StringUtils.startsWith(lastName, lastName.toLowerCase()))) {
        throw new EmployeeWrongTextEntryException("Написанно с маленькой буквы");
        }


        Employee employee = new Employee(firstName, lastName, salary, DEPARTMENT_BY_ID.get(departmentId));
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException("В массиве уже есть такой сотрудник");
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    public Employee find(String firstName, String lastName, String salary, Department department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException("Такой сотрудник не найден");
    }

    public Employee remove(String firstName, String lastName, String salary, Department department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
        employees.remove(employee.getFullName());
        throw new EmployeeNotFoundException("Такой сотрудник не найден");
    }

    public Collection<Employee> getAll() {
        return Collections.unmodifiableCollection(employees.values());
    }
}
