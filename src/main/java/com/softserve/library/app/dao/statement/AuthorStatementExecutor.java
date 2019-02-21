package com.softserve.library.app.dao.statement;

import com.softserve.library.app.config.DBConnectivity;
import com.softserve.library.app.enums.sql.AuthorSQL;
import com.softserve.library.app.enums.tables.AuthorColumns;
import com.softserve.library.app.model.Author;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author Roman Berezhnov
 */
public class AuthorStatementExecutor {

    private boolean isSuccess;

    public List<Author> getAllByOption(String option) throws SQLException {

        List<Author> list = new ArrayList<>();

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(AuthorSQL.SELECT.getSQL() + option);
        preparedStatement.execute();
        ResultSet set = preparedStatement.getResultSet();
        Author author = new Author();

        while (set.next()) {

            author.setId(set.getInt(AuthorColumns.ID.getColumn()));
            author.setName(set.getString(AuthorColumns.FULL_NAME.getColumn()));
            list.add(author);
        }

        set.close();
        preparedStatement.close();

        return list;
    }
    public boolean add(Author author) throws SQLException {

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(AuthorSQL.INSERT.getSQL());
        preparedStatement.setString(1, author.getName());
        isSuccess = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();

        return isSuccess;
    }
    public boolean delete(int id) throws SQLException {

        Statement statement = DBConnectivity.getConnection().createStatement();
        isSuccess = statement.executeUpdate(AuthorSQL.DELETE.getSQL() + scopesWrapper(id)) > 0;
        statement.close();

        return isSuccess;
    }
    public boolean update(Author author) throws SQLException {

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(AuthorSQL.UPDATE.getSQL());
        preparedStatement.setString(1, author.getName());
        preparedStatement.setInt(2, author.getId());
        isSuccess = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();

        return isSuccess;
    }

    private String scopesWrapper(int id) {

        return "'" + id + "'";
    }
}
