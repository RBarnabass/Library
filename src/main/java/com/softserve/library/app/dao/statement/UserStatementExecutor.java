package com.softserve.library.app.dao.statement;

import com.softserve.library.app.config.DBConnectivity;
import com.softserve.library.app.dto.UserStatisticDto;
import com.softserve.library.app.enums.sql.UserSQL;
import com.softserve.library.app.enums.tables.BookColumns;
import com.softserve.library.app.enums.tables.UserColumns;
import com.softserve.library.app.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author Roman Berezhnov
 */
public class UserStatementExecutor {

    private boolean isSuccess;

    public List<User> get(int id) throws SQLException {

        List<User> list = new ArrayList<>();

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(UserSQL.SELECT.getSQL());
        ResultSet set = preparedStatement.getResultSet();
        User user;

        while (set.next()) {

            user = new User();
            user.setId(set.getInt(UserColumns.ID.getColumn()));
            user.setFullName(set.getString(UserColumns.FULL_NAME.getColumn()));
            user.setBirthDate(set.getDate(UserColumns.BIRTH_DATE.getColumn()));
            user.setRegistrationDate(set.getTimestamp(UserColumns.REGISTRATION_DATE.getColumn()));

            list.add(user);
        }

        set.close();
        preparedStatement.close();

        return list;
    }

    // todo: about role should it be here or separated sql in service?
    public boolean add(User user) throws SQLException {

        System.out.println(UserSQL.INSERT.getSQL());

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(UserSQL.INSERT.getSQL());
        preparedStatement.setString(1, user.getFullName());
        preparedStatement.setDate(2, user.getBirthDate());
        preparedStatement.setTimestamp(3, user.getRegistrationDate());
        isSuccess = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();

        return isSuccess;
    }

    public List<UserStatisticDto> getUserStatistic(int id) throws SQLException {

        List<UserStatisticDto> list = new ArrayList<>();

        String sql = "SELECT user.full_name, from_days(datediff(curdate(), user.registration_date)) AS usingTime, book.name, book.publish_year, time_period.start_date, time_period.end_date\n" +
                "  FROM user\n" +
                "    JOIN time_period\n" +
                "      ON user.id = time_period.user_id\n" +
                "        JOIN copy\n" +
                "          ON time_period.copy_id = copy.id\n" +
                "            JOIN book\n" +
                "              ON copy.book_id = book.id\n" +
                "                WHERE user.id =" + "'" + id + "'";

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(sql);
        preparedStatement.executeQuery();
        ResultSet resultSet = preparedStatement.getResultSet();

        UserStatisticDto userStatisticDto;

        while (resultSet.next()) {

            userStatisticDto = new UserStatisticDto();
            userStatisticDto.setUserName(resultSet.getString(UserColumns.FULL_NAME.getColumn()));
            userStatisticDto.setUsingTime(resultSet.getTimestamp("usingTime"));
            userStatisticDto.setBookName(resultSet.getString(BookColumns.NAME.getColumn()));
            userStatisticDto.setPublishYear(resultSet.getInt(BookColumns.PUBLISH_YEAR.getColumn()));
            userStatisticDto.setStartDate(resultSet.getDate("time_period.start_date"));
            userStatisticDto.setEndDate(resultSet.getDate("time_period.end_date"));
            list.add(userStatisticDto);
        }

        return list;
    }
}
