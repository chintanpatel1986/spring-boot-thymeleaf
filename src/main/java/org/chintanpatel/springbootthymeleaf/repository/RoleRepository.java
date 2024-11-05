package org.chintanpatel.springbootthymeleaf.repository;

import org.chintanpatel.springbootthymeleaf.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Long> {
}