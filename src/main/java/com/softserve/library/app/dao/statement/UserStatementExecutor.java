package com.softserve.library.app.dao.statement;

import com.softserve.library.app.config.DBConnectivity;
import com.softserve.library.app.dto.DebtorDto;
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

    public int getAverageUserAge() throws SQLException {

        String sql = "SELECT FLOOR(AVG(DATEDIFF(CURDATE(), user.birth_date) / 365)) AS avgAge\n" +
                "FROM user";

        int avgAge = 0;

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(sql);
        preparedStatement.executeQuery();
        ResultSet resultSet = preparedStatement.getResultSet();

        while (resultSet.next()) {

            avgAge = resultSet.getInt("avgAge");
        }

        return avgAge;
    }

    public int getAverageUserAgeByBook(int bookId) throws SQLException {

        String sql = "SELECT FLOOR(AVG(DATEDIFF(CURDATE(), user.birth_date) / 365)) AS avgAge\n" +
                "FROM time_period\n" +
                "  JOIN copy ON time_period.copy_id = copy.id\n" +
                "  JOIN book ON copy.book_id = book.id\n" +
                "  JOIN user ON time_period.user_id = user.id\n" +
                "WHERE book.id = " + bookId;

        int avgAge = 0;

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(sql);
        preparedStatement.executeQuery();
        ResultSet resultSet = preparedStatement.getResultSet();

        while (resultSet.next()) {

            avgAge = resultSet.getInt("avgAge");
        }

        return avgAge;
    }

    public int getAverageUserAgeByAuthor(String authorFullName) throws SQLException{

        String sql = "SELECT FLOOR(AVG(DATEDIFF(CURDATE(), user.birth_date) / 365)) as avgAge\n" +
                "FROM author\n" +
                "  JOIN book_by_authors ON author.id = book_by_authors.author_id\n" +
                "  JOIN book ON book_by_authors.book_id = book.id\n" +
                "  JOIN copy ON book.id = copy.book_id\n" +
                "  JOIN time_period ON copy.id = time_period.copy_id\n" +
                "  JOIN user ON time_period.user_id = user.id\n" +
                "WHERE author.full_name = " + "'" + authorFullName + "'";

        int avgAge = 0;

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(sql);
        preparedStatement.executeQuery();
        ResultSet resultSet = preparedStatement.getResultSet();

        while (resultSet.next()) {

            avgAge = resultSet.getInt("avgAge");
        }

        return avgAge;
    }

    public int getUsingLibraryTimeInDays(int userId) throws SQLException {

        String sql = "SELECT FLOOR(DATEDIFF(CURDATE(), user.registration_date)) AS daysOfUse\n" +
                "FROM user\n" +
                "WHERE user.id = " + userId;

        int daysUsing = 0;

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(sql);
        preparedStatement.executeQuery();
        ResultSet resultSet = preparedStatement.getResultSet();

        while (resultSet.next()) {

            daysUsing = resultSet.getInt("daysOfUse");
        }

        return daysUsing;
    }

    public List<DebtorDto> getAllDebtors() throws SQLException {

        return null;
    };
}
