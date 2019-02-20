package com.softserve.library.app.dao.interfaces;

import com.softserve.library.app.dto.UserStatisticDto;
import com.softserve.library.app.model.User;
import com.softserve.library.app.dto.DebtorDto;
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

    int getUsingLibraryTimeInDays(int userId) throws SQLException;

    List<DebtorDto> getAllDebtors() throws SQLException;

    List<User> getByOption(String option) throws SQLException;

    List<User> getAllUsersByName(String name) throws SQLException;

    User getUserByLogin(String login) throws SQLException;

    User getUserByNameAndLogin(String name, String login) throws SQLException;

}
