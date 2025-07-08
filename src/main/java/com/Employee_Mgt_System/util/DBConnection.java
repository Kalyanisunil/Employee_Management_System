package com.Employee_Mgt_System.util;


import java.sql.*;

public class DBConnection {

    private static final String URL      = "jdbc:mysql://127.0.0.1:3306/ems";
    private static final String USER     = "root";
    private static final String PASSWORD = "root!";

        // Load MySQL JDBC driver
//        Class.forName("com.mysql.cj.jdbc.Driver");

        // Connect to database
       public static Connection getConnection()
        {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");              // load driver
                return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ems","root","root!");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
    }