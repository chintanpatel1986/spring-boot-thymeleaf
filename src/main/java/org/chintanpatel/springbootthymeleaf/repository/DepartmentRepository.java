package org.chintanpatel.springbootthymeleaf.repository;

import org.chintanpatel.springbootthymeleaf.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
  }