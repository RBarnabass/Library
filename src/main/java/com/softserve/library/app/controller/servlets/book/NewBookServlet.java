package com.softserve.library.app.controller.servlets.book;

import com.softserve.library.app.constant.UrlPatterns;
import com.softserve.library.app.model.Author;
import com.softserve.library.app.model.Book;
import com.softserve.library.app.model.Publisher;
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
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author Roman Berezhnov
 */
@WebServlet(UrlPatterns.BOOK_ADD)
public class NewBookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/general/addBook.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println(" - - - New book servlet - - - ");

        final String bookName = req.getParameter("fullName");
        final String publishYear = req.getParameter("year");
        final String publisherName = req.getParameter("publisher");
        final String primaryAuthor = req.getParameter("main_author");
        final String coAuthor = req.getParameter("other_author");
        final String bookQuantity = req.getParameter("count");
        final RequestDispatcher dispatcherError = this.getServletContext().getRequestDispatcher("/WEB-INF/view/errors/Error500.jsp");

        int year;

        try {

            year = Integer.parseInt(publishYear);

        } catch (NumberFormatException e) {

            dispatcherError.forward(req, resp);
            return;
        }

        final Book book = new Book();
        book.setName(bookName);
        book.setPublishYear(year);

        final Publisher publisher = new Publisher();
        publisher.setName(publisherName);
        book.setPublisher(publisher);

        final List<Author> list = new ArrayList<>();
        final Author author = new Author();
        author.setName(primaryAuthor);
        author.setPrimary(true);
        list.add(author);

        final Author secondAuthor = new Author();
        secondAuthor.setName(coAuthor);
        secondAuthor.setPrimary(false);
        list.add(secondAuthor);
        book.setAuthors(list);

        final ServiceFactory serviceFactory = ServiceFactoryImpl.getFactory();
        boolean isSuccess;

        try {

            isSuccess = serviceFactory.getBookService().add(book);

        } catch (SQLException e) {

            dispatcherError.forward(req, resp);
            return;
        }

        if (!isSuccess) {

            dispatcherError.forward(req, resp);
            return;
        }

        final RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/general/addBook.jsp");
        dispatcher.forward(req, resp);
    }
}
