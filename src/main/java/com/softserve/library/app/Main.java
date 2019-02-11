package com.softserve.library.app;

import com.softserve.library.app.config.DBConnectivity;
import com.softserve.library.app.model.User;
import com.softserve.library.app.service.factory.ServiceFactory;
import com.softserve.library.app.service.factory.ServiceFactoryImpl;
import com.softserve.library.app.service.interfaces.UserService;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 *
 *
 * @author Roman Berezhnov
 */
public class Main {

    public static void main(String[] args) throws SQLException {








        // User add

        /*Calendar calendar = Calendar.getInstance();
        calendar.set(1989, Calendar.JULY, 13);
        Date date = new Date(calendar.getTime().getTime());
        System.out.println(date);
        User user = new User("Roman Berezhnov", date);
        user.setRegistrationDate(new Timestamp(new java.util.Date().getTime()));
        ServiceFactory serviceFactory = new ServiceFactoryImpl();
        UserService userService = serviceFactory.getUserService();
        userService.add(user);*/

        DBConnectivity.closeConnection();
    }
}
