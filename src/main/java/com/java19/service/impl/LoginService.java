package com.java19.service.impl;

import com.java19.model.UsersModel;
import com.java19.repository.impl.UsersRepository;
import com.java19.service.ILoginService;

import javax.inject.Inject;
import java.util.List;

public class LoginService implements ILoginService {
    @Inject
    UsersRepository usersRepository;

    public UsersModel checkLoginAndGetRole(String email, String password){
        return usersRepository.getUsersByEmailAndPassword(email, password);
    }
}
