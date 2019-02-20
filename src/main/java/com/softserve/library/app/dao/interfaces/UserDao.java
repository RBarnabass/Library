package com.softserve.library.app.dao.interfaces;

import com.softserve.library.app.dto.UserStatisticDto;
import com.softserve.library.app.model.User;
import com.softserve.library.app.model.UserEntity;
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

//    CustomResponseEntity<?> add(CreateUserDto createUserDto) throws SQLException;

    UserEntity getByOption(String option) throws SQLException;

    List<UserEntity> getByOptionList(String option) throws SQLException;

    UserEntity getAllUsersByName(String name) throws SQLException;

    UserEntity getAllUsersByLogin(String login) throws SQLException;

    UserEntity getUserByNameAndLogin(String name, String login) throws SQLException;

}
