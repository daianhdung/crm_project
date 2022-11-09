package com.java19.repository.impl;

import com.java19.mapper.TaskMapper;
import com.java19.model.TasksModel;
import com.java19.repository.ITaskRepository;

import java.util.List;

public class TaskRepository extends AbstractRepository<TasksModel> implements ITaskRepository {
    @Override
    public List<TasksModel> getAll() {
        StringBuilder sql = new StringBuilder("SELECT t.id, t.name, j.name as job_name, u.fullname, ");
        sql.append(" DATE_FORMAT(t.start_date, '%d-%m-%Y') as start_date,");
        sql.append(" DATE_FORMAT(t.end_date, '%d-%m-%Y') as end_date, s.name as status_name FROM tasks t");
        sql.append(" LEFT JOIN users u ON t.user_id = u.id");
        sql.append(" LEFT JOIN jobs j ON j.id = t.job_id");
        sql.append(" LEFT JOIN status s ON s.id = t.status_id");
        return query(sql.toString(), new TaskMapper());
    }

    @Override
    public boolean insertTask(TasksModel tasksModel) {
        StringBuilder sql = new StringBuilder("INSERT INTO tasks(name, start_date, end_date, user_id, job_id, status_id)");
        sql.append(" VALUES ( ?, STR_TO_DATE( ?, '%d-%m-%Y')");
        sql.append(" , STR_TO_DATE( ?, '%d-%m-%Y')");
        sql.append(" , ?, ?, ?)");
        return insert(sql.toString(), tasksModel.getName(), tasksModel.getStartDate(), tasksModel.getEndDate(),
                tasksModel.getUsersModel().getId(), tasksModel.getJobsModel().getId(),
                tasksModel.getStatusModel().getId());
    }

    @Override
    public void deleteUsersById(int id) {
        String sql = "DELETE FROM tasks WHERE id = ?";
        update(sql, id);
    }

    @Override
    public List<TasksModel> getAllById(int id) {
        StringBuilder sql = new StringBuilder("SELECT t.id, t.name, j.name as job_name, u.fullname, ");
        sql.append(" DATE_FORMAT(t.start_date, '%d-%m-%Y') as start_date,");
        sql.append(" DATE_FORMAT(t.end_date, '%d-%m-%Y') as end_date, s.name as status_name FROM tasks t");
        sql.append(" LEFT JOIN users u ON t.user_id = u.id");
        sql.append(" LEFT JOIN jobs j ON j.id = t.job_id");
        sql.append(" LEFT JOIN status s ON s.id = t.status_id");
        sql.append(" WHERE u.id = ?");
        return query(sql.toString(), new TaskMapper(), id);
    }

    @Override
    public void updateTaskStatus(int statusId, int id) {
        StringBuilder sql = new StringBuilder("UPDATE tasks");
        sql.append(" SET status_id = ? WHERE id = ?");
        update(sql.toString(), statusId, id);
    }

    @Override
    public TasksModel findOne(int id) {
        StringBuilder sql = new StringBuilder("SELECT t.id, t.name, j.name as job_name, u.fullname, ");
        sql.append(" DATE_FORMAT(t.start_date, '%d-%m-%Y') as start_date,");
        sql.append(" DATE_FORMAT(t.end_date, '%d-%m-%Y') as end_date, s.name as status_name FROM tasks t");
        sql.append(" LEFT JOIN users u ON t.user_id = u.id");
        sql.append(" LEFT JOIN jobs j ON j.id = t.job_id");
        sql.append(" LEFT JOIN status s ON s.id = t.status_id");
        sql.append(" WHERE t.id = ?");
        return query(sql.toString(), new TaskMapper(), id).get(0);
    }

    @Override
    public List<TasksModel> getTaskByStatusAndUser(int userId, int statusId) {
        StringBuilder sql = new StringBuilder("SELECT t.id, t.name, j.name as job_name, u.fullname, ");
        sql.append(" DATE_FORMAT(t.start_date, '%d-%m-%Y') as start_date,");
        sql.append(" DATE_FORMAT(t.end_date, '%d-%m-%Y') as end_date, s.name as status_name FROM tasks t");
        sql.append(" LEFT JOIN users u ON t.user_id = u.id");
        sql.append(" LEFT JOIN jobs j ON j.id = t.job_id");
        sql.append(" LEFT JOIN status s ON s.id = t.status_id");
        sql.append(" WHERE s.id = ? AND u.id = ?");
        return query(sql.toString(), new TaskMapper(), statusId, userId);
    }
}
