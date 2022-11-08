package com.java19.service;

import com.java19.model.UsersModel;

import java.util.List;

public interface IUsersService {

    List<UsersModel> getAllMember();
    public boolean deleteUsersById(int id);
    boolean insertUser(UsersModel usersModel);
}
