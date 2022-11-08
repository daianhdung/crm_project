package com.java19.service;

import com.java19.model.RoleModel;

import java.util.List;

public interface IRoleService {

    List<RoleModel> getAllRoles();
    public boolean deleteRolesById(int id);

    int findIdByName(String name);

    boolean insertRole(RoleModel roleModel);
}
