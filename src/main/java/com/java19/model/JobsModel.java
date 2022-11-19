package com.java19.model;


import com.google.gson.annotations.SerializedName;

public class JobsModel {
    private int id;
    private String name;
    @SerializedName("startDate")
    private String start_date;
    @SerializedName("endDate")
    private String end_date;

    public JobsModel() {}

    public JobsModel(String name, String start_date, String end_date) {
        this.name = name;
        this.start_date = start_date;
        this.end_date = end_date;
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

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }
}
