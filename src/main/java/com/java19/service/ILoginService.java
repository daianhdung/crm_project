package com.java19.service;

import com.java19.model.UsersModel;

public interface ILoginService {

    UsersModel checkLoginAndGetRole(String email, String password);
}
