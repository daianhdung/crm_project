package com.java19.controller.admin;
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

@WebServlet(urlPatterns = {"/admin-profile"})
public class ProfileController extends HttpServlet {
    @Inject
    IUsersService usersService;
    @Inject
    ITaskServices taskServices;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("members", usersService.getAllMember());
        UsersModel usersModel = (UsersModel) SessionUtil.getInstance().getValue(req,"isLogin");
        req.setAttribute("tasks", taskServices.getAllById((int) usersModel.getId()));
        String action = req.getParameter("action");
        if(action == null){
            req.getRequestDispatcher("/views/admin/profile.jsp").forward(req, resp);
        }else if (action.equals("detail")) {
            req.getRequestDispatcher("views/admin/user-details.jsp").forward(req, resp);
        }else if (action.equals("edit")) {
            int id = Integer.parseInt(req.getParameter("id"));
            req.setAttribute("taskEdit", taskServices.findOne(id));
            req.getRequestDispatcher("views/admin/profile-edit.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action.equals("edit")){
            int id = Integer.parseInt(req.getParameter("id"));
            int statusId = Integer.parseInt(req.getParameter("statusId"));
            taskServices.updateTask(statusId, id);
            resp.sendRedirect(req.getContextPath() + "/admin-profile");
        }
    }
}