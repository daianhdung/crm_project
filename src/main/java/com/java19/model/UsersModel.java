package com.java19.model;

import java.util.List;

public class UsersModel {
    private long id;
    private String email;
    private  String password;
    private  String fullname;
    private String avatar;
    private int role_id;
    private List<TasksModel> undoneTask;
    private List<TasksModel> progressTask;
    private List<TasksModel> completeTask;


    private RoleModel role = new RoleModel();
    public UsersModel() {}

    public UsersModel(String email, String password, String fullname) {
        this.email = email;
        this.password = password;
        this.fullname = fullname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public RoleModel getRole() {
        return role;
    }
    public void setRole(RoleModel role) {
        this.role = role;
    }

    public List<TasksModel> getUndoneTask() {
        return undoneTask;
    }

    public void setUndoneTask(List<TasksModel> undoneTask) {
        this.undoneTask = undoneTask;
    }

    public List<TasksModel> getProgressTask() {
        return progressTask;
    }

    public void setProgressTask(List<TasksModel> progressTask) {
        this.progressTask = progressTask;
    }

    public List<TasksModel> getCompleteTask() {
        return completeTask;
    }

    public void setCompleteTask(List<TasksModel> completeTask) {
        this.completeTask = completeTask;
    }
}
