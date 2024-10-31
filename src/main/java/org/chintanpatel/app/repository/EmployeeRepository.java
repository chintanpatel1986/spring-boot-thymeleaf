package org.chintanpatel.app.repository;

import org.chintanpatel.app.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}