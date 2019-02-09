package com.softserve.library.app;

import com.softserve.library.app.config.DBConnectivity;
import com.softserve.library.app.service.interfaces.AuthorService;
import com.softserve.library.app.service.implementation.AuthorServiceImpl;

public class Main {

    public static void main(String[] args) {

        AuthorService authorService = new AuthorServiceImpl();
        authorService.delete(10);
        System.out.println("Hello");



        DBConnectivity.closeConnection();
    }
}
