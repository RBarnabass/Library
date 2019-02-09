package com.softserve.library.app.service.implementation;

import com.softserve.library.app.dao.implementation.BookDaoImpl;
import com.softserve.library.app.dao.interfaces.BookDao;
import com.softserve.library.app.model.Book;
import com.softserve.library.app.service.interfaces.BookService;
import java.sql.SQLException;

public class BookServiceImpl implements BookService {

    private final BookDao bookDao = new BookDaoImpl();

    @Override public Book get(int id) throws SQLException {

        return bookDao.get(id);
    }

    @Override
    public boolean add(Book book) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Book book) throws SQLException {
        return false;
    }
}
