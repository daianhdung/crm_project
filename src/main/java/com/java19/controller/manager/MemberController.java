package com.java19.controller.manager;

import com.java19.model.UsersModel;
import com.java19.service.IRoleService;
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

@WebServlet(urlPatterns = {"/manager-member", "/manager-addmem"})
public class MemberController extends HttpServlet {
    @Inject
    IUsersService usersService;
    @Inject
    IRoleService roleService;
    @Inject
    ITaskServices taskServices;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("members", usersService.getAllMember());
        String action = req.getParameter("action");
        if(action == null){
            req.getRequestDispatcher("views/manager/user-table.jsp").forward(req, resp);
        }else if (action.equals("addmem")) {
            req.getRequestDispatcher("views/manager/user-add.jsp").forward(req, resp);
        } else if (action.equals("detail")) {
            int id = Integer.parseInt(req.getParameter("id"));
            UsersModel user = usersService.findUserById(id);
            user.setUndoneTask(taskServices.findTaskByStatusAndUser(id, 1));
            user.setProgressTask(taskServices.findTaskByStatusAndUser(id, 2));
            user.setCompleteTask(taskServices.findTaskByStatusAndUser(id, 3));
            req.setAttribute("user", user);
            req.getRequestDispatcher("views/manager/member-details.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String role = req.getParameter("role");

        UsersModel usersModel = new UsersModel(email, password, username);
        boolean isSuccess = usersService.insertUser(usersModel, role);

        if(!isSuccess){
            String mes = "Thất bại, vui lòng kiểm tra lại dữ liệu";
            req.setAttribute("mes", mes);
            req.getRequestDispatcher("views/manager/user-add.jsp").forward(req, resp);
        }else {
            resp.sendRedirect(req.getContextPath() + "/manager-member");
        }
    }
}
