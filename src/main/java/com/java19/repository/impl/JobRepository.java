package com.java19.repository.impl;

import com.java19.mapper.JobMapper;
import com.java19.model.JobsModel;
import com.java19.repository.IJobRespository;

import java.sql.SQLException;
import java.util.List;


public class JobRepository extends AbstractRepository<JobsModel> implements IJobRespository {

    @Override
    public List<JobsModel> getAll() {
        StringBuilder sql = new StringBuilder("SELECT id, name");
        sql.append(" , DATE_FORMAT(start_date, '%d-%m-%Y')  as start_date, ");
        sql.append("DATE_FORMAT(end_date, '%d-%m-%Y') as end_date FROM jobs");
        return query(sql.toString(), new JobMapper());
    }

    @Override
    public boolean insertJob(JobsModel jobsModel) {
        StringBuilder sql = new StringBuilder("INSERT INTO jobs(name, start_date, end_date)");
        sql.append(" VALUES(? , STR_TO_DATE(?, '%d-%m-%Y'), STR_TO_DATE(?, '%d-%m-%Y'))");
        return insert(sql.toString(), jobsModel.getName(), jobsModel.getStart_date(), jobsModel.getEnd_date());
    }

    @Override
    public void deleteUsersById(int id) {
        String sql = "DELETE FROM jobs WHERE id = ?";
        update(sql, id);
    }

    @Override
    public JobsModel findJobById(int id) {
        StringBuilder sql = new StringBuilder("SELECT id, name");
        sql.append(" , DATE_FORMAT(start_date, '%d-%m-%Y')  as start_date, ");
        sql.append("DATE_FORMAT(end_date, '%d-%m-%Y') as end_date FROM jobs WHERE id = ?");
        return query(sql.toString(), new JobMapper(), id).get(0);
    }

    @Override
    public void updateJob(JobsModel jobsModel) {
        String sql = "UPDATE jobs SET name = ?, end_date = STR_TO_DATE(?, '%d-%m-%Y') WHERE id = ?";
        update(sql, jobsModel.getName(), jobsModel.getEnd_date(), jobsModel.getId());
    }
}
