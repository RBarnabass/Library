package com.softserve.library.app.controller.servlets.book;

import com.softserve.library.app.constant.UrlPatterns;
import com.softserve.library.app.model.Book;
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

@WebServlet(UrlPatterns.BOOK_PAGE)
public class BookPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String bookId = req.getParameter("bookId");
        final RequestDispatcher dispatcherError = this.getServletContext().getRequestDispatcher("/WEB-INF/view/errors/Error500.jsp");
        final ServiceFactory serviceFactory = ServiceFactoryImpl.getFactory();

        int id;
        Book book;

        try {

            id = Integer.parseInt(bookId);

        } catch (NumberFormatException e) {

            dispatcherError.forward(req, resp);
            return;
        }

        try {

            book = serviceFactory.getBookService().get(id);

        } catch (SQLException e) {

            dispatcherError.forward(req, resp);
            return;
        }

        if (book == null) {

            final RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/errors/Error404.jsp");
            dispatcher.forward(req, resp);
            return;
        }

        req.getSession().setAttribute("bookList", book);
        final RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/general/bookPage.jsp");
        dispatcher.forward(req, resp);
    }
}
