package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static final String URL = "jdbc:mysql://localhost:3306/my_base";
    private static final String USER = "root";
    private static final String PASSWORD = "!@QWaszx12";

    public static Connection getConnection() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            return connection;
        } catch (SQLException e) {
            System.err.println("Не удалось загурзить");
            throw new RuntimeException(e);
        }
    }
}
