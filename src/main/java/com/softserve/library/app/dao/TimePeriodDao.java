package com.softserve.library.app.dao;

import com.softserve.library.app.config.DBConnection;
import com.softserve.library.app.entity.TimePeriod;
import com.softserve.library.app.tables.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class TimePeriodDao implements IDaoCRUD<TimePeriod> {
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Statement statement;

    @Override
    public TimePeriod get(int id) throws SQLException {
        TimePeriod period;
        List<TimePeriod> list = new ArrayList<>();
        String selectWhereId = "SELECT * FROM" + Tables.TIME_PERIOD.getTable() + " WHERE id=";

        preparedStatement = DBConnection.getConnection().prepareStatement(selectWhereId + id);
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            period = new TimePeriod();
            period.setId(resultSet.getInt(TimePeriodColumns.ID.getColumn()));
            period.setCopyId(resultSet.getInt(TimePeriodColumns.COPY_ID.getColumn()));
//            period.setBookTakingDate(resultSet.getDate(TimePeriodColumns.BOOK_TAKING_DATE.getColumn()));
//            period.setBookTakingDate(resultSet.getDate(TimePeriodColumns.BOOK_RETURNING_DATE.getColumn()));
            period.setUserId(resultSet.getInt(TimePeriodColumns.USER_ID.getColumn()));
            list.add(period);
        }
        return list.get(0);
    }

    @Override
    public List<TimePeriod> getAll() throws SQLException {
        TimePeriod period;
        List<TimePeriod> periodsList = new ArrayList<>();

        String selectAll = "SELECT * FROM" + Tables.TIME_PERIOD.getTable();
        Statement statement = DBConnection.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(selectAll);

        while (resultSet.next()) {
            period = new TimePeriod();
            period.setId(resultSet.getInt(TimePeriodColumns.ID.getColumn()));
            period.setCopyId(resultSet.getInt(TimePeriodColumns.COPY_ID.getColumn()));
//            period.setBookTakingDate(resultSet.getDate(TimePeriodColumns.BOOK_TAKING_DATE.getColumn()));
//            period.setBookTakingDate(resultSet.getDate(TimePeriodColumns.BOOK_RETURNING_DATE.getColumn()));
            period.setUserId(resultSet.getInt(TimePeriodColumns.USER_ID.getColumn()));
            periodsList.add(period);
        }
        return periodsList;
    }

    @Override
    public boolean add(TimePeriod timePeriod) throws SQLException {
        String insert = "INSERT INTO " + Tables.TIME_PERIOD.getTable() + "("
                + TimePeriodColumns.COPY_ID.getColumn() + ", "
                + TimePeriodColumns.BOOK_TAKING_DATE.getColumn() + ", "
                + TimePeriodColumns.BOOK_RETURNING_DATE.getColumn() + ", "
                + TimePeriodColumns.USER_ID.getColumn() + ")" + "VALUE(?,?,?,?)";
        preparedStatement = DBConnection.getConnection().prepareStatement(insert);
        preparedStatement.setInt(1, timePeriod.getCopyId());
//        preparedStatement.setDate(2, timePeriod.getBookTakingDate());
//        preparedStatement.setDate(3, timePeriod.getBookReturningDate());
        preparedStatement.setInt(4, timePeriod.getUserId());
        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean update(TimePeriod timePeriod) throws SQLException {
        String update = "UPDATE " + Tables.TIME_PERIOD.getTable() + " SET " + TimePeriodColumns.COPY_ID.getColumn() + "=? WHERE id=?";
        preparedStatement = DBConnection.getConnection().prepareStatement(update);
        preparedStatement.setInt(1, timePeriod.getCopyId());
        return preparedStatement.executeUpdate() > 0;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        String deletion = "DELETE FROM " + Tables.TIME_PERIOD.getTable() + " WHERE id=" + id;
        statement = DBConnection.getConnection().createStatement();
        return statement.executeUpdate(deletion) > 0;
    }
}
