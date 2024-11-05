package org.chintanpatel.springbootthymeleaf.service;

import org.chintanpatel.springbootthymeleaf.entities.Role;

import java.util.List;

public interface RoleService {

    void addRole(Role role);

    List<Role>getAllRoleList();

    Role getRoleById(Long roleId);

    void deleteRoleById(Long roleId);
}
