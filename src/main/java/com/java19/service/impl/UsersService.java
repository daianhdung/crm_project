package com.java19.service.impl;

import com.java19.model.UsersModel;
import com.java19.repository.IUsersRepository;
import com.java19.service.IUsersService;

import javax.inject.Inject;
import java.util.List;

public class UsersService implements IUsersService {
    @Inject
    IUsersRepository usersRepository;
    @Override
    public List<UsersModel> getAllMember() {
        return usersRepository.getAllMember();
    }

    @Override
    public boolean deleteUsersById(int id) {
        try {
            usersRepository.deleteUsersById(id);
        }catch (Exception e){
            System.out.println("Lỗi delete user");
            return false;
        }
        return true;
    }

    @Override
    public boolean insertUser(UsersModel usersModel) {
        return usersRepository.insertUser(usersModel);
    }


}
