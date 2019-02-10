package com.softserve.library.app.config;

import com.softserve.library.app.enums.DBConstants;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 *
 * @author Roman Berezhnov
 */
public class DBConnectivity {

    private static Connection connection;

    public static Connection getConnection() throws SQLException {

        if (connection == null) {
            connection = initConnection();
        }

        return connection;
    }
    public static void closeConnection() {

        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection initConnection() throws SQLException {

        Driver driver = new com.mysql.cj.jdbc.Driver();
        DriverManager.registerDriver(driver);

        String url = DBConstants.PATH.getValue()
                + DBConstants.HOST.getValue()
                + DBConstants.PORT.getValue()
                + DBConstants.BASE.getValue();

        return connection = DriverManager.getConnection(url, DBConstants.LOGIN.getValue(), DBConstants.PASSWORD.getValue());
    }
}
