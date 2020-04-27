package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

    public static void main(String[] args){
        String jdbcURL = "jdbc:mysql://localhost:8000/hb_student_tracker?useSSL=false&serverTimezone=UTC";
        String user = "hbstudent";
        String password = "hbstudent";
        try {
            System.out.println("Connecting to database: " + jdbcURL);
            Connection connection = DriverManager.getConnection(jdbcURL, user, password);
            System.out.println("Connection succesful!");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
