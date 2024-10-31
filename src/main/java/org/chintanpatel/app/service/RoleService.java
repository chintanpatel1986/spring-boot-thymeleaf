package org.chintanpatel.app.service;

import org.chintanpatel.app.entities.Role;
import org.chintanpatel.app.repository.RoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("roleService")
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Transactional
    public void addRole(Role role) {
        roleRepository.save(role);
    }

    @Transactional
    public List<Role> getAllRoleList() {
        return roleRepository.findAll();
    }

    @Transactional
    public Role getRoleById(Long roleId) {
        return roleRepository.findById(roleId).orElse(null);
    }

    @Transactional
    public void deleteRoleById(Long roleId) {
        roleRepository.deleteById(roleId);
    }
}
