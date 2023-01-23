package com.java19.controller.manager;


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

@WebServlet(urlPatterns = {"/manager-task"})
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
        String action = req.getParameter("action");
        if(action == null){
            req.getRequestDispatcher("/views/manager/task.jsp").forward(req, resp);
        } else if (action.equals("add")) {
            req.getRequestDispatcher("views/manager/task-add.jsp").forward(req, resp);
        } else if (action.equals("edit")) {
            int id = Integer.parseInt(req.getParameter("id"));
            req.setAttribute("task", taskServices.findOne(id));
            req.getRequestDispatcher("views/manager/task-edit.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String taskName = req.getParameter("txtTaskName");
        int userId = Integer.parseInt(req.getParameter("txtUserId"));
        int workId = Integer.parseInt(req.getParameter("txtWorkId"));
        String startDate = req.getParameter("txtTaskStartDate");
        String endDate = req.getParameter("txtTaskEndDate");

        TasksModel tasksModel = new TasksModel(taskName, startDate, endDate);
        boolean isSuccess = taskServices.insertTask(tasksModel, userId, workId);
        if(!isSuccess){
            String mes = "Thất bại, vui lòng kiểm tra lại dữ liệu";
            req.setAttribute("mes", mes);
            req.setAttribute("users", usersService.getAllMember());
            req.setAttribute("works", jobServices.getAll());
            req.getRequestDispatcher("views/manager/task-add.jsp").forward(req, resp);
        }else {
            resp.sendRedirect(req.getContextPath() + "/manager-task");
        }
    }
}
