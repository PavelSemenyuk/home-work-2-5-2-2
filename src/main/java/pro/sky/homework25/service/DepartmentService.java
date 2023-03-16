package pro.sky.homework25.service;

import pro.sky.homework25.object.Employee;
import pro.sky.homework25.exeption.DepartmentSearchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    public Employee getEmployeeWithMinSalary(Integer departmentId) {

        return employeeService.getAll().stream()
                .filter(employee -> Objects.equals(employee.getDepartment().getId(), departmentId))
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(()-> new DepartmentSearchException("Департамент не найден"));
    }

    public Employee getEmployeeWithMaxSalary(Integer departmentId) {
        return employeeService.getAll().stream()
                .filter(employee -> Objects.equals(employee.getDepartment().getId(), departmentId))
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new DepartmentSearchException("Департамент не найден"));
    }

    public Map<String, List<Employee>> getAll(Integer departmentId) {

        return employeeService.getAll().stream()
                .filter(employee -> departmentId == null || Objects.equals(employee.getDepartment().getId(), departmentId))
                .collect(Collectors.groupingBy(
                        employee -> employee.getDepartment().getName(),
                        Collectors.mapping(employee -> employee, Collectors.toList())));
    }

}

