package com.java19.service.impl;

import com.java19.model.JobsModel;
import com.java19.repository.IJobRespository;
import com.java19.service.IJobServices;
import com.java19.utils.ValidationUtil;

import javax.inject.Inject;
import java.util.List;

import static com.java19.utils.ValidationUtil.validateDate;

public class JobServices implements IJobServices {
    @Inject
    IJobRespository jobRespository;

    @Override
    public List<JobsModel> getAll() {
        return jobRespository.getAll();
    }

    @Override
    public boolean insertJob(JobsModel jobsModel) {
        if (!ValidationUtil.validNull(jobsModel.getName(), jobsModel.getStart_date(), jobsModel.getEnd_date())) {
            return false;
        } else if (!validateDate(jobsModel.getStart_date()) || !validateDate(jobsModel.getEnd_date())) {
            return false;
        } else {
            return jobRespository.insertJob(jobsModel);
        }
    }

    @Override
    public boolean deleteUsersById(int id) {
        try {
            jobRespository.deleteUsersById(id);
        } catch (Exception e) {
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
            return true;
        } catch (Exception e) {
            System.out.println("Error update job");
            return false;
        }
    }
}
