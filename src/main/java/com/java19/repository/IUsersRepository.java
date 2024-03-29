package com.java19.repository;

import com.java19.model.UsersModel;

import java.util.List;

public interface IUsersRepository extends GenericRepository<UsersModel>{

    UsersModel getUsersByEmailAndPassword(String email, String password);
    void deleteUsersById(int id);

    List<UsersModel> getAllMember();

    boolean insertUser(UsersModel usersModel);

    UsersModel getNameById(int userId);

    UsersModel findUserById(int id);

    void updateRoleUser(int userId, int roleId);

    UsersModel getUserByEmail(String email);
}
