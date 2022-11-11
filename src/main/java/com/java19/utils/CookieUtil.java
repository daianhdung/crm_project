package com.java19.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
    public static void createCookie(String key, String value, int maxAge, HttpServletResponse resp){
        Cookie cookie = new Cookie(key, value);
        cookie.setMaxAge(maxAge);
        resp.addCookie(cookie);
    }

    public static Cookie getCookie(HttpServletRequest req, String name){
        Cookie[] cookies = req.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals(name)){
                    return cookie;
                }
            }
        }
        return null;
    }
}
