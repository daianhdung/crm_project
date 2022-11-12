package com.java19.service;

import com.java19.model.UsersModel;

import java.util.List;

public interface IUsersService {

    List<UsersModel> getAllMember();
    public boolean deleteUsersById(int id);
    boolean insertUser(UsersModel usersModel);

    UsersModel getNameById(int id);

    UsersModel findUserById(int id);

    boolean updateRoleUser(int userId, int roleId);
}
