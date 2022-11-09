package com.java19.repository;
import com.java19.model.JobsModel;


import java.util.List;

public interface IJobRespository extends GenericRepository<JobsModel>{

    List<JobsModel> getAll();

    boolean insertJob(JobsModel jobsModel);

    void deleteUsersById(int id);
}
