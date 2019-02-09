package com.softserve.library.app;

import com.softserve.library.app.config.DBConnectivity;
import com.softserve.library.app.model.Author;
import com.softserve.library.app.service.interfaces.AuthorService;
import com.softserve.library.app.service.implementation.AuthorServiceImpl;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        AuthorService authorService = new AuthorServiceImpl();
        Author author;
        author = authorService.get(14);






        DBConnectivity.closeConnection();
    }
}
