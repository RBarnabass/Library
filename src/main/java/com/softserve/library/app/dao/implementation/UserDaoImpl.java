package com.softserve.library.app.dao.implementation;

import com.softserve.library.app.dao.interfaces.UserDao;
import com.softserve.library.app.dao.statement.UserStatementExecutor;
import com.softserve.library.app.dto.UserStatisticDto;
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
    @Override public boolean add(User user) throws SQLException {

        return userStatementExecutor.add(user);
    }
    @Override public List<UserStatisticDto> getUserStatistic(int id) throws SQLException {

        return userStatementExecutor.getUserStatistic(id);
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
