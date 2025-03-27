package com.learning.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBaseData {
    private static String url = "jdbc:mysql://localhost:3306/java_course";
    private static String username = "root";
    private static String password = "password";
    private static Connection connection;

    public static Connection getInstance() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}
