package com.java19.utils;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtil {

    private static final String DATE_PATTERN = "^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[012])-[0-9]{4}$";
    private static final Pattern pattern = Pattern.compile(DATE_PATTERN);
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

    public static boolean validateDate(final String date) {
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }

}
