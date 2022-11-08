package com.java19.utils;


import java.util.List;

public class ValidationUtil {

    public static boolean validNull(String... param){
        for(String index : param){
            if(index.trim().equals("")){
                return false;
            }else if(index == null){
                return false;
            }
        }
        return true;
    }
}
