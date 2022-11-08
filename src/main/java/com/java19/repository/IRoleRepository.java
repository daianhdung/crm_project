package com.java19.repository;

import com.java19.model.RoleModel;

import java.util.List;

public interface IRoleRepository {

    List<RoleModel> getRoles();
    int deleteRolesById(int id);

    int findIdByName(String name);

    boolean insertRole(RoleModel roleModel);
}
