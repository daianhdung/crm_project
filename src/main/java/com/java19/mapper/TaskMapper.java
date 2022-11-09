package com.java19.mapper;

import com.java19.model.*;

import java.sql.ResultSet;

public class TaskMapper implements RowMapper<TasksModel>{
    @Override
    public TasksModel mapRow(ResultSet resultSet) {
        try {
            TasksModel tasksModel = new TasksModel();
            tasksModel.setId(resultSet.getInt("id"));
            tasksModel.setName(resultSet.getString("name"));
            tasksModel.setStartDate(resultSet.getString("start_date"));
            tasksModel.setEndDate(resultSet.getString("end_date"));
            try {
                UsersModel usersModel = new UsersModel();
                usersModel.setFullname(resultSet.getString("fullname"));
                JobsModel jobsModel = new JobsModel();
                jobsModel.setName(resultSet.getString("job_name"));
                StatusModel statusModel = new StatusModel();
                statusModel.setName(resultSet.getString("status_name"));
                tasksModel.setUsersModel(usersModel);
                tasksModel.setJobsModel(jobsModel);
                tasksModel.setStatusModel(statusModel);
            }catch (Exception e){
                System.out.println("Error get foreign key task");
            }
            return tasksModel;
        }catch (Exception e) {
            System.out.println("Error mapRow task");
            return null;
        }
    }
}
