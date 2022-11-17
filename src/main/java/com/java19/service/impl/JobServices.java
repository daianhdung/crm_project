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
    public boolean insertJob(JobsModel jobsModel) {
        return jobRespository.insertJob(jobsModel);
    }

    @Override
    public boolean deleteUsersById(int id) {
        try {
            jobRespository.deleteUsersById(id);
        }catch (Exception e){
            System.out.println("Lỗi delete jobs");
            return false;
        }
        return true;
    }

    @Override
    public JobsModel findJobById(int id) {
        return jobRespository.findJobById(id);
    }

    @Override
    public boolean updateJob(JobsModel jobsModel) {
        try {
            jobRespository.updateJob(jobsModel);
        }catch (Exception e){
            System.out.println("Error update job");
            return false;
        }
        return true;
    }
}
