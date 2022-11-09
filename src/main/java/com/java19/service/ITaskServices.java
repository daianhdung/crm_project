package com.java19.service;

import com.java19.model.TasksModel;

import java.util.List;

public interface ITaskServices {

    List<TasksModel> getAll();
    boolean insertTask(TasksModel tasksModel);

    boolean deleteTask(int id);

    List<TasksModel> getAllById(int id);

    boolean updateTask(int statusId, int id);

    TasksModel findOne(int id);

    List<TasksModel> findTaskByStatusAndUser(int userId, int statusId);
}
