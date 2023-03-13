package service;

import object.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentServiceInt {

    Employee getEmployeeWithMinSalary(Integer departmentId);

    Employee getEmployeeWithMaxSalary(Integer departmentId);

    Map<String, List<Employee>> getAll(Integer departmentId);
}
