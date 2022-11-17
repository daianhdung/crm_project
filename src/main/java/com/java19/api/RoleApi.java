package com.java19.api;


import com.google.gson.Gson;
import com.java19.payload.ResponseData;
import com.java19.service.impl.RoleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "roleApi", urlPatterns = {"/api/role"})
public class RoleApi extends HttpServlet {

    private RoleService roleService = new RoleService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(req.getParameter("id"));
        boolean isSuccess = roleService.deleteRolesById(id);

        ResponseData responseData = new ResponseData();
        responseData.setStatus(200);
        responseData.setSuccess(isSuccess);
        responseData.setDescription(isSuccess ? "Xóa thành công" : "Xóa thất bại");

        Gson gson = new Gson();
        String json = gson.toJson(responseData);
        out.print(json);
        out.flush();
    }
}
