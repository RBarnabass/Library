package com.softserve.library.app.service.implementation;

import com.softserve.library.app.dao.implementation.UserDaoImpl;
import com.softserve.library.app.dao.interfaces.UserDao;
import com.softserve.library.app.dto.UserStatisticDto;
import com.softserve.library.app.model.User;
import com.softserve.library.app.service.interfaces.UserService;
import java.sql.SQLException;
import java.util.List;

/**
 *
 *
 * @author Roman Berezhnov
 */
public class UserServiceImpl implements UserService {

    private final UserDao userDao = new UserDaoImpl();

    @Override
    public User get(int id) throws SQLException {

        return userDao.get(id);
    }

    @Override
    public boolean add(User user) throws SQLException {

        //todo: Add role and credential and their relationships !
        return userDao.add(user);
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

    @Override public List<UserStatisticDto> getUserStatistic(int id) throws SQLException {

        return userDao.getUserStatistic(id);
    }
}
