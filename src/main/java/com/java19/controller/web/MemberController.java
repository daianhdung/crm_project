package com.java19.controller.web;

import com.java19.model.UsersModel;
import com.java19.service.IUsersService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/member", "/member-detail"})
public class MemberController extends HttpServlet {
    @Inject
    IUsersService usersService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<UsersModel> listMember = usersService.getAllMember();
        req.setAttribute("members", listMember);
        String action = req.getParameter("action");
        if(action == null){
            req.getRequestDispatcher("views/web/user-table.jsp").forward(req, resp);
        }

    }
}