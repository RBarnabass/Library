package com.softserve.library.app;

import com.softserve.library.app.config.DBConnectivity;
import com.softserve.library.app.dto.BookDto;
import com.softserve.library.app.model.Credential;
import com.softserve.library.app.model.User;
import com.softserve.library.app.service.factory.ServiceFactory;
import com.softserve.library.app.service.factory.ServiceFactoryImpl;
import com.softserve.library.app.service.interfaces.UserService;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

/**
 *
 *
 * @author Roman Berezhnov
 */
public class Main {

    public static void main(String[] args) throws SQLException {


        ServiceFactory serviceFactory = new ServiceFactoryImpl();
        List<Boolean> allAvailable = serviceFactory.getBookService().getAllAvailable();

        System.out.println(allAvailable);

        // Credential get

        /*ServiceFactory serviceFactory = new ServiceFactoryImpl();
        Credential roma = serviceFactory.getCredentialService().getByLogin("roma");
        System.out.println(roma);*/

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
