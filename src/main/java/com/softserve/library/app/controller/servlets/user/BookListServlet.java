package com.softserve.library.app.controller.servlets.user;

import com.softserve.library.app.constant.UrlPatterns;
import com.softserve.library.app.dto.BookDto;
import com.softserve.library.app.enums.patterns.UserJSP;
import com.softserve.library.app.service.factory.ServiceFactory;
import com.softserve.library.app.service.factory.ServiceFactoryImpl;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 *
 * @author Roman Berezhnov
 */
@WebServlet(UrlPatterns.BOOK_LIST)
public class BookListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServiceFactory serviceFactory = ServiceFactoryImpl.getFactory();
        List<BookDto> all = null;

        try {
            all = serviceFactory.getBookService().getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.getSession().setAttribute("bookList", all);

        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(UserJSP.BOOK_LIST.getPattern());
        dispatcher.forward(req, resp);
    }
}
