package com.softserve.library.app.service.implementation;

import com.google.common.hash.Hashing;
import com.softserve.library.app.dao.implementation.UserDaoImpl;
import com.softserve.library.app.dao.interfaces.UserDao;
import com.softserve.library.app.dto.*;
import com.softserve.library.app.http.CustomResponseEntity;
import com.softserve.library.app.http.HttpStatus;
import com.softserve.library.app.model.Role;
import com.softserve.library.app.model.User;
import com.softserve.library.app.service.interfaces.UserService;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Roman Berezhnov
 */
public class UserServiceImpl implements UserService {

    private final UserDao userDao = new UserDaoImpl();

    @Override public User get(int id) throws SQLException {

        if (id < 1) {
            return null;
        }

        return userDao.get(id);
    }
    @Override public boolean add(User user) throws SQLException, NullPointerException {

        if (user.getFullName() == null || user.getBirthDate() == null || user.getLogin() == null || user.getPassword() == null) {
            return false;
        }

        if (user.getFullName().isEmpty() || user.getLogin().isEmpty() || user.getPassword().isEmpty()) {
            return false;
        }

        Role role = new Role();
        role.setType("user");
        user.setRole(role);

        return userDao.add(user);
    }
    @Override public boolean delete(int id) throws SQLException {

        if (id < 1) {
            return false;
        }

        return userDao.delete(id);
    }
    @Override public boolean update(User user) throws SQLException {

        if (user.getId() < 1) {
            return false;
        } else {
            return userDao.update(user);
        }
    }
    @Override public User getByLogin(String login) throws SQLException {

        if (login == null || login.isEmpty()) {
            return null;
        }

        return userDao.getUserByLogin(login);
    }

    @Override
    public List<UserStatisticDto> getUserStatistic(int id) throws SQLException {

        return userDao.getUserStatistic(id);
    }

    public User getUserByLoginAndPassword(String login, String password) throws SQLException {

        User user = userDao.getUserByLoginAndPassword(login, password);

        return user;
    }

    public int getAverageUserAge() throws SQLException {

        return userDao.getAverageUserAge();
    }

    @Override
    public int getAverageUserAgeByBook(int bookId) throws SQLException {

        return userDao.getAverageUserAgeByBook(bookId);
    }

    @Override
    public int getAverageUserAgeByAuthor(String authorFullName) throws SQLException {

        return userDao.getAverageUserAgeByAuthor(authorFullName);
    }

    @Override
    public int getUsingLibraryTimeInDays(int userId) throws SQLException {

        return userDao.getUsingLibraryTimeInDays(userId);
    }

    @Override
    public List<DebtorDto> getAllDebtors() throws SQLException {

        return userDao.getAllDebtors();
    }

    @Override
    public boolean compareHashes(String login, String serverSalt, String clientSalt, String hashedClientData) throws SQLException, NullPointerException {

        User user = userDao.getUserByLogin(login);

        String passwordHash = user.getPassword();

        String concatenatedData = passwordHash + serverSalt + clientSalt;

        String hashedDataHex = Hashing.sha256()
                .hashString(concatenatedData, StandardCharsets.UTF_8)
                .toString();

        return hashedDataHex.equals(hashedClientData);
    }
}


