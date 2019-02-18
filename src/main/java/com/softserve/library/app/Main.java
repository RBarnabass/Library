package com.softserve.library.app;

import com.softserve.library.app.config.DBConnectivity;
import com.softserve.library.app.dto.*;
import com.softserve.library.app.http.CustomResponseEntity;
import com.softserve.library.app.model.Credential;
import com.softserve.library.app.model.User;
import com.softserve.library.app.service.factory.ServiceFactory;
import com.softserve.library.app.service.factory.ServiceFactoryImpl;
import com.softserve.library.app.service.interfaces.UserService;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

/**
 *
 *
 * @author Roman Berezhnov
 */
public class Main {

    public static void main(String[] args) throws SQLException {

        ServiceFactory serviceFactory = ServiceFactoryImpl.getFactory();

//        ServiceFactory serviceFactory = new ServiceFactoryImpl();
//        List<BookDto> list = serviceFactory.getBookService().getAll();
//        for (BookDto bookDto : list) {
//            System.out.println();
//            System.out.println(bookDto);
//        }
//
//        ServiceFactory serviceFactory = ServiceFactoryImpl.getFactory();
//        List<UserStatisticDto> userStatistic = serviceFactory.getUserService().getUserStatistic(6);
//        for (UserStatisticDto userStatisticDto : userStatistic) {
//            System.out.println();
//            System.out.println(userStatisticDto);
//        }


        /*List<BookDto> list = serviceFactory.getBookService().getAll();
        for (BookDto bookDto : list) {
            System.out.println();
            System.out.println(bookDto);
        }*/

//        List<BookDto> list = serviceFactory.getBookService().getAll();
//        for (BookDto bookDto : list) {
//            System.out.println();
//            System.out.println(bookDto);
//        }
        // OK
//        int numberOfOverallBookUsages = serviceFactory.getBookService().getNumberOfOverallBookUsages(1); // 2
//        System.out.println(numberOfOverallBookUsages);

        // OK
//        int numberOfBookUsagesByCopy = serviceFactory.getBookService().getNumberOfBookUsagesByCopy(1);   // 1
//        System.out.println(numberOfBookUsagesByCopy);

        // OK
//        int averageReadingTime = serviceFactory.getBookService().getAverageReadingTime(1);    // 26
//        System.out.println(averageReadingTime);

        // OK
//        int bookQuantityPublishedFromYear = serviceFactory.getBookService().getBookQuantityPublishedFromYear(2005); // 1
//        System.out.println(bookQuantityPublishedFromYear);

        // OK
//        int averageUserAge = serviceFactory.getUserService().getAverageUserAge();  // 20
//        System.out.println(averageUserAge);

        // OK
//        int averageAgeByBook = serviceFactory.getUserService().getAverageUserAgeByBook(2);  // 21
//        System.out.println(averageAgeByBook);

        // OK
//        int daysUsing = serviceFactory.getUserService().getUsingLibraryTimeInDays(2);  // 31
//        System.out.println(daysUsing);


        // OK
//        int averageAgeByAuthor = serviceFactory.getUserService().getAverageUserAgeByAuthor("John Doe");  // 20
//        System.out.println(averageAgeByAuthor);

        // OK (at least i think so)
//        List<DebtorDto> debtors = serviceFactory.getUserService().getAllDebtors();
//        System.out.println(debtors.size()); // 1

        UserDto userDto = new UserDto();
        userDto.setFullName("Darth Vader");
        userDto.setBirthDate(LocalDate.parse("1970-03-02"));
        userDto.setLogin("darthisagoodboi");
        userDto.setPassword("anakin1337");
        userDto.setIsAdmin(false);

        CustomResponseEntity<?> customResponseEntity = serviceFactory.getUserService().add(userDto);
        customResponseEntity.getResponseBody();

        /*ServiceFactory serviceFactory = new ServiceFactoryImpl();
        Credential credential = new Credential("romko", "qwerty");
        boolean add = serviceFactory.getCredentialService().add(credential);
        System.out.println(add);*/
//        List<CopyDto> copies = serviceFactory.getBookService().getAllCopiesByBookName("Господар у домі");
//        System.out.println(copies.size());  // 3
//        System.out.println(copies.get(0).getIsAvailable()); // false
//        System.out.println(copies.get(1).getIsAvailable()); // true

        /*ServiceFactory serviceFactory = new ServiceFactoryImpl();
        int bookQuantityPublishedFromYear = serviceFactory.getBookService().getBookQuantityPublishedFromYear(1990);
        System.out.println(bookQuantityPublishedFromYear);*/


       /* ServiceFactory serviceFactory = new ServiceFactoryImpl();
        List<UserStatisticDto> userStatistic = serviceFactory.getUserService().getUserStatistic(6);

        for (UserStatisticDto userStatisticDto : userStatistic) {

            System.out.println();
            System.out.println(userStatisticDto);
        }*/

        /*ServiceFactory serviceFactory = new ServiceFactoryImpl();
        List<BookDto> allByAuthor = serviceFactory.getBookService().getAllByAuthor("Author has co - author 2");

        for (BookDto bookDto : allByAuthor) {

            System.out.println(bookDto);
            System.out.println();
        }*/

        // Credential get

        /*ServiceFactory serviceFactory = new ServiceFactoryImpl();
        Credential roma = serviceFactory.getCredentialService().getByLogin("roma");
        System.out.println(roma);*/

        // User add

        /*Calendar calendar = Calendar.getInstance();
        calendar.set(1989, Calendar.JULY, 13);
        Date date = new Date(calendar.getTime().getTime());
        System.out.println(date);
        User user = new User("Roman Berezhnov", date);
        user.setRegistrationDate(new Timestamp(new java.util.Date().getTime()));
        ServiceFactory serviceFactory = new ServiceFactoryImpl();
        UserService userService = serviceFactory.getUserService();
        userService.add(user);*/

        DBConnectivity.closeConnection();
    }
}
