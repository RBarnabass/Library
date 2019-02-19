package com.softserve.library.app.service.interfaces;

import com.softserve.library.app.dto.DebtorDto;
import com.softserve.library.app.dto.CreateUserDto;
import com.softserve.library.app.dto.FullUserDto;
import com.softserve.library.app.dto.UserStatisticDto;
import com.softserve.library.app.http.CustomResponseEntity;
import com.softserve.library.app.model.User;
import org.springframework.http.ResponseEntity;

import java.sql.SQLException;
import java.util.List;

/**
 *
 *
 * @author Roman Berezhnov
 */
public interface UserService extends SimpleCrudService<User> {

    List<UserStatisticDto> getUserStatistic(int id) throws SQLException;

    User getByLogin(String login) throws SQLException;

    int getAverageUserAge() throws SQLException;

    int getAverageUserAgeByBook(int bookId) throws SQLException;

    int getAverageUserAgeByAuthor(String authorFullName) throws SQLException;

    int getUsingLibraryTimeInDays(int userId) throws SQLException;

    List<DebtorDto> getAllDebtors() throws SQLException;

//    CustomResponseEntity<?> add(CreateUserDto createUserDto) throws SQLException;

    //CustomResponseEntity<?> checkLoginPasswordEquality(String login, String password);

//    CustomResponseEntity<?> getByLogin(String login);
}
