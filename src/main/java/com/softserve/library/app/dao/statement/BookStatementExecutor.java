package com.softserve.library.app.dao.statement;

import com.softserve.library.app.config.DBConnectivity;
import com.softserve.library.app.dto.BookDto;
import com.softserve.library.app.enums.sql.BookSQL;
import com.softserve.library.app.enums.tables.AuthorColumns;
import com.softserve.library.app.enums.tables.BookColumns;
import com.softserve.library.app.enums.tables.PublisherColumns;
import com.softserve.library.app.model.Author;
import com.softserve.library.app.model.Book;
import com.softserve.library.app.model.Publisher;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author Roman Berezhnov
 */
public class BookStatementExecutor {

    private boolean isSuccess;

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

        return list;
    }
    public List<BookDto> getAll() throws SQLException {

        List<BookDto> list = new ArrayList<>();

        String sql = "SELECT book.id, book.name, book.publish_year, publisher.name, author.full_name FROM book\n" +
                "  JOIN publisher\n" +
                "    ON book.publisher_id = publisher.id\n" +
                "      JOIN book_by_authors\n" +
                "        ON book.id = book_by_authors.book_id\n" +
                "          JOIN author\n" +
                "            ON book_by_authors.author_id = author.id\n" +
                "              WHERE book_by_authors.is_primary = true";

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(sql);
        preparedStatement.executeQuery();
        ResultSet set = preparedStatement.getResultSet();

        BookDto bookDto;

        while (set.next()) {

            bookDto = new BookDto();
            bookDto.setId(set.getInt(BookColumns.ID.getColumn()));
            bookDto.setBookName(set.getString(BookColumns.NAME.getColumn()));
            bookDto.setPublishYear(set.getInt(BookColumns.PUBLISH_YEAR.getColumn()));

            bookDto.setPublisherName(set.getString(PublisherColumns.NAME.getColumn()));

            bookDto.setPrimaryAuthor(set.getString(AuthorColumns.FULL_NAME.getColumn()));

            list.add(bookDto);
        }

        return list;

    }
    public List<Boolean> getAllAvailable(int id) throws SQLException {

        List<Boolean> list = new ArrayList<>();

        String sql = "SELECT copy.is_available FROM copy\n" +
                "  JOIN book\n" +
                "    ON copy.book_id = book.id\n" +
                "      WHERE book_id = "+ id +" and is_available = true;";

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(sql);
        preparedStatement.executeQuery();
        ResultSet set = preparedStatement.getResultSet();

        while (set.next()) {

            list.add(set.getBoolean("copy.is_available"));
        }

        return list;
    }
    public List<BookDto> getAllByAuthor(String authorName) throws SQLException {

        List<BookDto> list = new ArrayList<>();

        String sql = "SELECT book.id, book.name, book.publish_year, publisher.name, author.full_name, book_by_authors.is_primary FROM book\n" +
                "  JOIN publisher\n" +
                "    ON book.publisher_id = publisher.id\n" +
                "      JOIN book_by_authors\n" +
                "        ON book.id = book_by_authors.book_id\n" +
                "          JOIN author\n" +
                "            ON book_by_authors.author_id = author.id\n" +
                "              WHERE author.full_name =" + "'" + authorName + "'";

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(sql);
        preparedStatement.executeQuery();
        ResultSet set = preparedStatement.getResultSet();

        BookDto bookDto;

        while (set.next()) {

            bookDto = new BookDto();
            bookDto.setId(set.getInt(BookColumns.ID.getColumn()));
            bookDto.setBookName(set.getString(BookColumns.NAME.getColumn()));
            bookDto.setPublishYear(set.getInt(BookColumns.PUBLISH_YEAR.getColumn()));

            bookDto.setPublisherName(set.getString(PublisherColumns.NAME.getColumn()));

            bookDto.setPrimaryAuthor(set.getString(AuthorColumns.FULL_NAME.getColumn()));

            bookDto.setPrimary(set.getBoolean("book_by_authors.is_primary"));

            list.add(bookDto);
        }

        return list;

    }

    private String scopesWrapper(int id) {

        return "'" + id + "'";
    }
}
