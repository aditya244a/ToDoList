package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtil {

    private static final String JDBC_URL = "jdbc:h2:~/todo_db;";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "";

    static {
        try {
            createDatabaseAndTable();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize the database", e);
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to the database", e);
        }
    }

    private static void createDatabaseAndTable() throws SQLException {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {

            // Create table if it does not exist
            String createTableQuery = "CREATE TABLE IF NOT EXISTS todos (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "title VARCHAR(255) NOT NULL, " +
                    "description TEXT, " +
                    "status ENUM('PENDING', 'COMPLETED') DEFAULT 'PENDING', " +
                    "created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP)";
            statement.executeUpdate(createTableQuery);
        }
    }
}
