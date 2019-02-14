package com.softserve.library.app.dao.interfaces;

import com.softserve.library.app.dto.UserStatisticDto;
import com.softserve.library.app.model.User;

import java.sql.SQLException;
import java.util.List;

/**
 *
 *
 * @author Roman Berezhnov
 */
public interface UserDao extends SimpleCrudDao<User> {

    List<UserStatisticDto> getUserStatistic(int id) throws SQLException;
}
