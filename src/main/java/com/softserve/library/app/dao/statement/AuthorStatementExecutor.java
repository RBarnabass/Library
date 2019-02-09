package com.softserve.library.app.dao.statement;

import com.softserve.library.app.config.DBConnectivity;
import com.softserve.library.app.enums.sql.AuthorSQL;
import com.softserve.library.app.enums.tables.AuthorColumns;
import com.softserve.library.app.model.Author;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorStatementExecutor {

    public Author get(int id) throws SQLException {

        List<Author> list = new ArrayList<>();

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(AuthorSQL.SELECT.getSQL() + scopesWrapper(id));
        ResultSet set = preparedStatement.executeQuery();
        Author author;

        while (set.next()) {

            author = new Author();
            author.setId(set.getInt(AuthorColumns.ID.getColumn()));
            author.setName(set.getString(AuthorColumns.FULL_NAME.getColumn()));
            list.add(author);
        }

        return list.get(0);
    }
    public boolean add(Author author) throws SQLException {

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(AuthorSQL.INSERT.getSQL());
        preparedStatement.setString(1, author.getName());

        return preparedStatement.executeUpdate() > 0;
    }
    public boolean delete(int id) throws SQLException {

        Statement statement = DBConnectivity.getConnection().createStatement();

        return statement.executeUpdate(AuthorSQL.DELETE.getSQL() + scopesWrapper(id)) > 0;
    }
    public boolean update(Author author) throws SQLException {

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(AuthorSQL.UPDATE.getSQL());
        preparedStatement.setString(1, author.getName());
        preparedStatement.setInt(2, author.getId());

        return preparedStatement.executeUpdate() > 0;
    }

    private String scopesWrapper(int id) {

        return "'" + id + "'";
    }
}
