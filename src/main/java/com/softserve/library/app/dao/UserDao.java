package com.softserve.library.app.dao;


import com.softserve.library.app.config.DBConnection;
import com.softserve.library.app.entity.User;
import com.softserve.library.app.tables.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class UserDao implements IDaoCRUD<User> {
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Statement statement;

    @Override
    public User get(int id) throws SQLException {
        User user;
        List<User> list = new ArrayList<>();
        String selectWhereId = "SELECT * FROM" + Tables.USER.getTable() + " WHERE id=";
        preparedStatement = DBConnection.getConnection().prepareStatement(selectWhereId + id);
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            user = new User();
            user.setId(resultSet.getInt(UserColumns.ID.getColumn()));
            user.setName(resultSet.getString(UserColumns.NAME.getColumn()));
            //TODO don't know how write correct
            //user.setBirthDate(resultSet.getDate(UserColumns.BIRTH_DATE.getColumn()));
//            user.setBirthDate(resultSet.getDate(UserColumns.REGISTRATION_DATE.getColumn()));
            list.add(user);
        }
        return list.get(0);
    }

    @Override
    public List<User> getAll() throws SQLException {
        User user;
        List<User> list = new ArrayList<>();
        String selectWhereId = "SELECT * FROM" + Tables.USER.getTable();
        preparedStatement = DBConnection.getConnection().prepareStatement(selectWhereId);
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            user = new User();
            user.setId(resultSet.getInt(UserColumns.ID.getColumn()));
            user.setName(resultSet.getString(UserColumns.NAME.getColumn()));
            //user.setBirthDate(resultSet.getDate(UserColumns.BIRTH_DATE.getColumn()));
            //user.setBirthDate(resultSet.getDate(UserColumns.REGISTRATION_DATE.getColumn()));
            list.add(user);
        }
        return list;
    }

    @Override
    public boolean add(User user) throws SQLException {
        String insert = "INSERT INTO " + Tables.USER.getTable() + "("
                + UserColumns.NAME.getColumn() + ", " + UserColumns.BIRTH_DATE.getColumn() + ", "
                + UserColumns.REGISTRATION_DATE.getColumn() + ")" + "VALUE(?,?,?)";
        preparedStatement = DBConnection.getConnection().prepareStatement(insert);
        preparedStatement.setString(1, user.getName());
       // preparedStatement.setDate(2,user.getBirthDate());
        // preparedStatement.setDate(3,user.getRegistrationDate());
        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean update(User user) throws SQLException {
        String update = "UPDATE " + Tables.PUBLISHER.getTable() + " SET " + UserColumns.NAME.getColumn() + "=? WHERE id=?";
        preparedStatement = DBConnection.getConnection().prepareStatement(update);
        preparedStatement.setString(1, user.getName());
        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        String deletion = "DELETE FROM " + Tables.USER.getTable() + " WHERE id=" + id;
        statement = DBConnection.getConnection().createStatement();
        return statement.executeUpdate(deletion) > 0;
    }
}
