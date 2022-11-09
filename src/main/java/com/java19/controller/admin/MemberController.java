package com.java19.controller.admin;

import com.java19.model.RoleModel;
import com.java19.model.UsersModel;
import com.java19.service.IRoleService;
import com.java19.service.IUsersService;
import com.java19.utils.ValidationUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = {"/admin-member", "/admin-addmem"})
public class MemberController extends HttpServlet {
    @Inject
    IUsersService usersService;
    @Inject
    IRoleService roleService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("members", usersService.getAllMember());
        req.setAttribute("roles", roleService.getAllRoles());
        String action = req.getParameter("action");
        if(action == null){
            req.getRequestDispatcher("views/admin/user-table.jsp").forward(req, resp);
        }else if (action.equals("addmem")) {
            req.getRequestDispatcher("views/admin/user-add.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String role = req.getParameter("role");

        if(!ValidationUtil.validNull(username, email, password, role)){
            String mes = "Không được để trống";
            req.setAttribute("mes", mes);
            req.getRequestDispatcher("views/admin/user-add.jsp").forward(req, resp);
        }else {
            int id = roleService.findIdByName(role);
            UsersModel usersModel = new UsersModel(email, password, username, id);
            usersService.insertUser(usersModel);
            resp.sendRedirect(req.getContextPath() + "/admin-member");
        }
    }
}
