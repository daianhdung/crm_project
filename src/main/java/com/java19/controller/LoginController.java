package com.java19.controller;


import com.java19.utils.SessionUtil;
import com.java19.model.UsersModel;
import com.java19.service.impl.LoginService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login-page"})
public class LoginController extends HttpServlet {

    @Inject
    private LoginService loginService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String message = "";
        if(email == null  || password == null ){
            message = "Không được để trống";
            req.getRequestDispatcher("/views/login.jsp").forward(req,resp);
        } else if (email.trim().equals("") || password.trim().equals("")) {
            message = "Không được để trống";
            req.setAttribute("mes", message);
            req.getRequestDispatcher("/views/login.jsp").forward(req,resp);
        } else {
            UsersModel isLogin = loginService.checkLoginAndGetRole(email, password);
            SessionUtil.getInstance().putValue(req,"isLogin", isLogin, 400);

            //Nếu hàm checkLogin false => không có email,pw trong DB
            if(isLogin == null){
                message = "Không đúng id or pass";
                req.setAttribute("mes", message);
                req.getRequestDispatcher("/views/login.jsp").forward(req,resp);
            }else if(isLogin.getRole().getName().equals("ROLE_ADMIN")){
                resp.sendRedirect(req.getContextPath() + "/admin-home");
            }else if(isLogin.getRole().getName().equals("ROLE_MANAGER")){
                resp.sendRedirect(req.getContextPath() + "/manager-home");
            }else if(isLogin.getRole().getName().equals("ROLE_USER")){
                resp.sendRedirect(req.getContextPath() + "/home-page");
            }
        }


//        Cookie cookie = new Cookie("email", email);
//        cookie.setMaxAge(5 * 60);
//        resp.addCookie(cookie);
//
//        Cookie cookie1 = new Cookie("password", password);
//        cookie1.setMaxAge(5 * 60);
//        resp.addCookie(cookie1);
//
//        Cookie[] cookies = req.getCookies();
//        for(Cookie cookie : cookies){
//            System.out.println("Name cookie" + cookie);
//        }

    }
}


