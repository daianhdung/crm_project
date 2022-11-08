package com.java19.mapper;


import com.java19.model.RoleModel;
import com.java19.model.UsersModel;

import java.sql.ResultSet;

public class UserMapper implements RowMapper<UsersModel>{

    @Override
    public UsersModel mapRow(ResultSet resultSet) {
        try {
            UsersModel user = new UsersModel();
            user.setId(resultSet.getInt("id"));
            user.setEmail(resultSet.getString("email"));
            user.setPassword(resultSet.getString("password"));
            user.setFullname(resultSet.getString("fullname"));
            user.setAvatar(resultSet.getString("avatar"));
            try {
                RoleModel role = new RoleModel();
                role.setName(resultSet.getString("name"));
                user.setRole(role);
            }catch (Exception e){
                System.out.println("Error get role user");
            }
            return user;
        }catch (Exception e) {
            System.out.println("Error mapRow user");
            return null;
        }
    }
}
