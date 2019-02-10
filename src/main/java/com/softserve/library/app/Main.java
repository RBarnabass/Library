package com.softserve.library.app;

import com.softserve.library.app.config.DBConnectivity;
import com.softserve.library.app.model.Author;
import com.softserve.library.app.service.factory.ServiceFactory;
import com.softserve.library.app.service.factory.ServiceFactoryImpl;
import com.softserve.library.app.service.interfaces.AuthorService;

import java.sql.SQLException;

/**
 *
 *
 * @author Roman Berezhnov
 */
public class Main {

    public static void main(String[] args) throws SQLException {

        Author author = new Author("Factory");

        ServiceFactory serviceFactory = new ServiceFactoryImpl();
        AuthorService authorService = serviceFactory.getAuthorService();
        authorService.add(author);

        DBConnectivity.closeConnection();
    }
}
