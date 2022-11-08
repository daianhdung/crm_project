package com.java19.controller.admin;


import com.java19.model.JobsModel;
import com.java19.model.UsersModel;
import com.java19.service.IJobServices;
import com.java19.utils.ValidationUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/admin-work"})
public class GroupWorkController extends HttpServlet {
    @Inject
    IJobServices jobServices;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("works", jobServices.getAll());
        String action = req.getParameter("action");
        if(action == null){
            req.getRequestDispatcher("/views/admin/groupwork.jsp").forward(req, resp);
        }else if (action.equals("add")) {
            req.getRequestDispatcher("views/admin/groupwork-add.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("txtName");
        String startDate = req.getParameter("txtStartDate");
        String endDate = req.getParameter("txtEndDay");

        if(!ValidationUtil.validNull(name, startDate, endDate)){
            String mes = "Không được để trống";
            req.setAttribute("mes", mes);
            req.getRequestDispatcher("views/admin/groupwork-add.jsp").forward(req, resp);
        }else {
            JobsModel jobsModel = new JobsModel(name, startDate, endDate);
            jobServices.insertUser(jobsModel);
            resp.sendRedirect(req.getContextPath() + "/admin-work");
        }
    }
}
