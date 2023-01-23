package com.java19.controller.admin;

import com.java19.model.RoleModel;
import com.java19.service.IRoleService;
import com.java19.utils.ValidationUtil;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "rolePage", urlPatterns = {"/admin-role", "/admin-addrole"})
public class RolesController extends HttpServlet {
    @Inject
    IRoleService roleService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("roles", roleService.getAllRoles());
        String action = req.getParameter("action");
        if(action == null){
            req.getRequestDispatcher("views/admin/role-table.jsp").forward(req, resp);
        }else if (action.equals("addrole")) {
            req.getRequestDispatcher("views/admin/role-add.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");

        if(!ValidationUtil.validNull(name, description)){
            String mes = "Không được để trống";
            req.setAttribute("mes", mes);
            req.getRequestDispatcher("views/admin/role-add.jsp").forward(req, resp);
        }else {
            RoleModel roleModel = new RoleModel();
            roleModel.setName(name);
            roleModel.setDescription(description);
            roleService.insertRole(roleModel);
            resp.sendRedirect(req.getContextPath() + "/admin-role");
        }
    }
}
