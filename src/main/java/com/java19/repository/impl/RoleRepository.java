package com.java19.repository.impl;

import com.java19.config.MysqlConnection;
import com.java19.mapper.RolesMapper;
import com.java19.model.RoleModel;
import com.java19.repository.IRoleRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoleRepository extends AbstractRepository<RoleModel> implements IRoleRepository {

    public List<RoleModel> getRoles(){
        String sql = "SELECT * FROM roles";
        return query(sql, new RolesMapper());
    }

    public int deleteRolesById(int id){
        int result = 0;
        try {
            String query = "DELETE from roles r where r.id = ?;";
            Connection connection = MysqlConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            result = statement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            System.out.println("Error deleteRolesById");
        }
        return result;
    }

    @Override
    public int findIdByName(String name) {
        String sql = "SELECT * FROM roles WHERE name = ?";
        List<RoleModel> list = query(sql, new RolesMapper(), name);
        return  list.isEmpty() ? null : list.get(0).getId();
    }

    @Override
    public boolean insertRole(RoleModel roleModel) {
        String sql = "INSERT INTO roles(name, description) " +
                "VALUES (?, ?)";
        return insert(sql, roleModel.getName(), roleModel.getDescription());
    }
}
