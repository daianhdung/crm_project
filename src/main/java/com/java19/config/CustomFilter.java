//package com.java19.config;
//
//import com.java19.model.UsersModel;
//import com.java19.utils.SessionUtil;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//
//@WebFilter(urlPatterns = {"/*"})
//public class CustomFilter implements Filter {
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//
//        HttpServletRequest req = (HttpServletRequest) servletRequest;
//        HttpServletResponse resp = (HttpServletResponse) servletResponse;
//        req.setCharacterEncoding("UTF-8");
//        String url = req.getServletPath();
//
//
//        if(SessionUtil.getInstance().getValue(req,"isLogin") == null){
//            if(req.getServletPath().equals("/login-page")){
//                filterChain.doFilter(req, resp);
//            }else {
//                resp.sendRedirect(req.getContextPath() + "/login-page");
//            }
//        }else {
//            UsersModel isLogin = (UsersModel) SessionUtil.getInstance().getValue(req,"isLogin");
//            if(url.startsWith("/admin")){
//                if(isLogin.getRole().getName().equals("ROLE_ADMIN")){
//                    filterChain.doFilter(req, resp);
//                }else {
//                    resp.sendRedirect(req.getContextPath() + "/404");
//                }
//            } else if (url.startsWith("/manager")) {
//                if(isLogin.getRole().getName().equals("ROLE_MANAGER")){
//                    filterChain.doFilter(req, resp);
//                }else {
//                    resp.sendRedirect(req.getContextPath() + "/404");
//                }
//            } else if (url.startsWith("/login")) {
//                if(isLogin.getRole().getName().equals("ROLE_MANAGER")){
//                    resp.sendRedirect(req.getContextPath() + "/manager-home");
//                } else if (isLogin.getRole().getName().equals("ROLE_ADMIN")){
//                    resp.sendRedirect(req.getContextPath() + "/admin-home");
//                }else {
//                    resp.sendRedirect(req.getContextPath() + "/home-page");
//                }
//            } else if (url.startsWith("/logout")) {
//                filterChain.doFilter(req, resp);
//            }
//            else {
//                filterChain.doFilter(req, resp);
//            }
//        }
//
//    }
//}
//
