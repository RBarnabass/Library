package com.softserve.library.app.dao.implementation;

import com.softserve.library.app.dao.interfaces.UserDao;
import com.softserve.library.app.dao.statement.UserStatementExecutor;
import com.softserve.library.app.dto.DebtorDto;
import com.softserve.library.app.dto.CreateUserDto;
import com.softserve.library.app.dto.FullUserDto;
import com.softserve.library.app.dto.UserStatisticDto;
import com.softserve.library.app.http.CustomResponseEntity;
import com.softserve.library.app.model.User;
import java.sql.SQLException;
import java.util.List;

/**
 *
 *
 * @author Roman Berezhnov
 */
public class UserDaoImpl implements UserDao {

    private final UserStatementExecutor userStatementExecutor = new UserStatementExecutor();

    @Override public User get(int id) throws SQLException {

        List<User> list = userStatementExecutor.get(id);

        return list != null && !list.isEmpty() ? list.get(0) : null;
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

    @Override
    public CustomResponseEntity<?> add(CreateUserDto createUserDto) throws SQLException {
        return userStatementExecutor.addUser(createUserDto);
    }

    @Override
    public FullUserDto getByLogin(String login) throws SQLException, NullPointerException {

        return userStatementExecutor.getUserByLogin(login);
    }

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
}
