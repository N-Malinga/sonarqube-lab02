package main.java.com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    // SECURITY ISSUE: Hardcoded credentials
    private String password = "admin123";

    public void findUser(String username) throws SQLException {

        String query = "SELECT * FROM users WHERE name = '" + username + "'";

        try (Connection conn = DriverManager.getConnection(
                     "jdbc:mysql://localhost/db", "root", password);
             Statement st = conn.createStatement()) {

            st.executeQuery(query);
        }
    }

    // SMELL: Unused method
    public void notUsed() {
        logger.info("I am never called");
    }

    public void deleteUser(String username) throws SQLException {

        String query = "DELETE FROM users WHERE name = '" + username + "'";

        try (Connection conn = DriverManager.getConnection(
                     "jdbc:mysql://localhost/db", "root", password);
             Statement st = conn.createStatement()) {

            st.execute(query);
        }
    }
}
