package com.softserve.library.app.dao.implementation;

import com.softserve.library.app.config.DBConnectivity;
import com.softserve.library.app.dao.interfaces.CopyDao;
import com.softserve.library.app.model.Copy;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CopyDaoImpl implements CopyDao {

    private boolean isSuccess;

    @Override public boolean add(Copy copy) throws SQLException {

        String sql = "INSERT INTO copy (book_id) VALUE (?)";

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, copy.getBookId());
        isSuccess = preparedStatement.executeUpdate() > 0;
        return isSuccess;
    }



    @Override
    public Copy get(int id) throws SQLException {

        return null;
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
