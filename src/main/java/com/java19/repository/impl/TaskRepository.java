package com.java19.repository.impl;

import com.java19.mapper.TaskMapper;
import com.java19.model.TasksModel;
import com.java19.repository.ITaskRepository;

import java.util.List;

public class TaskRepository extends AbstractRepository<TasksModel> implements ITaskRepository {
    @Override
    public List<TasksModel> getAll() {
        StringBuilder sql = new StringBuilder("SELECT * FROM tasks");
        return query(sql.toString(), new TaskMapper());
    }
}
