package com.java19.api;

import com.google.gson.Gson;
import com.java19.payload.ResponseData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GenericApi {

    public static void setType(HttpServletResponse resp){
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
    }

    public static void returnRespond(int status, boolean success, String description, HttpServletResponse resp)
            throws IOException {
        PrintWriter out = resp.getWriter();
        ResponseData responseData = new ResponseData();
        responseData.setStatus(status);
        responseData.setSuccess(success);
        responseData.setDescription(description);
        Gson gson = new Gson();
        String json = gson.toJson(responseData);
        out.println(json);
        out.flush();
    }

}
