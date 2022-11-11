package com.java19.repository.impl;

import com.java19.config.MysqlConnection;
import com.java19.mapper.UserMapper;
import com.java19.model.UsersModel;
import com.java19.repository.IUsersRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersRepository extends AbstractRepository<UsersModel> implements IUsersRepository{

    @Override
    public UsersModel getUsersByEmailAndPassword(String email, String password){
        StringBuilder sql = new StringBuilder("SELECT * FROM users u");
        sql.append(" INNER JOIN roles r ON u.role_id = r.id");
        sql.append(" WHERE u.email = ? AND u.password = ?");
        List<UsersModel> list = query(sql.toString(), new UserMapper(), email, password);
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public void deleteUsersById(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        update(sql, id);
    }

    @Override
    public List<UsersModel> getAllMember() {
        StringBuilder sql = new StringBuilder("SELECT * FROM users u");
        sql.append(" INNER JOIN roles r ON u.role_id = r.id");
        return query(sql.toString(), new UserMapper());
    }

    @Override
    public boolean insertUser(UsersModel usersModel) {
        String sql = "INSERT INTO users(email,password,fullname,role_id) " +
                "VALUES (?, ?, ?, ?)";
        return insert(sql, usersModel.getEmail(), usersModel.getPassword(), usersModel.getFullname(),
                usersModel.getRole_id());
    }

    @Override
    public UsersModel getNameById(int userId) {
        String sql = "SELECT * FROM users u JOIN roles r ON u.role_id = r.id WHERE u.id = ?";
        return query(sql, new UserMapper(), userId).get(0);
    }

    @Override
    public UsersModel findUserById(int id) {
        String sql = "SELECT * FROM users u LEFT JOIN roles r ON u.role_id = r.id WHERE u.id = ?";
        return query(sql, new UserMapper(), id).get(0);
    }


}
