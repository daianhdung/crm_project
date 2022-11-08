package com.java19.mapper;

import com.java19.model.JobsModel;
import com.java19.model.RoleModel;
import com.java19.model.UsersModel;

import java.sql.ResultSet;

public class JobMapper implements RowMapper<JobsModel>{
    @Override
    public JobsModel mapRow(ResultSet resultSet) {
        try {
            JobsModel jobsModel = new JobsModel();
            jobsModel.setId(resultSet.getInt("id"));
            jobsModel.setName(resultSet.getString("name"));
            jobsModel.setStart_date(resultSet.getString("start_date"));
            jobsModel.setEnd_date(resultSet.getString("end_date"));
            return jobsModel;
        }catch (Exception e) {
            System.out.println("Error mapRow jobs");
            return null;
        }
    }
}
