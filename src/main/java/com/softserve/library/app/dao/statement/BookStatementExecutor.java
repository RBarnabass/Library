package com.softserve.library.app.dao.statement;

import com.softserve.library.app.config.DBConnectivity;
import com.softserve.library.app.dto.BookDto;
import com.softserve.library.app.dto.CopyDto;
import com.softserve.library.app.enums.sql.BookSQL;
import com.softserve.library.app.enums.tables.AuthorColumns;
import com.softserve.library.app.enums.tables.BookColumns;
import com.softserve.library.app.enums.tables.PublisherColumns;
import com.softserve.library.app.model.Book;
import com.softserve.library.app.model.Publisher;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Roman Berezhnov
 */
public class BookStatementExecutor {

    private boolean isSuccess;

    // Simple crud
    public List<Book> get(int id) throws SQLException {

        List<Book> list = new ArrayList<>();

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(BookSQL.SELECT.getSQL() + scopesWrapper(id));
        preparedStatement.executeQuery();
        ResultSet set = preparedStatement.getResultSet();

        Book book;
        Publisher publisher;

        while (set.next()) {

            book = new Book();
            book.setId(set.getInt(BookColumns.ID.getColumn()));
            book.setName(set.getString(BookColumns.NAME.getColumn()));
            book.setPublishYear(set.getInt(BookColumns.PUBLISH_YEAR.getColumn()));

            publisher = new Publisher();
            publisher.setId(set.getInt(BookColumns.PUBLISHER_ID.getColumn()));
            publisher.setName(set.getString(PublisherColumns.NAME.getColumn()));

            book.setPublisher(publisher);
            list.add(book);
        }

        set.close();
        preparedStatement.close();

        return list;
    }

    // Book list for page
    public List<BookDto> getAll() throws SQLException {

        LinkedList<BookDto> list = new LinkedList<>();

        // todo: remove sql to constant or enum !
        String sql = "SELECT book.id, book.name, book.publish_year, publisher.name, author.full_name FROM book\n" +
                "  JOIN publisher\n" +
                "    ON book.publisher_id = publisher.id\n" +
                "      JOIN book_authors\n" +
                "        ON book.id = book_authors.book_id\n" +
                "          JOIN author\n" +
                "            ON book_authors.author_id = author.id\n" +
                "               ORDER BY book.name";

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(sql);
        preparedStatement.executeQuery();
        ResultSet set = preparedStatement.getResultSet();

        BookDto bookDto;

        while (set.next()) {

            bookDto = new BookDto();
            bookDto.setBookId(set.getInt(BookColumns.ID.getColumn()));
            bookDto.setBookName(set.getString(BookColumns.NAME.getColumn()));
            bookDto.setPublishYear(set.getInt(BookColumns.PUBLISH_YEAR.getColumn()));
            bookDto.setPublisherName(set.getString(PublisherColumns.NAME.getColumn()));
            bookDto.setPrimaryAuthor(set.getString(AuthorColumns.FULL_NAME.getColumn()));

            if (list.contains(bookDto)) {

                BookDto book = list.getLast();
                book.setCoAuthor(set.getString(AuthorColumns.FULL_NAME.getColumn()));

            } else {
                list.add(bookDto);
            }
        }

        set.close();
        preparedStatement.close();

        return list;
    }

    // Task 1 - id we will get from book list on the client side (some button by each book)
    public int getAllAvailable(int id) throws SQLException {

        List<Boolean> list = new ArrayList<>();

        // todo: remove sql from here !!!

        String sql = "SELECT copy.is_available FROM copy\n" +
                "       JOIN book\n" +
                "           ON copy.book_id = book.id\n" +
                "            WHERE book_id = " + id + " and is_available = true;";

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(sql);
        preparedStatement.executeQuery();
        ResultSet set = preparedStatement.getResultSet();

        while (set.next()) {

            list.add(set.getBoolean("copy.is_available"));
        }

        set.close();
        preparedStatement.close();

        return list.size();
    }

    // Task 2 - Dto fields with authors can have wrong sing, so you must check isPrimary method for correct author position !
    public List<BookDto> getAllByAuthor(String authorName) throws SQLException {

        List<BookDto> list = new ArrayList<>();

        // todo: remove SQL !!!

        String sql = "SELECT book.id, book.name, book.publish_year, publisher.name, author.full_name, book_authors.is_primary FROM book\n" +
                "  JOIN publisher\n" +
                "    ON book.publisher_id = publisher.id\n" +
                "      JOIN book_authors\n" +
                "        ON book.id = book_authors.book_id\n" +
                "          JOIN author\n" +
                "            ON book_authors.author_id = author.id\n" +
                "              WHERE author.full_name =" + "'" + authorName + "'\n" +
                "               ORDER BY book.name";

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(sql);
        preparedStatement.executeQuery();
        ResultSet set = preparedStatement.getResultSet();

        BookDto bookDto;

        while (set.next()) {

            bookDto = new BookDto();
            bookDto.setBookId(set.getInt(BookColumns.ID.getColumn()));
            bookDto.setBookName(set.getString(BookColumns.NAME.getColumn()));
            bookDto.setPublishYear(set.getInt(BookColumns.PUBLISH_YEAR.getColumn()));
            bookDto.setPublisherName(set.getString(PublisherColumns.NAME.getColumn()));
            bookDto.setPrimaryAuthor(set.getString(AuthorColumns.FULL_NAME.getColumn()));
            bookDto.setPrimary(set.getBoolean("book_by_authors.is_primary"));

            list.add(bookDto);
        }

        set.close();
        preparedStatement.close();

        return list;

    }

    // Task 4 - Not sure about quantity, maybe better return list of books?)
    public int getAllBooksPublishedFromYear(int year) throws SQLException {

        if (year < 0 || year > 2100) {
            return 0;
        }

        int quantity = 0;

        String sql = "SELECT COUNT(b.id) AS quantity FROM book AS b\n" +
                "  WHERE b.publish_year >=" + "'" + year + "'";

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(sql);
        preparedStatement.executeQuery();
        ResultSet resultSet = preparedStatement.getResultSet();

        while (resultSet.next()) {

            quantity = resultSet.getInt("quantity");
        }

        resultSet.close();
        preparedStatement.close();

        return quantity;
    }

    public int getNumberOfOverallBookUsages(int bookId) throws SQLException {

        String sql = "SELECT COUNT(b.id) AS bookUsages\n" +
                "FROM time_period AS tp\n" +
                "  JOIN copy AS c ON tp.copy_id = c.id\n" +
                "  JOIN book AS b  ON c.book_id = b.id\n" +
                "WHERE b.id =" + bookId;

        int bookUsages = 0;

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(sql);
        preparedStatement.executeQuery();
        ResultSet resultSet = preparedStatement.getResultSet();

        while (resultSet.next()) {

            bookUsages = resultSet.getInt("bookUsages");
        }

        resultSet.close();
        preparedStatement.close();

        return bookUsages;
    }

    public int getNumberOfBookUsagesByCopy(int copyId) throws SQLException {

        String sql = "SELECT COUNT(copy.id) AS copyUsages\n" +
                "FROM time_period\n" +
                "  JOIN copy\n" +
                "    ON time_period.copy_id = copy.id\n" +
                "WHERE copy_id = " + copyId;

        int copyUsages = 0;

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(sql);
        preparedStatement.executeQuery();
        ResultSet resultSet = preparedStatement.getResultSet();

        while (resultSet.next()) {

            copyUsages = resultSet.getInt("copyUsages");
        }

        resultSet.close();
        preparedStatement.close();

        return copyUsages;
    }

    public int getAverageReadingTime(int bookId) throws SQLException {

        String sql = "SELECT (FLOOR(SUM(DATEDIFF(tp.return_date, tp.start_date)) / COUNT(c.id))) AS avgReadingTimeInDays\n" +
                "FROM book AS b\n" +
                "  JOIN copy AS c ON c.book_id = b.id\n" +
                "  JOIN time_period AS tp ON c.id = tp.copy_id\n" +
                "WHERE tp.return_date IS NOT NULL AND b.id = " + bookId;

        int avgReadingTimeInDays = 0;

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(sql);
        preparedStatement.executeQuery();
        ResultSet resultSet = preparedStatement.getResultSet();

        while (resultSet.next()) {

            avgReadingTimeInDays = resultSet.getInt("avgReadingTimeInDays");
        }

        resultSet.close();
        preparedStatement.close();

        return avgReadingTimeInDays;
    }

    public List<CopyDto> getAllCopiesByBookName(String bookName) throws SQLException {

        String sql = "SELECT\n" +
                "  copy.id           AS copyId,\n" +
                "  book.id           AS bookId,\n" +
                "  copy.is_available AS isAvailable\n" +
                "FROM copy\n" +
                "  JOIN book on copy.book_id = book.id\n" +
                "WHERE book.name = " + "'" + bookName + "'";

        List<CopyDto> copies = new ArrayList<>();

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(sql);
        preparedStatement.executeQuery();
        ResultSet set = preparedStatement.getResultSet();

        CopyDto copyDto;

        while (set.next()) {

            copyDto = new CopyDto();
            copyDto.setCopyId(set.getInt("copyId"));
            copyDto.setBookId(set.getInt("bookId"));
            copyDto.setIsAvailable(set.getBoolean("isAvailable"));

            copies.add(copyDto);
        }

        set.close();
        preparedStatement.close();

        return copies;
    }

    // TODO: getMostPopularBookWithinPeriod
    int getMostPopularBookWithinPeriod(Date periodStartDate, Date periodEndDate) throws SQLException {

        return 0;
    }

    // TODO getMostUnopularBookWithinPeriod
    int getMostUnopularBookWithinPeriod(Date periodStartDate, Date periodEndDate) throws SQLException {

        return 0;
    }

    private String scopesWrapper(int id) {

        return "'" + id + "'";
    }
}