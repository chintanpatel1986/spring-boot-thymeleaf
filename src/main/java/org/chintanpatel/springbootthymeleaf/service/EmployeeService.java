package org.chintanpatel.springbootthymeleaf.service;

import org.chintanpatel.springbootthymeleaf.model.Employee;

import java.util.List;

public interface EmployeeService {

    void addEmployee(Employee employee);

    List<Employee>getAllEmployeeList();

    Employee getEmployeeById(Long employeeId);

    void deleteEmployeeById(Long employeeId);
}