package com.java19.repository;

import com.java19.model.TasksModel;

import java.util.List;

public interface ITaskRepository extends GenericRepository<TasksModel>{

    List<TasksModel> getAll();

    boolean insertTask(TasksModel tasksModel);

    void deleteUsersById(int id);
}
