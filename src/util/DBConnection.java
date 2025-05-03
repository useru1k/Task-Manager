package util;

import java.sql.*;

public class DBConnection {
	// Database Url to Connect
	private static final String URL = "jdbc:mysql://localhost:8080/task_manager";
	// The user of the application default is root
    private static final String USER = "root";
    // Password of the user
    private static final String PASSWORD = "";
    
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
