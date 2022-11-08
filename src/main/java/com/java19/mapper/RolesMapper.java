package com.java19.mapper;

import com.java19.model.RoleModel;

import java.sql.ResultSet;

public class RolesMapper implements RowMapper<RoleModel>{


    @Override
    public RoleModel mapRow(ResultSet rs) {
        try {
            RoleModel roleModel = new RoleModel();
            roleModel.setId(rs.getInt("id"));
            roleModel.setName(rs.getString("name"));
            roleModel.setDescription(rs.getString("description"));
            return  roleModel;
        }catch (Exception e){
            System.out.println("Lỗi map row rolesmodel");
            return null;
        }
    }
}
