package com.java19.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {
    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection =  DriverManager.getConnection("jdbc:mysql://localhost:3307/crm_app",
                    "root",
                    "admin123");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error connect database" + e.getMessage());
        }

        return connection;
    }
}
