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
}
