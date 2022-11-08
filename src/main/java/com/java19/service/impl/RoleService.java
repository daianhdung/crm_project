package com.java19.service.impl;

import com.java19.model.RoleModel;
import com.java19.repository.impl.RoleRepository;
import com.java19.service.IRoleService;

import java.util.List;

public class RoleService implements IRoleService {
    private RoleRepository roleRepository = new RoleRepository();

    public List<RoleModel> getAllRoles() {
        return roleRepository.getRoles();
    }

    public boolean deleteRolesById(int id){
        int result = roleRepository.deleteRolesById(id);
        return result > 0 ? true : false;
    }

    @Override
    public int findIdByName(String name) {
        return roleRepository.findIdByName(name);
    }

    @Override
    public boolean insertRole(RoleModel roleModel) {
        return roleRepository.insertRole(roleModel);
    }
}
