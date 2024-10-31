package org.chintanpatel.app.service;

import org.chintanpatel.app.entities.Department;
import org.chintanpatel.app.repository.DepartmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("departmentService")
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Transactional
    public void addDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Transactional
    public List<Department> getAllDepartmentList() {
        return departmentRepository.findAll();
    }

    @Transactional
    public Department getDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).orElse(null);
    }

    @Transactional
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }
}
