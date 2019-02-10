package com.softserve.library.app.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;

    private static final String url = "jdbc:mysql://:3306/library";
    private static final String user = "root";
    private static final String password = "123ab";

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = initConnection();
        }
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection == null) {
            return;
        }
        connection.close();
    }

    private static Connection initConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}