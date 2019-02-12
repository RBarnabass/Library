package com.softserve.library.app.dao.implementation;

import com.softserve.library.app.dao.interfaces.UserDao;
import com.softserve.library.app.dao.statement.UserStatementExecutor;
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

        // todo: remove this to some util class and adapt it for other similar situations
        List<User> list = userStatementExecutor.get(id);

        if (list != null && !list.isEmpty()) {

            return list.get(0);
        }

        return null;
    }
    @Override public boolean add(User user) throws SQLException {

        return userStatementExecutor.add(user);
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
