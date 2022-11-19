package com.java19.service.impl;

import com.java19.model.TasksModel;
import com.java19.repository.ITaskRepository;
import com.java19.service.ITaskServices;

import javax.inject.Inject;
import java.util.List;

public class TaskService implements ITaskServices {
    @Inject
    ITaskRepository taskRepository;
    @Override
    public List<TasksModel> getAll() {
        return taskRepository.getAll();
    }

    @Override
    public boolean insertTask(TasksModel tasksModel) {
        return taskRepository.insertTask(tasksModel);
    }

    @Override
    public boolean deleteTask(int id) {
        try {
            taskRepository.deleteUsersById(id);
        }catch (Exception e){
            System.out.println("Lỗi delete task");
            return false;
        }
        return true;
    }

    @Override
    public List<TasksModel> getAllById(int id) {
        return taskRepository.getAllById(id);
    }

    @Override
    public boolean updateTask(int statusId, int id) {
        try {
            taskRepository.updateTaskStatus(statusId, id);
        }catch (Exception e){
            System.out.println("Lỗi update task");
            return false;
        }
        return true;
    }

    @Override
    public TasksModel findOne(int id) {
        return taskRepository.findOne(id);
    }

    @Override
    public List<TasksModel> findTaskByStatusAndUser(int userId, int statusId) {
        return taskRepository.getTaskByStatusAndUser(userId, statusId);
    }

    @Override
    public List<Integer> findIdUserInProject(int jobId) {
        return taskRepository.findIdUserInProject(jobId);
    }

    @Override
    public boolean updateTask(TasksModel tasksModel) {
        try {
            taskRepository.updateTask(tasksModel);
        }catch (Exception e){
            System.out.println("Error update task");
            return false;
        }
        return true;
    }

}
