package com.java19.service.impl;

import com.java19.model.JobsModel;
import com.java19.model.StatusModel;
import com.java19.model.TasksModel;
import com.java19.model.UsersModel;
import com.java19.repository.IJobRespository;
import com.java19.repository.IStatusRepository;
import com.java19.repository.ITaskRepository;
import com.java19.repository.IUsersRepository;
import com.java19.service.ITaskServices;
import com.java19.utils.ValidationUtil;

import javax.inject.Inject;
import java.util.List;

import static com.java19.utils.ValidationUtil.validateDate;

public class TaskService implements ITaskServices {
    @Inject
    ITaskRepository taskRepository;
    @Inject
    IUsersRepository usersRepository;
    @Inject
    IJobRespository jobRespository;
    @Inject
    IStatusRepository statusRepository;
    @Override
    public List<TasksModel> getAll() {
        return taskRepository.getAll();
    }

    @Override
    public boolean insertTask(TasksModel tasksModel, int userId, int workId) {
        UsersModel usersModel = usersRepository.findUserById(userId);
        JobsModel jobsModel = jobRespository.findJobById(workId);
        StatusModel statusModel = new StatusModel();
        statusModel.setId(1);
        tasksModel.setUsersModel(usersModel);
        tasksModel.setJobsModel(jobsModel);
        tasksModel.setStatusModel(statusModel);
        if (!ValidationUtil.validNull(tasksModel.getName(), tasksModel.getStartDate(), tasksModel.getEndDate())) {
            return false;
        } else if (!validateDate(tasksModel.getStartDate()) || !validateDate(tasksModel.getEndDate())) {
            return false;
        } else {
            return taskRepository.insertTask(tasksModel);
        }
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
            if (!ValidationUtil.validNull(tasksModel.getName(), tasksModel.getEndDate())) {
                return false;
            } else {
                taskRepository.updateTask(tasksModel);
            }
        }catch (Exception e){
            System.out.println("Error update task");
            return false;
        }
        return true;
    }

}
