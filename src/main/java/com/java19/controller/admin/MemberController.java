package com.java19.controller.admin;

import com.java19.model.RoleModel;
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
import java.util.List;


@WebServlet(urlPatterns = {"/admin-member", "/admin-addmem"})
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
        List<RoleModel> listMember = roleService.getAllRoles();
        req.setAttribute("roles", listMember);
        String action = req.getParameter("action");
        if(action == null){
            req.getRequestDispatcher("views/admin/user-table.jsp").forward(req, resp);
        }else if (action.equals("addmem")) {
            req.getRequestDispatcher("views/admin/user-add.jsp").forward(req, resp);
        }else if (action.equals("edit")) {
            int id = Integer.parseInt(req.getParameter("id"));
            req.setAttribute("userEdit", usersService.findUserById(id));
            req.setAttribute("listRole", roleService.getAllRoles());
            req.getRequestDispatcher("views/admin/role-edit.jsp").forward(req, resp);
        } else if (action.equals("detail")) {
            int id = Integer.parseInt(req.getParameter("id"));
            UsersModel user = usersService.findUserById(id);
            user.setUndoneTask(taskServices.findTaskByStatusAndUser(id, 1));
            user.setProgressTask(taskServices.findTaskByStatusAndUser(id, 2));
            user.setCompleteTask(taskServices.findTaskByStatusAndUser(id, 3));
            req.setAttribute("user", user);
            req.getRequestDispatcher("views/admin/member-details.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action.equals("edit")){
            int id = Integer.parseInt(req.getParameter("id"));
            int roleId = Integer.parseInt(req.getParameter("txtRole"));
            usersService.updateRoleUser(id, roleId);
            resp.sendRedirect(req.getContextPath() + "/admin-member");
        }else if (action.equals("addmem")) {
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
}
