package com.java19.model;

import com.google.gson.annotations.SerializedName;

public class TasksModel {

    private int id;
    private String name;

    @SerializedName("startDate")
    private String startDate;
    @SerializedName("endDate")
    private String endDate;
    private UsersModel usersModel;
    private JobsModel jobsModel;
    private StatusModel statusModel;
    @SerializedName("statusId")
    private int statusId;
    private int userId;

    public TasksModel(){}

    public TasksModel(String name, String startDate, String endDate, UsersModel usersModel, JobsModel jobsModel
    , StatusModel statusModel) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.usersModel = usersModel;
        this.jobsModel = jobsModel;
        this.statusModel = statusModel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public UsersModel getUsersModel() {
        return usersModel;
    }

    public void setUsersModel(UsersModel usersModel) {
        this.usersModel = usersModel;
    }

    public JobsModel getJobsModel() {
        return jobsModel;
    }

    public void setJobsModel(JobsModel jobsModel) {
        this.jobsModel = jobsModel;
    }

    public StatusModel getStatusModel() {
        return statusModel;
    }

    public void setStatusModel(StatusModel statusModel) {
        this.statusModel = statusModel;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
