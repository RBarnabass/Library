package com.softserve.library.app.service.implementation;

import com.softserve.library.app.dao.implementation.UserDaoImpl;
import com.softserve.library.app.dao.interfaces.UserDao;
import com.softserve.library.app.dto.*;
import com.softserve.library.app.http.CustomResponseEntity;
import com.softserve.library.app.http.HttpStatus;
import com.softserve.library.app.model.User;
import com.softserve.library.app.service.interfaces.UserService;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Roman Berezhnov
 */
public class UserServiceImpl implements UserService {

    private final UserDao userDao = new UserDaoImpl();

    @Override
    public User get(int id) throws SQLException {

        return userDao.get(id);
    }

    @Override
    public void add(User user) throws SQLException, NullPointerException {


        userDao.add(user);
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

    @Override
    public List<UserStatisticDto> getUserStatistic(int id) throws SQLException {

        return userDao.getUserStatistic(id);
    }

    @Override
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
    public CustomResponseEntity<?> add(CreateUserDto createUserDto) throws SQLException {
        return userDao.add(createUserDto);
    }

//    @Override
//    public CustomResponseEntity<?> checkLoginPasswordEquality(String login, String password) {
//
//        CustomResponseEntity<?> getByLoginEntity = getByLogin(login);
//
//        if (getByLoginEntity.getHttpStatus().isError()) {
//
//            return getByLoginEntity;
//        }
//
//        FullUserDto responseBody = (FullUserDto) getByLoginEntity.getResponseBody();
//
//        if (!responseBody.getPassword().equals(password)) {
//
//            ErrorDto errorDto = new ErrorDto();
//            errorDto.setErrorMessage("Password and login are not matching.");
//
//            return new CustomResponseEntity<>(errorDto, HttpStatus.FORBIDDEN);
//        }
//
//        SuccessfulLoginUserDto successfulLoginUserDto = new SuccessfulLoginUserDto();
//        successfulLoginUserDto.setUserId(responseBody.getId());
//        successfulLoginUserDto.setRole(responseBody.isAdmin());
//
//        return new CustomResponseEntity<>(successfulLoginUserDto, HttpStatus.OK);
//    }

    @Override
    public CustomResponseEntity<?> getByLogin(String login) {

        FullUserDto fullUserDto;

        try {

            fullUserDto = userDao.getByLogin(login);
        } catch (SQLException e) {

            ErrorDto errorDto = new ErrorDto();
            errorDto.setErrorMessage("Internal server error during retrieving user from database.");

            return new CustomResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (NullPointerException e) {

            ErrorDto errorDto = new ErrorDto();
            errorDto.setErrorMessage("User with such login was not found.");

            return new CustomResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
        }

        return new CustomResponseEntity<>(fullUserDto, HttpStatus.OK);
    }
}


