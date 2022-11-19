package com.java19.controller.web;


import com.java19.model.JobsModel;
import com.java19.model.StatusModel;
import com.java19.model.TasksModel;
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

@WebServlet(urlPatterns = {"/task"})
public class TaskController extends HttpServlet {
    @Inject
    ITaskServices taskServices;
    @Inject
    IJobServices jobServices;
    @Inject
    IUsersService usersService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("works", jobServices.getAll());
        req.setAttribute("tasks", taskServices.getAll());
        req.setAttribute("users", usersService.getAllMember());
        req.getRequestDispatcher("/views/web/task.jsp").forward(req, resp);
    }

}
