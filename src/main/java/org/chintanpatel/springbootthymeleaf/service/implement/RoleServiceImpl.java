package org.chintanpatel.springbootthymeleaf.service.implement;

import org.chintanpatel.springbootthymeleaf.entities.Role;
import org.chintanpatel.springbootthymeleaf.repository.RoleRepository;
import org.chintanpatel.springbootthymeleaf.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Transactional
    @Override
    public void addRole(Role role) {
        roleRepository.save(role);
    }

    @Transactional
    @Override
    public List<Role> getAllRoleList() {
        return roleRepository.findAll();
    }

    @Transactional
    @Override
    public Role getRoleById(Long roleId) {
        return roleRepository.findById(roleId).orElse(null);
    }

    @Transactional
    @Override
    public void deleteRoleById(Long roleId) {
        roleRepository.deleteById(roleId);
    }
}
