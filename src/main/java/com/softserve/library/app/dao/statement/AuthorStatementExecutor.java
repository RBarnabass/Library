package com.softserve.library.app.dao.statement;

import com.softserve.library.app.config.DBConnectivity;
import com.softserve.library.app.enums.sql.AuthorSQL;
import com.softserve.library.app.enums.tables.AuthorColumns;
import com.softserve.library.app.model.Author;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorStatementExecutor {

    public Author get(int id) {

        List<Author> list = new ArrayList<>();

        try (PreparedStatement preparedStatement = DBConnectivity.getConnection()
                .prepareStatement(AuthorSQL.SELECT.getSQL() + scopesWrapper(id))) {

            ResultSet set = preparedStatement.executeQuery();
            Author author;

            while (set.next()) {

                author = new Author();
                author.setId(set.getInt(AuthorColumns.ID.getColumn()));
                author.setName(set.getString(AuthorColumns.FULL_NAME.getColumn()));
                list.add(author);
            }

        } catch (SQLException e) {

            e.printStackTrace();
            DBConnectivity.closeConnection();
        }

        return list.get(0);
    }
    public void add(Author author) {

        try (PreparedStatement preparedStatement = DBConnectivity.getConnection()
                .prepareStatement(AuthorSQL.INSERT.getSQL())) {

            preparedStatement.setString(1, author.getName());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();
            DBConnectivity.closeConnection();
        }
    }
    public void delete(int id) {

        try (Statement statement = DBConnectivity.getConnection().createStatement()) {

            statement.executeUpdate(AuthorSQL.DELETE.getSQL() + scopesWrapper(id));

        } catch (SQLException e) {

            e.printStackTrace();
            DBConnectivity.closeConnection();
        }
    }
    public void update(Author author) {

        try (PreparedStatement preparedStatement = DBConnectivity.getConnection()
                .prepareStatement(AuthorSQL.UPDATE.getSQL())) {

            preparedStatement.setString(1, author.getName());
            preparedStatement.setInt(2, author.getId());
            preparedStatement.execute();

        } catch (SQLException e) {

            e.printStackTrace();
            DBConnectivity.closeConnection();
        }
    }

    private String scopesWrapper(int id) {

        return "'" + id + "'";
    }
}
