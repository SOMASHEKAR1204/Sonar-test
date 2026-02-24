package com.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsecureAuthService {

    private static final String DB_PASSWORD = "admin123"; // ❌ Hardcoded secret

    public boolean login(String username, String password) {
        boolean isAuthenticated = false;
        String unusedVariable = "this is unused"; // ❌ Code smell

        try {
            Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test",
                "root",
                DB_PASSWORD
            );

            Statement statement = connection.createStatement();

            // ❌ SQL Injection vulnerability
            String query = "SELECT * FROM users WHERE username = '"
                    + username + "' AND password = '" + password + "'";

            statement.execute(query);
            isAuthenticated = true;

        } catch (Exception e) {
            // ❌ Empty catch block
        }

        return isAuthenticated;
    }
}
