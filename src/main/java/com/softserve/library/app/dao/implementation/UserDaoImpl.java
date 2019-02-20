package com.softserve.library.app.dao.implementation;

import com.softserve.library.app.config.DBConnectivity;
import com.softserve.library.app.dao.interfaces.UserDao;
import com.softserve.library.app.dao.statement.UserStatementExecutor;
import com.softserve.library.app.dto.DebtorDto;
import com.softserve.library.app.dto.UserStatisticDto;
import com.softserve.library.app.model.Role;
import com.softserve.library.app.model.User;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Roman Berezhnov
 */
public class UserDaoImpl implements UserDao {

    private final UserStatementExecutor userStatementExecutor = new UserStatementExecutor();
    private boolean isSuccess;

    public User get(int id) throws SQLException {

        List<User> list = getByOption("user.id=" + id);

        if (list != null) {
            return list.get(0);
        }

        return null;
    }

    public User getUserByLogin(String login) throws SQLException, NullPointerException {

        List<User> list = getByOption("user.login='" + login + "'");

        if (list.size() > 0) {
            return list.get(0);
        } else {
            throw new NullPointerException();
        }
    }

    public boolean add(User user) throws SQLException {

        String sql = "INSERT INTO user (user.full_name, user.birth_date, user.registration_date, user.login, user.password, user.role_id)" +
                " VALUES(?,?, CURDATE(), ?,?,(SELECT id FROM role WHERE role.type=?))";

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(sql);
        preparedStatement.setString(1, user.getFullName());
        preparedStatement.setDate(2, Date.valueOf(user.getBirthDate()));
        preparedStatement.setString(3, user.getLogin());
        preparedStatement.setString(4, user.getPassword());
        preparedStatement.setString(5, user.getRole().getType());
        isSuccess = preparedStatement.executeUpdate() > 0;
        return isSuccess;
    }
    public boolean update(User user) throws SQLException {

        String sql = "UPDATE user SET user.full_name=?, user.birth_date=?, user.login=?, user.password=?, user.role_id=(SELECT role.id FROM role WHERE role.type=?) WHERE user.id=" + user.getId();

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(sql);
        preparedStatement.setString(1, user.getFullName());
        preparedStatement.setDate(2, Date.valueOf(user.getBirthDate()));
        preparedStatement.setString(3, user.getLogin());
        preparedStatement.setString(4, user.getPassword());
        preparedStatement.setString(5, user.getRole().getType());
        isSuccess = preparedStatement.executeUpdate() > 0;
        return isSuccess;
    }
    public boolean delete(int id) throws SQLException {

        String sql = "DELETE FROM user WHERE user.id=" + id;

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(sql);
        isSuccess = preparedStatement.executeUpdate() > 0;
        return isSuccess;
    }

    @Override public List<User> getByOption(String option) throws SQLException {

        List<User> list = new ArrayList<>();
        User user = new User();
        Role role = new Role();

        String sql = "SELECT * FROM user JOIN role ON user.role_id = role.id WHERE " + option;

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(sql);
        preparedStatement.execute();
        ResultSet resultSet = preparedStatement.getResultSet();

        while (resultSet.next()) {

            user.setId(resultSet.getInt("user.id"));
            user.setFullName(resultSet.getString("user.full_name"));
            user.setBirthDate(LocalDate.parse(resultSet.getDate("user.birth_date").toString()));
            user.setRegistrationDate(LocalDate.parse(resultSet.getDate("user.registration_date").toString()));
            user.setLogin(resultSet.getString("user.login"));
            user.setPassword(resultSet.getString("user.password"));
            role.setId(resultSet.getInt("role.id"));
            role.setType(resultSet.getString("role.type"));
            user.setRole(role);
            list.add(user);
        }

        resultSet.close();
        preparedStatement.close();

        return list;
    }
    @Override public List<User> getAllUsersByName(String name) throws SQLException {

        return getByOption("user.full_name=" + "'" + name + "'");
    }
    @Override public User getUserByLoginAndPassword(String login, String password) throws SQLException {

        String input = "user.login=" + "'" + login + "'" + " AND " + "user.password=" + "'" + password + "'";
        List<User> list = getByOption(input);

        if (list != null) {
            return list.get(0);
        }

        return null;
    }

    @Override
    public List<UserStatisticDto> getUserStatistic(int id) throws SQLException {

        return userStatementExecutor.getUserStatistic(id);
    }
    @Override
    public int getAverageUserAge() throws SQLException {

        return userStatementExecutor.getAverageUserAge();
    }
    @Override
    public int getAverageUserAgeByBook(int bookId) throws SQLException {

        return userStatementExecutor.getAverageUserAgeByBook(bookId);
    }
    @Override
    public int getAverageUserAgeByAuthor(String authorFullName) throws SQLException {

        return userStatementExecutor.getAverageUserAgeByAuthor(authorFullName);
    }
    @Override
    public int getUsingLibraryTimeInDays(int userId) throws SQLException {

        return userStatementExecutor.getUsingLibraryTimeInDays(userId);
    }
    @Override
    public List<DebtorDto> getAllDebtors() throws SQLException {

        return userStatementExecutor.getAllDebtors();
    }

}