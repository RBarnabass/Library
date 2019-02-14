package com.softserve.library.app.dao.implementation;

import com.softserve.library.app.dao.interfaces.BookDao;
import com.softserve.library.app.dao.statement.BookStatementExecutor;
import com.softserve.library.app.dto.BookDto;
import com.softserve.library.app.model.Book;
import java.sql.SQLException;
import java.util.List;

/**
 *
 *
 * @author Roman Berezhnov
 */
public class BookDaoImpl implements BookDao {

    private final BookStatementExecutor bookStatementExecutor = new BookStatementExecutor();

    @Override public Book get(int id) throws SQLException {

        List<Book> list = bookStatementExecutor.get(id);

        return list.size() > 1 ? null : list.get(0);
    }
    @Override public List<BookDto> getAll() throws SQLException {

        return bookStatementExecutor.getAll();
    }
    @Override public List<Boolean> getAllAvailable() throws SQLException {

        return bookStatementExecutor.getAllAvailable();
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
