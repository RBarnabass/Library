package com.softserve.library.app.dao.implementation;

import com.softserve.library.app.config.DBConnectivity;
import com.softserve.library.app.dao.interfaces.UserDao;
import com.softserve.library.app.dao.statement.UserStatementExecutor;
import com.softserve.library.app.dto.CreateUserDto;
import com.softserve.library.app.dto.DebtorDto;
import com.softserve.library.app.dto.FullUserDto;
import com.softserve.library.app.dto.UserStatisticDto;
import com.softserve.library.app.enums.tables.Tables;
import com.softserve.library.app.http.CustomResponseEntity;
import com.softserve.library.app.model.Role;
import com.softserve.library.app.model.User;
import com.softserve.library.app.model.UserEntity;

import javax.jws.soap.SOAPBinding;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 *
 * @author Roman Berezhnov
 */
public class UserDaoImpl implements UserDao {

    private final UserStatementExecutor userStatementExecutor = new UserStatementExecutor();
    private boolean isSuccess;

    public UserEntity getUserEntity(int id) throws SQLException {

        return getByOption("user.id=" + id);
    }
    public UserEntity getUserEntityByLogin(String login) throws SQLException {

        return getByOption("user.login='" + login + "'");
    }
    public boolean addUserEntity(UserEntity userEntity) throws SQLException {

        String sql = "INSERT INTO user (user.full_name, user.birth_date, user.registration_date, user.login, user.password, user.role_id)" +
                " VALUES(?,?, CURDATE(), ?,?,(SELECT id FROM role WHERE role.type=?))";

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(sql);
        preparedStatement.setString(1, userEntity.getFullName());
        preparedStatement.setDate(2, Date.valueOf(userEntity.getBirthDate()));
        preparedStatement.setString(3, userEntity.getLogin());
        preparedStatement.setString(4, userEntity.getPassword());
        preparedStatement.setString(5, userEntity.getRole().getType());
        isSuccess = preparedStatement.executeUpdate() > 0;
        return isSuccess;
    }
    public boolean updateUserEntity(UserEntity userEntity) throws SQLException {

        String sql = "UPDATE user SET user.full_name=?, user.birth_date=?, user.login=?, user.password=?, user.role_id=(SELECT role.id FROM role WHERE role.type=?) WHERE user.id=" + userEntity.getId();

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(sql);
        preparedStatement.setString(1, userEntity.getFullName());
        preparedStatement.setDate(2, Date.valueOf(userEntity.getBirthDate()));
        preparedStatement.setString(3, userEntity.getLogin());
        preparedStatement.setString(4, userEntity.getPassword());
        preparedStatement.setString(5, userEntity.getRole().getType());
        isSuccess = preparedStatement.executeUpdate() > 0;
        return isSuccess;
    }
    public boolean deleteUserEntity(int id) throws SQLException {

        String sql = "DELETE FROM user WHERE user.id=" + id;

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(sql);
        isSuccess = preparedStatement.executeUpdate() > 0;
        return isSuccess;
    }



    @Override public User get(int id) throws SQLException {

        String sql = "SELECT\n" +
                "  u.id                AS id,\n" +
                "  u.full_name         AS fullName,\n" +
                "  u.birth_date        as birthDate,\n" +
                "  u.registration_date AS regDate,\n" +
                "  u.login             AS login,\n" +
                "  u.password          AS password,\n" +
                "  u.role_id           AS roleId\n" +
                "FROM user AS u\n" +
                "WHERE u.id = " + id;

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(sql);
        preparedStatement.executeQuery();
        ResultSet resultSet = preparedStatement.getResultSet();

        User user = new User();

        while(resultSet.next()) {

            user.setId(resultSet.getInt("id"));
            user.setFullName(resultSet.getString("fullName"));
            user.setBirthDate(LocalDate.parse((resultSet.getDate("birthDate").toString())));
            user.setRegDate(LocalDate.parse((resultSet.getDate("regDate").toString())));
            user.setLogin(resultSet.getString("login"));
            user.setPassword(resultSet.getString("password"));
            user.setRole_id(resultSet.getInt("roleId"));
        }

        preparedStatement.close();
        resultSet.close();

        return user;
    }
    @Override public boolean add(User user) throws SQLException {

        String sql = "INSERT INTO " + Tables.USER.getTable()
                + " (full_name, birth_date, registration_date, login, password, role_id)"
                + " VALUES(?,?,CURDATE(),?,?,?)";

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(sql);
        preparedStatement.setString(1, user.getFullName());
        preparedStatement.setDate(2, Date.valueOf(user.getBirthDate()));
        preparedStatement.setString(3, user.getLogin());
        preparedStatement.setString(4, user.getPassword());
        preparedStatement.setInt(5, user.getRole_id());
        isSuccess = preparedStatement.executeUpdate() > 0;
        preparedStatement.close();

        return isSuccess;
    }

//    @Override public User getAllByOption(int id) throws SQLException {
//
//        List<User> list = userStatementExecutor.getAllByOption(id);
//
//        return list != null && !list.isEmpty() ? list.getAllByOption(0) : null;
//    }

    @Override
    public User getUserByLogin(String login) throws SQLException {

        String sql = "SELECT\n" +
                "  u.id                AS id,\n" +
                "  u.full_name         AS fullName,\n" +
                "  u.birth_date        as birthDate,\n" +
                "  u.registration_date AS regDate,\n" +
                "  u.login             AS login,\n" +
                "  u.password          AS password,\n" +
                "  u.role_id           AS roleId\n" +
                "FROM user AS u\n" +
                "WHERE u.login = '" + login + "'";

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(sql);
        preparedStatement.executeQuery();
        ResultSet resultSet = preparedStatement.getResultSet();

        User user = new User();

        // TODO: extract(?)
        while(resultSet.next()) {

            user.setId(resultSet.getInt("id"));
            user.setFullName(resultSet.getString("fullName"));
            user.setBirthDate(LocalDate.parse((resultSet.getDate("birthDate").toString())));
            user.setRegDate(LocalDate.parse((resultSet.getDate("regDate").toString())));
            user.setLogin(resultSet.getString("login"));
            user.setPassword(resultSet.getString("password"));
            user.setRole_id(resultSet.getInt("roleId"));
        }

        preparedStatement.close();
        resultSet.close();

        return user;
    }

    @Override public List<UserStatisticDto> getUserStatistic(int id) throws SQLException {

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

//    @Override
//    public CustomResponseEntity<?> add(CreateUserDto createUserDto) throws SQLException {
//        return userStatementExecutor.addUser(createUserDto);
//    }

//    @Override
//    public FullUserDto getByLogin(String login) throws SQLException, NullPointerException {
//        return null;
//    }

    @Override
    public boolean delete(int id) throws SQLException {

        // todo: realize it
        return false;
    }

    @Override
    public boolean update(User user) throws SQLException {

        // todo: realize it
        return false;
    }

    private UserEntity getByOption(String option) throws SQLException {

        String sql = "SELECT * FROM user JOIN role ON user.role_id = role.id WHERE " + option;

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(sql);
        preparedStatement.execute();
        ResultSet resultSet = preparedStatement.getResultSet();

        UserEntity userEntity = new UserEntity();
        Role role = new Role();

        while (resultSet.next()) {

            userEntity.setId(resultSet.getInt("user.id"));
            userEntity.setFullName(resultSet.getString("user.full_name"));
            userEntity.setBirthDate(LocalDate.parse(resultSet.getDate("user.birth_date").toString()));
            userEntity.setRegistrationDate(LocalDate.parse(resultSet.getDate("user.registration_date").toString()));
            userEntity.setLogin(resultSet.getString("user.login"));
            userEntity.setPassword(resultSet.getString("user.password"));
            role.setId(resultSet.getInt("role.id"));
            role.setType(resultSet.getString("role.type"));
            userEntity.setRole(role);
        }

        resultSet.close();
        preparedStatement.close();

        return userEntity;
    }
}
