package com.java19.api;

import com.google.gson.Gson;
import com.java19.model.JobsModel;
import com.java19.service.IJobServices;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "apiJob", urlPatterns = {"/api/job"})
public class JobApi extends HttpServlet {

    @Inject
    IJobServices jobServices;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        GenericApi.setType(resp);
        int id = Integer.parseInt(req.getParameter("id"));
        boolean isSuccess = jobServices.deleteUsersById(id);
        GenericApi.returnRespond(200, isSuccess, isSuccess ? "Xóa thành công" : "Xóa thất bại", resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericApi.setType(resp);
        Gson gson = new Gson();
        String Data = GenericApi.getParamsFromPost(req);
        JobsModel jobsModel = gson.fromJson(Data, JobsModel.class);
        boolean isSuccess = jobServices.updateJob(jobsModel);
        GenericApi.returnRespond(200, isSuccess, isSuccess ? "Update thành công" : "Update thất bại", resp);
    }


}
