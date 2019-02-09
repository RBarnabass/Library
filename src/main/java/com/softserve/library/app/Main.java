package com.softserve.library.app;

import com.softserve.library.app.config.DBConnectivity;
import com.softserve.library.app.model.Author;
import com.softserve.library.app.service.interfaces.AuthorService;
import com.softserve.library.app.service.implementation.AuthorServiceImpl;

public class Main {

    public static void main(String[] args) {

        AuthorService authorService = new AuthorServiceImpl();
        

        DBConnectivity.closeConnection();
    }
}
