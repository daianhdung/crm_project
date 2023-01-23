package com.java19.controller.admin;


import com.java19.model.JobsModel;
import com.java19.model.UsersModel;
import com.java19.service.IJobServices;
import com.java19.service.ITaskServices;
import com.java19.service.IUsersService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/admin-work"})
public class GroupWorkController extends HttpServlet {
    @Inject
    IJobServices jobServices;
    @Inject
    ITaskServices taskServices;
    @Inject
    IUsersService usersService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("works", jobServices.getAll());
        String action = req.getParameter("action");
        if(action == null){
            req.getRequestDispatcher("/views/admin/groupwork.jsp").forward(req, resp);
        } else if (action.equals("details")) {
            int jobId = Integer.parseInt(req.getParameter("id"));
            List<Integer> listUserId = taskServices.findIdUserInProject(jobId);
            List<UsersModel> listUser = usersService.listUserByTask(listUserId);
            req.setAttribute("namesStaff",listUser);
            req.getRequestDispatcher("/views/admin/groupwork-details.jsp").forward(req, resp);

        } else if (action.equals("add")) {
            req.getRequestDispatcher("views/admin/groupwork-add.jsp").forward(req, resp);
        } else if (action.equals("edit")) {
            int id = Integer.parseInt(req.getParameter("id"));
            req.setAttribute("work", jobServices.findJobById(id));
            req.getRequestDispatcher("/views/admin/job-edit.jsp").forward(req, resp);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("txtName");
        String startDate = req.getParameter("txtStartDate");
        String endDate = req.getParameter("txtEndDay");

        JobsModel jobsModel = new JobsModel(name, startDate, endDate);
        boolean isSuccess = jobServices.insertJob(jobsModel);
        if(isSuccess){
            resp.sendRedirect(req.getContextPath() + "/admin-work");
        }else {
            String mes = "Dữ liệu nhập vào không hợp lệ, vui lòng thử lại";
            req.setAttribute("mes", mes);
            req.getRequestDispatcher("views/admin/groupwork-add.jsp").forward(req, resp);
        }
    }
}
