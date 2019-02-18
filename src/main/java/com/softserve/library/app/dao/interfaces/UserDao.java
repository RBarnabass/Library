package com.softserve.library.app.dao.interfaces;

import com.softserve.library.app.dto.DebtorDto;
import com.softserve.library.app.dto.UserDto;
import com.softserve.library.app.dto.UserStatisticDto;
import com.softserve.library.app.http.CustomResponseEntity;
import com.softserve.library.app.model.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Roman Berezhnov
 */
public interface UserDao extends SimpleCrudDao<User> {

    List<UserStatisticDto> getUserStatistic(int id) throws SQLException;

    int getAverageUserAge() throws SQLException;

    int getAverageUserAgeByBook(int bookId) throws SQLException;

    int getAverageUserAgeByAuthor(String authorFullName) throws SQLException;

    public int getUsingLibraryTimeInDays(int userId) throws SQLException;

    List<DebtorDto> getAllDebtors() throws SQLException;

    CustomResponseEntity<?> add(UserDto userDto) throws SQLException;
}
