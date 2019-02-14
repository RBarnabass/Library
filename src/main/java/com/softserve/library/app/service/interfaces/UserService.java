package com.softserve.library.app.service.interfaces;

import com.softserve.library.app.dto.UserStatisticDto;
import com.softserve.library.app.model.User;

import java.sql.SQLException;
import java.util.List;

/**
 *
 *
 * @author Roman Berezhnov
 */
public interface UserService extends SimpleCrudService<User> {

    List<UserStatisticDto> getUserStatistic(int id) throws SQLException;
}
