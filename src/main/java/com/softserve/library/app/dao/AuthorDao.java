package com.softserve.library.app.dao;

import com.softserve.library.app.config.DBConnection;
import com.softserve.library.app.entity.Author;
import com.softserve.library.app.tables.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class AuthorDao implements IDaoCRUD<Author> {
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Statement statement;

    @Override
    public Author get(int id) throws SQLException {
        Author author;
        List<Author> list = new ArrayList<>();
        String selectWhereId = "SELECT * FROM" + Tables.AUTHOR.getTable() + " WHERE id=";

        preparedStatement = DBConnection.getConnection().prepareStatement(selectWhereId + id);
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            author = new Author();
            author.setId(resultSet.getInt(AuthorColumns.ID.getColumn()));
            author.setName(resultSet.getString(AuthorColumns.FULL_NAME.getColumn()));
            list.add(author);
        }
        return list.get(0);
    }

    @Override
    public List<Author> getAll() throws SQLException {
        Author author;
        List<Author> authorList = new ArrayList<>();

        String selectAll = "SELECT * FROM "+Tables.AUTHOR.getTable();
        Statement statement = DBConnection.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(selectAll);

        while (resultSet.next()) {
            author = new Author();
            author.setId(resultSet.getInt(AuthorColumns.ID.getColumn()));
            author.setName(resultSet.getString(AuthorColumns.FULL_NAME.getColumn()));
            authorList.add(author);
        }
        return authorList;
    }


    @Override
    public boolean add(Author author) throws SQLException {
        String insert = "INSERT INTO " + Tables.AUTHOR.getTable() + "(" + AuthorColumns.FULL_NAME.getColumn() + ")" + "VALUE(?)";
        preparedStatement = DBConnection.getConnection().prepareStatement(insert);
        preparedStatement.setString(1, author.getName());
        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean update(Author author) throws SQLException {
        String update = "UPDATE " + Tables.PUBLISHER.getTable() + " SET " + AuthorColumns.FULL_NAME.getColumn() + "=? WHERE id=?";
        preparedStatement = DBConnection.getConnection().prepareStatement(update);
        preparedStatement.setString(1, author.getName());
        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        String deletion = "DELETE FROM " + Tables.AUTHOR.getTable() + " WHERE id=" + id;
        statement = DBConnection.getConnection().createStatement();
        return statement.executeUpdate(deletion) > 0;
    }
}
