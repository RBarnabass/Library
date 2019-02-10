package com.softserve.library.app.dao;

import com.softserve.library.app.config.DBConnection;
import com.softserve.library.app.entity.Publisher;

import com.softserve.library.app.tables.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class PublisherDao implements IDaoCRUD<Publisher> {
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Statement statement;

    @Override
    public Publisher get(int id) throws SQLException {
        Publisher publisher;
        List<Publisher> list = new ArrayList<>();
        String selectWhereId = "SELECT * FROM" + Tables.PUBLISHER.getTable() + " WHERE id=";

        preparedStatement = DBConnection.getConnection().prepareStatement(selectWhereId + id);
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            publisher = new Publisher();
            publisher.setId(resultSet.getInt(PublisherColumns.ID.getColumn()));
            publisher.setName(resultSet.getString(PublisherColumns.NAME.getColumn()));
            list.add(publisher);
        }
        return list.get(0);
    }

    @Override
    public List<Publisher> getAll() throws SQLException {
        Publisher publisher;
        List<Publisher> list = new ArrayList<>();
        String selectWhereId = "SELECT * FROM" + Tables.PUBLISHER.getTable();

        preparedStatement = DBConnection.getConnection().prepareStatement(selectWhereId );
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            publisher = new Publisher();
            publisher.setId(resultSet.getInt(PublisherColumns.ID.getColumn()));
            publisher.setName(resultSet.getString(PublisherColumns.NAME.getColumn()));
            list.add(publisher);
        }
        return list;
    }

    @Override
    public boolean add(Publisher publisher) throws SQLException {
        String insert = "INSERT INTO " + Tables.PUBLISHER.getTable() + "(" + PublisherColumns.NAME.getColumn() + ")" + "VALUE(?)";
        preparedStatement = DBConnection.getConnection().prepareStatement(insert);
        preparedStatement.setString(1, publisher.getName());
        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean update(Publisher publisher) throws SQLException {
        String update = "UPDATE " + Tables.PUBLISHER.getTable() + " SET " + PublisherColumns.NAME.getColumn() + "=? WHERE id=?";
        preparedStatement = DBConnection.getConnection().prepareStatement(update);
        preparedStatement.setString(1, publisher.getName());
        preparedStatement.setInt(2, publisher.getId());

        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        String deletion = "DELETE FROM " + Tables.PUBLISHER.getTable() + " WHERE id=" + id;
        statement = DBConnection.getConnection().createStatement();
        return statement.executeUpdate(deletion) > 0;
    }
}
