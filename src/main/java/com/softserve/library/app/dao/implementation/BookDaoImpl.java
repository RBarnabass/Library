package com.softserve.library.app.dao.implementation;

import com.softserve.library.app.dao.interfaces.BookDao;
import com.softserve.library.app.dao.statement.BookStatementExecutor;
import com.softserve.library.app.dto.BookDto;
import com.softserve.library.app.dto.CopyDto;
import com.softserve.library.app.model.Book;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * @author Roman Berezhnov
 */
public class BookDaoImpl implements BookDao {

    private final BookStatementExecutor bookStatementExecutor = new BookStatementExecutor();

    @Override
    public Book get(int id) throws SQLException {

        List<Book> list = bookStatementExecutor.get(id);

        return list.size() > 1 ? null : list.get(0);
    }

    @Override
    public List<BookDto> getAll() throws SQLException {

        return bookStatementExecutor.getAll();
    }

    @Override
    public List<Boolean> getAllAvailableByBookId(int id) throws SQLException {

        return bookStatementExecutor.getAllAvailable(id);
    }

    @Override
    public List<BookDto> getAllBooksByAuthor(String authorName) throws SQLException {

        return bookStatementExecutor.getAllByAuthor(authorName);
    }

    @Override
    public int getBookQuantityPublishedFromYear(int year) throws SQLException {

        return bookStatementExecutor.getAllBooksPublishedFromYear(year);
    }

    @Override
    public int getNumberOfOverallBookUsages(int bookId) throws SQLException {

        return bookStatementExecutor.getNumberOfOverallBookUsages(bookId);
    }

    @Override
    public int getNumberOfBookUsagesByCopy(int copyId) throws SQLException {

        return bookStatementExecutor.getNumberOfBookUsagesByCopy(copyId);
    }

    @Override
    public int getAverageReadingTime(int bookId) throws SQLException {

        return bookStatementExecutor.getAverageReadingTime(bookId);
    }

//    @Override
//    public int getMostPopularBookWithinPeriod(Date periodStartDate, Date periodEndDate) throws SQLException {
//        return 0;
//    }
//
//    @Override
//    public int getMostUnopularBookWithinPeriod(Date periodStartDate, Date periodEndDate) throws SQLException {
//        return 0;
//    }

    @Override
    public List<CopyDto> getAllCopiesByBookName(String bookName) throws SQLException {
        return bookStatementExecutor.getAllCopiesByBookName(bookName);
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
