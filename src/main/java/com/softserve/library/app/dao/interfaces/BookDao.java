package com.softserve.library.app.dao.interfaces;

import com.softserve.library.app.dto.BookDto;
import com.softserve.library.app.dto.CopyDto;
import com.softserve.library.app.http.CustomResponseEntity;
import com.softserve.library.app.model.Book;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * @author Roman Berezhnov
 */
public interface BookDao extends SimpleCrudDao<Book, BookDto> {

    List<BookDto> getAll() throws SQLException;

    int getAllAvailableByBookId(int id) throws SQLException;

    List<BookDto> getAllBooksByAuthor(String authorName) throws SQLException;

    int getBookQuantityPublishedFromYear(int year) throws SQLException;

    int getNumberOfOverallBookUsages(int bookId) throws SQLException;

    int getNumberOfBookUsagesByCopy(int copyId) throws SQLException;

    int getAverageReadingTime(int bookId) throws SQLException;

    // TODO: most popular/unpopular within period
//    int getMostPopularBookWithinPeriod(Date periodStartDate, Date periodEndDate) throws SQLException;

//    int getMostUnopularBookWithinPeriod(Date periodStartDate, Date periodEndDate) throws SQLException;

    List<CopyDto> getAllCopiesByBookName(String bookName) throws SQLException;
}
