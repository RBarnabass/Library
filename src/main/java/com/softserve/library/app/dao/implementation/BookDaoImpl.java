package com.softserve.library.app.dao.implementation;

import com.softserve.library.app.config.DBConnectivity;
import com.softserve.library.app.dao.interfaces.BookDao;
import com.softserve.library.app.enums.tables.BookColumns;
import com.softserve.library.app.model.Author;
import com.softserve.library.app.model.Book;
import com.softserve.library.app.model.Publisher;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Roman Berezhnov
 */
public class BookDaoImpl implements BookDao {

    private boolean isSuccess;

    private List<Book> getAllByOption(String options) throws SQLException {

        LinkedList<Book> list = new LinkedList<>();

        String sql = "SELECT * FROM book JOIN publisher ON book.publisher_id = publisher.id " +
                "JOIN book_authors ON book.id = book_authors.book_id " +
                "JOIN author ON book_authors.author_id = author.id " + options;

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(sql);
        preparedStatement.executeQuery();
        ResultSet resultSet = preparedStatement.getResultSet();

        Book book;
        Publisher publisher;
        Author author;

        while (resultSet.next()) {

            book = new Book();
            book.setId(resultSet.getInt(BookColumns.ID.getColumn()));
            book.setName(resultSet.getString(BookColumns.NAME.getColumn()));
            book.setPublishYear(resultSet.getInt(BookColumns.PUBLISH_YEAR.getColumn()));

            publisher = new Publisher();
            publisher.setId(resultSet.getInt(BookColumns.PUBLISHER_ID.getColumn()));
            publisher.setName(resultSet.getString("publisher.name"));

            author = new Author();
            author.setId(resultSet.getInt("author.id"));
            author.setName(resultSet.getString("author.full_name"));
            author.setPrimary(resultSet.getBoolean("is_primary"));
            book.setPublisher(publisher);

            if (list.contains(book)) {
                list.getLast().getAuthors().add(author);
            } else {
                book.setAuthors(new ArrayList<>());
                book.getAuthors().add(author);
                list.add(book);
            }
        }

        resultSet.close();
        preparedStatement.close();

        return list;
    }

    private String wrapper(String parameter) {

        return "'" + parameter + "'";
    }

    @Override
    public List<Book> getAllBooks() throws SQLException {

        return getAllByOption("");
    }

    @Override
    public List<Book> getAllByPublisher(String publisher) throws SQLException {

        return getAllByOption("WHERE publisher.name=" + wrapper(publisher));
    }

    @Override
    public List<Book> getAllByPublishYearPeriod(int start, int end) throws SQLException {

        return getAllByOption("WHERE book.publish_year BETWEEN " + start + " AND " + end);
    }

    @Override
    public List<Book> getAllByAuthor(String author) throws SQLException {

        return getAllByOption("WHERE author.full_name=" + wrapper(author));
    }

    @Override
    public List<Book> getAllByBookName(String bookName) throws SQLException {

        return getAllByOption("WHERE book.name=" + wrapper(bookName));
    }

    @Override
    public List<Book> getAllByBookNameAndPublisher(String bookName, String publisher) throws SQLException {

        return getAllByOption("WHERE book.name=" + wrapper(bookName) + " AND " + "publisher.name=" + wrapper(publisher));
    }

    @Override
    public List<Book> getAllByBookNameAndYearPeriod(String bookName, int start, int end) throws SQLException {

        return getAllByOption("WHERE book.name=" + wrapper(bookName) + " AND book.publish_year BETWEEN " + start + " AND " + end);
    }

    @Override
    public List<Book> getAllByBookNameAndAuthor(String bookName, String author) throws SQLException {

        return getAllByOption("WHERE book.name=" + wrapper(bookName) + " AND author.full_name=" + wrapper(author));
    }

    @Override
    public List<Book> getAllByBookNameAndPublisherAndYearPeriod(String bookName, String publisher, int start, int end) throws SQLException {

        return getAllByOption("WHERE book.name=" + wrapper(bookName) + " AND publisher.name=" + wrapper(publisher) + " AND book.publish_year BETWEEN " + start + " AND " + end);
    }

    @Override
    public List<Book> getAllByBookNameAndPublisherAndAuthor(String bookName, String publisher, String author) throws SQLException {

        return getAllByOption("WHERE book.name=" + wrapper(bookName) + " AND publisher.name=" + wrapper(publisher) + " AND author.full_name=" + wrapper(author));
    }

    @Override
    public List<Book> getAllByBookNameAndYearPeriodAndAuthor(String bookName, int start, int end, String author) throws SQLException {

        return getAllByOption("WHERE book.name=" + wrapper(bookName) + " AND author.full_name=" + wrapper(author) + " AND book.publish_year BETWEEN " + start + " AND " + end);
    }

    @Override
    public List<Book> getAllByBookNameAndPublisherAndYearPeriodAndAuthor(String bookName, String publisher, int start, int end, String author) throws SQLException {

        return getAllByOption("WHERE book.name=" + wrapper(bookName) + " AND publisher.name=" + wrapper(publisher) + " AND author.full_name=" + wrapper(author) + " AND book.publish_year BETWEEN " + start + " AND " + end);
    }

    @Override
    public List<Book> getAllByPublisherAndYearPeriod(String publisher, int start, int end) throws SQLException {

        return getAllByOption("WHERE publisher.name=" + wrapper(publisher) + " AND book.publish_year BETWEEN " + start + " AND " + end);
    }

    @Override
    public List<Book> getAllByPublisherAndAuthor(String publisher, String author) throws SQLException {

        return getAllByOption("WHERE publisher.name=" + wrapper(publisher) + " AND author.full_name=" + wrapper(author));
    }

    @Override
    public List<Book> getAllByPublisherAndYearPeriodAndAuthor(String publisher, int start, int end, String author) throws SQLException {

        return getAllByOption("WHERE publisher.name=" + wrapper(publisher) + " AND author.full_name=" + wrapper(author) + " AND book.publish_year BETWEEN " + start + " AND " + end);
    }

    @Override
    public List<Book> getAllByYearPeriod(int start, int end) throws SQLException {

        return getAllByOption("WHERE book.publish_year BETWEEN " + start + " AND " + end);
    }

    @Override
    public List<Book> getAllByYearPeriodAndAuthor(int start, int end, String author) throws SQLException {

        return getAllByOption("WHERE author.full_name=" + wrapper(author) + " AND book.publish_year BETWEEN " + start + " AND " + end);
    }

    @Override
    public int addBookAndGetIdBack(Book book) throws SQLException {

        String sql = "INSERT INTO book (book.name, book.publish_year, book.publisher_id) VALUES(?,?,(SELECT id FROM publisher WHERE publisher.name=?))";

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, book.getName());
        preparedStatement.setInt(2, book.getPublishYear());
        preparedStatement.setString(3, book.getPublisher().getName());
        isSuccess = preparedStatement.executeUpdate() > 0;

        if (isSuccess) {

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            return resultSet.getInt(1);
        }

        return 0;
    }

    @Override
    public Book get(int id) throws SQLException {

        List<Book> list = getAllByOption("WHERE book.id=" + id);

        if (list != null) {
            return list.get(0);
        }

        return null;
    }

    @Override
    public boolean add(Book book) throws SQLException {

        return addBookAndGetIdBack(book) >= 1;
    }

    @Override
    public boolean delete(int id) throws SQLException {

        // todo: implement me !!!
        return false;
    }

    @Override
    public boolean update(Book book) throws SQLException {

        // todo: implement me !!!
        return false;
    }

}
