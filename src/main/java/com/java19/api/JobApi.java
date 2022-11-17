package com.java19.api;

import com.java19.model.JobsModel;
import com.java19.service.IJobServices;
import org.apache.commons.beanutils.BeanUtils;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpUtils;
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
        PrintWriter out = resp.getWriter();
        GenericApi.setType(resp);

        JobsModel jobsModel = new JobsModel();
        
    }
}
