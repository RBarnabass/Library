package com.softserve.library.app;

import com.softserve.library.app.config.DBConnectivity;
import com.softserve.library.app.dao.implementation.BookDaoImpl;
import com.softserve.library.app.dao.interfaces.BookDao;
import com.softserve.library.app.model.Author;
import com.softserve.library.app.model.Book;
import com.softserve.library.app.service.implementation.BookServiceImpl;
import com.softserve.library.app.service.interfaces.AuthorService;
import com.softserve.library.app.service.implementation.AuthorServiceImpl;
import com.softserve.library.app.service.interfaces.BookService;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        BookService bookService = new BookServiceImpl();
        Book book = bookService.get(5);
        System.out.println(book);





        DBConnectivity.closeConnection();
    }
}
