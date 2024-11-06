package org.chintanpatel.springbootthymeleaf.service.implement;

import jakarta.transaction.Transactional;
import org.chintanpatel.springbootthymeleaf.entities.Employee;
import org.chintanpatel.springbootthymeleaf.repository.EmployeeRepository;
import org.chintanpatel.springbootthymeleaf.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Transactional
    @Override
    public List<Employee> getAllEmployeeList() {
        return employeeRepository.findAll();
    }

    @Transactional
    @Override
    public Employee getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId).orElse(null);
    }

    @Transactional
    @Override
    public void deleteEmployeeById(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
