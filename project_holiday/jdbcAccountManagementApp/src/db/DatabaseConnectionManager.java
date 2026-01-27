package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionManager {
    private String url = "";
    private String user = "";
    private String password = "";

    public DatabaseConnectionManager(DatabaseConfigProperties configProperties) {
        url = configProperties.getUrl();
        user = configProperties.getUsername();
        password = configProperties.getPassword();
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password)
                    ;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("Connection Failed! Check output console");
    }
}
