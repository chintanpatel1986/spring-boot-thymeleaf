package org.chintanpatel.springbootthymeleaf.service;

import org.chintanpatel.springbootthymeleaf.entities.Department;

import java.util.List;

public interface DepartmentService {

    void addDepartment(Department department);

    List<Department>getAllDepartmentList();

    Department getDepartmentById(Long departmentId);

    void deleteDepartmentById(Long departmentId);
}
