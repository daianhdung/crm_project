package com.java19.repository.impl;

import com.java19.config.MysqlConnection;
import com.java19.mapper.TaskMapper;
import com.java19.model.TasksModel;
import com.java19.repository.ITaskRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

    @Override
    public List<Integer> findIdUserInProject(int jobId) {
        List<Integer> listIdUser = new ArrayList<>();
        String sql = ("SELECT user_id FROM tasks WHERE job_id = ? group by user_id");
        Connection connection = MysqlConnection.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = null;
            statement.setInt(1, jobId);
            resultSet = statement.executeQuery();
            while (resultSet.next()){
                listIdUser.add(resultSet.getInt("user_id"));
            }
            return listIdUser;
        }catch (Exception e){
            System.out.println("Lỗi findIdUserInProject");
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    @Override
    public void updateTask(TasksModel tasksModel) {
        StringBuilder sql = new StringBuilder("Update tasks SET name = ?, status_id = ?, user_id = ?,");
        sql.append("  end_date = STR_TO_DATE(?, '%d-%m-%Y') WHERE id = ?");
        update(sql.toString(), tasksModel.getName(), tasksModel.getStatusId(), tasksModel.getUserId(), tasksModel.getEndDate(),
                tasksModel.getId());
    }


}
