package com.softserve.library.app.dao.implementation;

import com.softserve.library.app.config.DBConnectivity;
import com.softserve.library.app.dao.interfaces.CopyDao;
import com.softserve.library.app.model.Copy;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CopyDaoImpl implements CopyDao {

    @Override public boolean add(Copy copy) throws SQLException {

        String sql = "INSERT INTO copy (book_id) VALUE (?)";

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, copy.getBookId());
        boolean isSuccess = preparedStatement.executeUpdate() > 0;
        return isSuccess;
    }

    @Override
    public Copy get(int id) throws SQLException {

        String sql = "SELECT * FROM copy WHERE book_id=" +id;

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(sql);
        preparedStatement.executeUpdate();
        ResultSet resultSet = preparedStatement.getResultSet();

        Copy copy = new Copy();

        while (resultSet.next()) {

            copy.setId(resultSet.getInt("copy.id"));
            copy.setId(resultSet.getInt("copy.book_id"));
        }

        return copy;
    }

    @Override
    public boolean delete(int id) throws SQLException {

        return false;
    }

    @Override
    public boolean update(Copy copy) throws SQLException {

        return false;
    }
}
