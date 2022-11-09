package com.java19.service;

import com.java19.model.JobsModel;

import java.util.List;

public interface IJobServices {
    List<JobsModel> getAll();
    boolean insertJob(JobsModel jobsModel);

    public boolean deleteUsersById(int id);
}
