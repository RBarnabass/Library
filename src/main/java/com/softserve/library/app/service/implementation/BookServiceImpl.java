package com.softserve.library.app.service.implementation;

import com.softserve.library.app.dao.implementation.BookDaoImpl;
import com.softserve.library.app.dao.interfaces.BookDao;
import com.softserve.library.app.dto.BookDto;
import com.softserve.library.app.model.Book;
import com.softserve.library.app.service.interfaces.BookService;
import java.sql.SQLException;
import java.util.List;

/**
 *
 *
 * @author Roman Berezhnov
 */
public class BookServiceImpl implements BookService {

    private final BookDao bookDao = new BookDaoImpl();

    @Override
    public boolean add(Book book) throws SQLException {

        //todo: implement me !
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {

        //todo: implement me !
        return false;
    }

    @Override
    public boolean update(Book book) throws SQLException {

        //todo: implement me !
        return false;
    }

    @Override public Book get(int id) throws SQLException {

        return bookDao.get(id);
    }
    @Override public List<BookDto> getAll() throws SQLException {

        return bookDao.getAll();
    }
    @Override public List<Boolean> getAllAvailableByBookId(int id) throws SQLException {

        return bookDao.getAllAvailableByBookId(id);
    }
    @Override public List<BookDto> getAllByAuthor(String authorName) throws SQLException {

        return bookDao.getAllBooksByAuthor(authorName);
    }
    @Override public int getBookQuantityPublishedFromYear(int year) throws SQLException {

        return bookDao.getBookQuantityPublishedFromYear(year);
    }
}
