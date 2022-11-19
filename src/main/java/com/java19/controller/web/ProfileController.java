package com.java19.controller.web;
import com.java19.model.UsersModel;
import com.java19.service.ITaskServices;
import com.java19.service.IUsersService;
import com.java19.utils.SessionUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/profile"})
public class ProfileController extends HttpServlet {
    @Inject
    IUsersService usersService;
    @Inject
    ITaskServices taskServices;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsersModel usersModel = (UsersModel) SessionUtil.getInstance().getValue(req,"isLogin");
        int userIdLogin = (int) usersModel.getId();
        req.setAttribute("tasks", taskServices.getAllById(userIdLogin));
        String action = req.getParameter("action");
        if(action == null){
            req.getRequestDispatcher("/views/web/profile.jsp").forward(req, resp);
        }else if (action.equals("detail")) {
            req.setAttribute("taskHavenDone", taskServices.findTaskByStatusAndUser(userIdLogin, 1));
            req.setAttribute("taskDoing", taskServices.findTaskByStatusAndUser(userIdLogin, 2));
            req.setAttribute("taskComplete", taskServices.findTaskByStatusAndUser(userIdLogin, 3));
            req.getRequestDispatcher("views/web/user-details.jsp").forward(req, resp);
        }else if (action.equals("edit")) {
            int id = Integer.parseInt(req.getParameter("id"));
            req.setAttribute("taskEdit", taskServices.findOne(id));
            req.getRequestDispatcher("views/web/profile-edit.jsp").forward(req, resp);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action.equals("edit")){
            int id = Integer.parseInt(req.getParameter("id"));
            int statusId = Integer.parseInt(req.getParameter("statusId"));
            taskServices.updateTask(statusId, id);
            resp.sendRedirect(req.getContextPath() + "/profile");
        }
    }
}