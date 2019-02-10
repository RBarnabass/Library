package com.softserve.library.app.dao;

import com.softserve.library.app.config.DBConnection;
import com.softserve.library.app.entity.Book;
import com.softserve.library.app.tables.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class BookDao implements IDaoCRUD<Book> {
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Statement statement;

    @Override
    public Book get(int id) throws SQLException {
        Book book;
        List<Book> list = new ArrayList<>();
        String selectWhereId = "SELECT * FROM" + Tables.BOOK.getTable() + " WHERE id=";

        preparedStatement = DBConnection.getConnection().prepareStatement(selectWhereId + id);
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            book = new Book();
            book.setId(resultSet.getInt(BookColumns.ID.getColumn()));
            book.setTitle(resultSet.getString(BookColumns.TITLE.getColumn()));
            book.setAuthorId(resultSet.getInt(BookColumns.AUTHOR_ID.getColumn()));
            book.setPublisherId(resultSet.getInt(BookColumns.PUBLISHER_ID.getColumn()));
            book.setPublishYear(resultSet.getInt(BookColumns.PUBLISH_YEAR.getColumn()));
            list.add(book);
        }
        return list.get(0);
    }

    @Override
    public List<Book> getAll() throws SQLException {
        Book book;
        List<Book> list = new ArrayList<>();
        String selectWhereId = "SELECT * FROM" + Tables.BOOK.getTable();

        preparedStatement = DBConnection.getConnection().prepareStatement(selectWhereId);
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            book = new Book();
            book.setId(resultSet.getInt(BookColumns.ID.getColumn()));
            book.setTitle(resultSet.getString(BookColumns.TITLE.getColumn()));
            book.setAuthorId(resultSet.getInt(BookColumns.AUTHOR_ID.getColumn()));
            book.setPublisherId(resultSet.getInt(BookColumns.PUBLISHER_ID.getColumn()));
            book.setPublishYear(resultSet.getInt(BookColumns.PUBLISH_YEAR.getColumn()));
            list.add(book);
        }
        return list;
    }

    @Override
    public boolean add(Book book) throws SQLException {
        String insert = "INSERT INTO " + Tables.BOOK.getTable() + "(" + BookColumns.TITLE.getColumn() + ", "
                + BookColumns.AUTHOR_ID.getColumn() + ", "
                + BookColumns.PUBLISHER_ID.getColumn() + ", "
                + BookColumns.PUBLISH_YEAR.getColumn() + ")" + "VALUE(?,?,?,?)";
        preparedStatement = DBConnection.getConnection().prepareStatement(insert);
        preparedStatement.setString(1, book.getTitle());
        preparedStatement.setInt(2, book.getAuthorId());
        preparedStatement.setInt(3, book.getPublisherId());
        preparedStatement.setInt(4, book.getPublishYear());
        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean update(Book book) throws SQLException {
        String update = "UPDATE " + Tables.PUBLISHER.getTable() + " SET " + BookColumns.TITLE.getColumn() + "=? WHERE id=?";
        preparedStatement = DBConnection.getConnection().prepareStatement(update);
        preparedStatement.setString(1, book.getTitle());
        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        String deletion = "DELETE FROM " + Tables.BOOK.getTable() + " WHERE id=" + id;
        statement = DBConnection.getConnection().createStatement();
        return statement.executeUpdate(deletion) > 0;
    }

}
