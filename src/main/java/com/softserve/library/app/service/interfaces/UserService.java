package com.softserve.library.app.service.interfaces;

import com.softserve.library.app.dto.DebtorDto;
import com.softserve.library.app.dto.UserStatisticDto;
import com.softserve.library.app.model.User;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 *
 * @author Roman Berezhnov
 */
public interface UserService extends SimpleCrudService<User> {

    List<UserStatisticDto> getUserStatistic(int id) throws SQLException;

    User getUserByLoginAndPassword(String login, String password) throws SQLException;

    User getByLogin(String login) throws SQLException;

    int getAverageUserAge() throws SQLException;

    int getAverageUserAgeByBook(int bookId) throws SQLException;

    int getAverageUserAgeByAuthor(String authorFullName) throws SQLException;

    int getUsingLibraryTimeInDays(int userId) throws SQLException;

    List<DebtorDto> getAllDebtors() throws SQLException;

    boolean compareHashes(String login, String serverSalt, String clientSalt, String clientHashedData) throws SQLException, NullPointerException;
}
