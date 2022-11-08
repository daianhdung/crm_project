package com.java19.service.impl;

import com.java19.model.JobsModel;
import com.java19.repository.IJobRespository;
import com.java19.service.IJobServices;

import javax.inject.Inject;
import java.util.List;

public class JobServices implements IJobServices {
    @Inject
    IJobRespository jobRespository;
    @Override
    public List<JobsModel> getAll() {
        return jobRespository.getAll();
    }

    @Override
    public boolean insertUser(JobsModel jobsModel) {
        return jobRespository.insertUser(jobsModel);
    }
}
