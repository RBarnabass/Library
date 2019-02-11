package com.softserve.library.app.dao;

import com.softserve.library.app.config.DBConnection;
import com.softserve.library.app.entity.Copy;
import com.softserve.library.app.tables.CopyColumns;
import com.softserve.library.app.tables.Tables;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class CopyDao implements IDaoCRUD<Copy> {
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Statement statement;

    @Override
    public Copy get(int id) throws SQLException {
        Copy copy;
        List<Copy> list = new ArrayList<>();
        String selectWhereId = "SELECT * FROM" + Tables.COPY.getTable() + " WHERE id=";

        preparedStatement = DBConnection.getConnection().prepareStatement(selectWhereId + id);
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            copy = new Copy();
            copy.setId(resultSet.getInt(CopyColumns.ID.getColumn()));
            copy.setBookId(resultSet.getInt(CopyColumns.BOOK_ID.getColumn()));
            copy.setIs_available(resultSet.getBoolean(CopyColumns.IS_AVAILABLE.getColumn()));
            list.add(copy);
        }
        return list.get(0);
    }

    @Override
    public List<Copy> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean add(Copy copy) throws SQLException {
        String insert = "INSERT INTO " + Tables.COPY.getTable() + "(" + CopyColumns.BOOK_ID.getColumn() + ")" + "VALUE(?,?)";
        preparedStatement = DBConnection.getConnection().prepareStatement(insert);
        preparedStatement.setInt(1, copy.getBookId());
        preparedStatement.setBoolean(2, copy.isIs_available());
        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean update(Copy copy) throws SQLException {
        String update = "UPDATE " + Tables.COPY.getTable() + " SET " + CopyColumns.BOOK_ID.getColumn() + "=? WHERE id=?";
        preparedStatement = DBConnection.getConnection().prepareStatement(update);
        preparedStatement.setBoolean(2, copy.isIs_available());
        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        String deletion = "DELETE FROM " + Tables.COPY.getTable() + " WHERE id=" + id;
        statement = DBConnection.getConnection().createStatement();
        return statement.executeUpdate(deletion) > 0;
    }
}
