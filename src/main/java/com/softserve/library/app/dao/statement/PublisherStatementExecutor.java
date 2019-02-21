package com.softserve.library.app.dao.statement;

import com.softserve.library.app.config.DBConnectivity;
import com.softserve.library.app.enums.sql.AuthorSQL;
import com.softserve.library.app.enums.sql.PublisherSQL;
import com.softserve.library.app.enums.tables.AuthorColumns;
import com.softserve.library.app.enums.tables.PublisherColumns;
import com.softserve.library.app.model.Author;
import com.softserve.library.app.model.Publisher;

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
public class PublisherStatementExecutor {

    private boolean isSuccess;

    public List<Publisher> getAllByOptions(String options) throws SQLException {

        List<Publisher> list = new ArrayList<>();

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(PublisherSQL.SELECT.getSQL() + options);
        ResultSet set = preparedStatement.executeQuery();
        Publisher publisher = new Publisher();

        while (set.next()) {

            publisher.setId(set.getInt(PublisherColumns.ID.getColumn()));
            publisher.setName(set.getString(PublisherColumns.NAME.getColumn()));
            list.add(publisher);
        }

        set.close();
        preparedStatement.close();

        return list;
    }
    public boolean add(Publisher publisher) throws SQLException {

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(PublisherSQL.INSERT.getSQL());
        preparedStatement.setString(1, publisher.getName());
        isSuccess = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();

        return isSuccess;
    }
    public boolean delete(int id) throws SQLException {

        Statement statement = DBConnectivity.getConnection().createStatement();
        isSuccess = statement.executeUpdate(PublisherSQL.DELETE.getSQL() + scopesWrapper(id)) > 0;
        statement.close();

        return isSuccess;
    }
    public boolean update(Publisher publisher) throws SQLException {

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(PublisherSQL.UPDATE.getSQL());
        preparedStatement.setString(1, publisher.getName());
        preparedStatement.setInt(2, publisher.getId());
        isSuccess = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();

        return isSuccess;
    }

    private String scopesWrapper(int id) {

        return "'" + id + "'";
    }
}
