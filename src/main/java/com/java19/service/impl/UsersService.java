package com.java19.service.impl;

import com.java19.model.UsersModel;
import com.java19.repository.IRoleRepository;
import com.java19.repository.ITaskRepository;
import com.java19.repository.IUsersRepository;
import com.java19.service.IUsersService;
import com.java19.utils.ValidationUtil;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import static com.java19.utils.ValidationUtil.validateDate;

public class UsersService implements IUsersService {
    @Inject
    IUsersRepository usersRepository;
    @Inject
    ITaskRepository taskRepository;
    @Inject
    IRoleRepository roleRepository;

    @Override
    public List<UsersModel> getAllMember() {
        return usersRepository.getAllMember();
    }

    @Override
    public boolean deleteUsersById(int id) {
        try {
            usersRepository.deleteUsersById(id);
        } catch (Exception e) {
            System.out.println("Lỗi delete user");
            return false;
        }
        return true;
    }

    @Override
    public boolean insertUser(UsersModel usersModel, String role) {
        int id = roleRepository.findIdByName(role);
        usersModel.setRole_id(id);

        UsersModel userEmailExist = usersRepository.getUserByEmail(usersModel.getEmail());
        if (!ValidationUtil.validNull(usersModel.getEmail(), usersModel.getFullname(), usersModel.getPassword())) {
            return false;
        } else if (userEmailExist != null) {
            return false;
        } else {
            return usersRepository.insertUser(usersModel);
        }
    }

    @Override
    public UsersModel getNameById(int id) {
        return usersRepository.getNameById(id);
    }

    @Override
    public UsersModel findUserById(int id) {
        return usersRepository.findUserById(id);
    }

    @Override
    public boolean updateRoleUser(int userId, int roleId) {
        try {
            usersRepository.updateRoleUser(userId, roleId);
        } catch (Exception e) {
            System.out.println("Error update role user");
            return false;
        }
        return true;
    }

    @Override
    public List<UsersModel> listUserByTask(List<Integer> listUserId) {
        List<UsersModel> listUser = new ArrayList<>();
        for (int index : listUserId) {
            UsersModel user = usersRepository.getNameById(index);
            user.setUndoneTask(taskRepository.getTaskByStatusAndUser(index, 1));
            user.setProgressTask(taskRepository.getTaskByStatusAndUser(index, 2));
            user.setCompleteTask(taskRepository.getTaskByStatusAndUser(index, 3));
            listUser.add(user);
        }

        return listUser;
    }


}
