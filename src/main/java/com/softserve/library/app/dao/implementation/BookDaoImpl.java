package com.softserve.library.app.dao.implementation;

import com.softserve.library.app.dao.interfaces.BookDao;
import com.softserve.library.app.dao.statement.BookStatementExecutor;
import com.softserve.library.app.model.Book;
import java.sql.SQLException;

public class BookDaoImpl implements BookDao {

    private final BookStatementExecutor bookStatementExecutor = new BookStatementExecutor();

    @Override public Book get(int id) throws SQLException {

        return bookStatementExecutor.get(id);
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
