package com.softserve.library.app.dao.interfaces;

import com.softserve.library.app.model.Book;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Roman Berezhnov
 */
public interface BookDao extends SimpleCrudDao<Book> {

    List<Book> getAllBooks() throws SQLException;
    List<Book> getAllByPublisher(String publisher) throws SQLException;
    List<Book> getAllByPublishYearPeriod(int start, int end) throws SQLException;
    List<Book> getAllByAuthor(String author) throws SQLException;
    List<Book> getAllByBookName(String bookName) throws SQLException;
    List<Book> getAllByBookNameAndPublisher(String bookName, String publisher) throws SQLException;
    List<Book> getAllByBookNameAndYearPeriod(String bookName, int start, int end) throws SQLException;
    List<Book> getAllByBookNameAndAuthor(String bookName, String author) throws SQLException;
    List<Book> getAllByBookNameAndPublisherAndYearPeriod(String bookName, String publisher, int start, int end) throws SQLException;
    List<Book> getAllByBookNameAndPublisherAndAuthor(String bookName, String publisher, String author) throws SQLException;
    List<Book> getAllByBookNameAndYearPeriodAndAuthor(String bookName, int start, int end, String author) throws SQLException;
    List<Book> getAllByBookNameAndPublisherYearPeriodAndAuthor(String bookName, String publisher, int start, int end, String author) throws SQLException;
    List<Book> getAllByPublisherAndYearPeriod(String publisher, int start, int end) throws SQLException;
    List<Book> getAllByPublisherAndAuthor(String publisher, String author) throws SQLException;
    List<Book> getAllByPublisherAndYearPeriodAndAuthor(String publisher, int start, int end, String author) throws SQLException;
    List<Book> getAllByYearPeriod(int start, int end) throws SQLException;
    List<Book> getAllByYearPeriodAndAuthor(int start, int end, String author) throws SQLException;
    int addBook(Book book) throws SQLException;
}
