package com.softserve.library.app.dao.statement;

import com.softserve.library.app.config.DBConnectivity;
import com.softserve.library.app.dto.*;
import com.softserve.library.app.enums.sql.UserSQL;
import com.softserve.library.app.enums.tables.BookColumns;
import com.softserve.library.app.enums.tables.UserColumns;
import com.softserve.library.app.http.CustomResponseEntity;
import com.softserve.library.app.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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

    // TODO: refactor or so
    // Task 3 - the usage period is repeated in every line!
    public List<UserStatisticDto> getUserStatistic(int id) throws SQLException {

        List<UserStatisticDto> list = new ArrayList<>();

        // todo: remove SQL !!!

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

        resultSet.close();
        preparedStatement.close();

        return list;
    }

    public int getAverageUserAge() throws SQLException {

        String sql = "SELECT FLOOR(AVG(DATEDIFF(CURDATE(), u.birth_date) / 365)) AS avgAge\n" +
                "FROM user AS u";

        int avgAge = 0;

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(sql);
        preparedStatement.executeQuery();
        ResultSet resultSet = preparedStatement.getResultSet();

        while (resultSet.next()) {

            avgAge = resultSet.getInt("avgAge");
        }

        resultSet.close();
        preparedStatement.close();

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

        resultSet.close();
        preparedStatement.close();

        return avgAge;
    }

    public int getAverageUserAgeByAuthor(String authorFullName) throws SQLException {

        String sql = "SELECT FLOOR(AVG(DATEDIFF(CURDATE(), u.birth_date) / 365)) as avgAge\n" +
                "FROM author AS a\n" +
                "  JOIN book_authors ba on a.id = ba.author_id\n" +
                "  JOIN book b on ba.book_id = b.id\n" +
                "  JOIN copy c on b.id = c.book_id\n" +
                "  JOIN time_period tp on c.id = tp.copy_id\n" +
                "  JOIN user u on tp.user_id = u.id\n" +
                "WHERE a.full_name = " + "'" + authorFullName + "'";

        int avgAge = 0;

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(sql);
        preparedStatement.executeQuery();
        ResultSet resultSet = preparedStatement.getResultSet();

        while (resultSet.next()) {

            avgAge = resultSet.getInt("avgAge");
        }

        resultSet.close();
        preparedStatement.close();

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

        resultSet.close();
        preparedStatement.close();

        return daysUsing;
    }

    public List<DebtorDto> getAllDebtors() throws SQLException {

        String sql = "SELECT\n" +
                "  u.id                             AS debtorId,\n" +
                "  u.full_name                      AS debtorFullName,\n" +
                "  u.birth_date                     AS debtorBirthDate,\n" +
                "  u.registration_date              AS debtorRegDate,\n" +
                "  c.id                             AS copyId,\n" +
                "  b.id                             AS bookId,\n" +
                "  b.name                           AS bookName,\n" +
                "  DATEDIFF(CURDATE(), tp.end_date) AS debtDays\n" +
                "FROM time_period tp\n" +
                "  JOIN copy c on tp.copy_id = c.id\n" +
                "  JOIN book b on c.book_id = b.id\n" +
                "  JOIN user u on tp.user_id = u.id\n" +
                "WHERE tp.end_date < CURDATE() AND tp.return_date IS NULL\n" +
                "ORDER BY debtorId ASC, debtDays";

        List<DebtorDto> debtors = new ArrayList<>();

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(sql);
        preparedStatement.executeQuery();
        ResultSet resultSet = preparedStatement.getResultSet();

        resultSet.next();

        while (!resultSet.isAfterLast()) {

            int userId = resultSet.getInt("debtorId");
            String debtorFullName = resultSet.getString("debtorFullName");
            String debtorBirthDate = resultSet.getString("debtorBirthDate");
            String debtorRegDate = resultSet.getString("debtorRegDate");

            List<DebtCopyDto> debtCopies = new ArrayList<>();

            while (resultSet.getInt("debtorId") == userId) {

                int copyId = resultSet.getInt("copyId");
                int bookId = resultSet.getInt("bookId");
                int daysInDebt = resultSet.getInt("debtDays");

                DebtCopyDto debtCopy = new DebtCopyDto();

                debtCopy.setCopyId(copyId);
                debtCopy.setBookId(bookId);
                debtCopy.setDaysInDebt(daysInDebt);

                debtCopies.add(debtCopy);

                resultSet.next();

                if (resultSet.isAfterLast()) {
                    break;
                }
            }

            DebtorDto debtor = new DebtorDto();
            debtor.setUserId(userId);
            debtor.setUserFullName(debtorFullName);
            debtor.setUserBirthDate(debtorBirthDate);
            debtor.setUserRegistrationDate(debtorRegDate);
            debtor.setDebtCopies(debtCopies);

            debtors.add(debtor);
        }

        resultSet.close();
        preparedStatement.close();

        return debtors;
    }

    public CustomResponseEntity<?> addUser(UserDto userDto) throws SQLException {

        String fullName = userDto.getFullName();
        LocalDate birthDate = userDto.getBirthDate();
        String login = userDto.getLogin();
        String password = userDto.getPassword();

        String addUserSql = "INSERT INTO user (full_name, birth_date, registration_date, login, password, role_id)\n" +
                "VALUES ('" + fullName + "', DATE '" + birthDate + "', CURDATE(),\n" +
                "'" + login + "', '" + password + "', " + (userDto.isAdmin() ? 2 : 1) + ")";

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(addUserSql, Statement.RETURN_GENERATED_KEYS);
        int count = preparedStatement.executeUpdate();

        // demonstration
//        try {
//            count = preparedStatement.executeUpdate();
//        } catch (Exception e) {
//            System.out.println("oh yeah exceprion just like you wanted hehe");
//        }

        if (count < 1) {

            ErrorDto errorDto = new ErrorDto();
            errorDto.setErrorMessage("Internal server error occurred during creating new user.");

            // TODO: create HttpStatus enum with status codes
            return new CustomResponseEntity<>(errorDto, 500);
        }

        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        resultSet.next();

        CreatedUserDto createdUserDto = new CreatedUserDto();
        createdUserDto.setId(resultSet.getInt(1));
        createdUserDto.setFullName(fullName);
        createdUserDto.setBirthDate(birthDate);
        createdUserDto.setRegDate(LocalDate.now());
        createdUserDto.setLogin(login);

        // TODO: create HttpStatus enum with status codes
        return new CustomResponseEntity<>(userDto, 200);
    }
}
