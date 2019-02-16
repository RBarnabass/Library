package com.softserve.library.app;

import com.softserve.library.app.config.DBConnectivity;
import com.softserve.library.app.dto.BookDto;
import com.softserve.library.app.dto.CopyDto;
import com.softserve.library.app.dto.DebtorDto;
import com.softserve.library.app.dto.UserStatisticDto;
import com.softserve.library.app.model.Credential;
import com.softserve.library.app.model.User;
import com.softserve.library.app.service.factory.ServiceFactory;
import com.softserve.library.app.service.factory.ServiceFactoryImpl;
import com.softserve.library.app.service.interfaces.UserService;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

/**
 *
 *
 * @author Roman Berezhnov
 */
public class Main {

    public static void main(String[] args) throws SQLException {

        ServiceFactory serviceFactory = new ServiceFactoryImpl();
        List<BookDto> list = serviceFactory.getBookService().getAll();
        for (BookDto bookDto : list) {
            System.out.println();
            System.out.println(bookDto);
        }

//        int numberOfOverallBookUsages = serviceFactory.getBookService().getNumberOfOverallBookUsages(10); // 3
//        System.out.println(numberOfOverallBookUsages);

//        int numberOfBookUsagesByCopy = serviceFactory.getBookService().getNumberOfBookUsagesByCopy(18);   // 5
//        System.out.println(numberOfBookUsagesByCopy);

//        int averageReadingTime = serviceFactory.getBookService().getAverageReadingTime(4);    // 66
//        System.out.println(averageReadingTime);

//        int bookQuantityPublishedFromYear = serviceFactory.getBookService().getBookQuantityPublishedFromYear(1990);
//        System.out.println(bookQuantityPublishedFromYear);

//        int averageUsers=Age = serviceFactory.getUserService().getAverageUserAge();  // 22
//        System.out.println(averageUserAge);

//        int averageAgeByBook = serviceFactory.getUserService().getAverageUserAgeByBook(1);  // 24
//        System.out.println(averageAgeByBook);

//        int daysUsing = serviceFactory.getUserService().getUsingLibraryTimeInDays(11);  // 365
//        System.out.println(daysUsing);


//        int averageAgeByAuthor = serviceFactory.getUserService().getAverageUserAgeByAuthor("Пітер Кері");  // 21
//        System.out.println(averageAgeByAuthor);

//        List<DebtorDto> debtors = serviceFactory.getUserService().getAllDebtors();
//        System.out.println(debtors.size()); // 4

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
