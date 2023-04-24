package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    private static Connection connection;
    private static final String url = "jdbc:mariadb://localhost:3306/PruebaPool";
    private static final String user = "root";
    private static final String password = "edgar";

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}