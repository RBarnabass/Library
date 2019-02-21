package com.softserve.library.app.dao.implementation;

import com.softserve.library.app.config.DBConnectivity;
import com.softserve.library.app.dao.interfaces.BookAuthorsDao;
import com.softserve.library.app.model.BookAuthors;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookAuthorsDaoImpl implements BookAuthorsDao {

    private boolean isSuccess;

    @Override
    public BookAuthors get(int id) throws SQLException {
        return null;
    }

    @Override
    public boolean add(BookAuthors bookAuthors) throws SQLException {

        String sql = "INSERT INTO book_authors (book_authors.book_id, book_authors.author_id, book_authors.is_primary) VALUES (?,?,?)";

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, bookAuthors.getBookId());
        preparedStatement.setInt(2, bookAuthors.getAuthorId());
        preparedStatement.setBoolean(3, bookAuthors.isPrimary());
        isSuccess = preparedStatement.executeUpdate() > 0;

        return isSuccess;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(BookAuthors bookAuthors) throws SQLException {
        return false;
    }
}
