package com.java19.controller.manager;


import com.java19.model.JobsModel;
import com.java19.model.UsersModel;
import com.java19.service.IJobServices;
import com.java19.service.ITaskServices;
import com.java19.service.IUsersService;
import com.java19.utils.ValidationUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/manager-work"})
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
            req.getRequestDispatcher("/views/manager/groupwork.jsp").forward(req, resp);
        } else if (action.equals("details")) {
            int jobId = Integer.parseInt(req.getParameter("id"));
            List<Integer> listUserId = taskServices.findIdUserInProject(jobId);
            List<UsersModel> listUser = usersService.listUserByTask(listUserId);
            req.setAttribute("namesStaff",listUser);
            req.getRequestDispatcher("/views/manager/groupwork-details.jsp").forward(req, resp);

        } else if (action.equals("edit")) {
            int id = Integer.parseInt(req.getParameter("id"));
            req.setAttribute("work", jobServices.findJobById(id));
            req.getRequestDispatcher("/views/manager/job-edit.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
