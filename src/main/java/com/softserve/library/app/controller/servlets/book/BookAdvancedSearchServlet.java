package com.softserve.library.app.controller.servlets.book;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.softserve.library.app.dto.BookDto;
import com.softserve.library.app.dto.BookParametersDto;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(UrlPatterns.BOOK_SEARCH)
public class BookAdvancedSearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/general/advancedBookSearch.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BookParametersDto bookParametersDto = new BookParametersDto();

        final boolean isAvailable = req.getParameter("available") != null;
        final String name = req.getParameter("book").equals("") ? null : req.getParameter("book");
        final String author = req.getParameter("author").equals("") ? null : req.getParameter("author");
        final String publisher = req.getParameter("publisher").equals("") ? null : req.getParameter("publisher");
        final int yearFrom = req.getParameter("from").equals("") ? 0 : Integer.parseInt(req.getParameter("from"));
        final int yearTo = req.getParameter("to").equals("") ? 0 : Integer.parseInt(req.getParameter("to"));

        bookParametersDto.setName(name);
        bookParametersDto.setAuthor(author);
        bookParametersDto.setPublisher(publisher);
        bookParametersDto.setYearPublishedFrom(yearFrom);
        bookParametersDto.setYearPublishedTo(yearTo);
        bookParametersDto.setAvailable(isAvailable);

<<<<<<< HEAD
        ServiceFactory serviceFactory = ServiceFactoryImpl.getFactory();

        List<BookDto> books = new ArrayList<>();
||||||| merged common ancestors
        ServiceFactory serviceFactory = ServiceFactoryImpl.getFactory();

        List<Book> books = new ArrayList<>();
=======
        final ServiceFactory serviceFactory = ServiceFactoryImpl.getFactory();
        List<Book> books = new ArrayList<>();
>>>>>>> aba3c743fd12c404c5cd021efb3ee3459b7d1b10

        try {

            books = serviceFactory.getBookService().getAllByParameters(bookParametersDto);
<<<<<<< HEAD
            resp.setStatus(resp.SC_CREATED);
        } catch (SQLException e) {
||||||| merged common ancestors
        } catch (SQLException e) {
=======
>>>>>>> aba3c743fd12c404c5cd021efb3ee3459b7d1b10

        } catch (SQLException e) {

            final RequestDispatcher dispatcherError = this.getServletContext().getRequestDispatcher("/WEB-INF/view/errors/Error500.jsp");
            dispatcherError.forward(req, resp);
            return;
        }

<<<<<<< HEAD
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonList = gson.toJson(books);

        HttpSession session = req.getSession(false);
        session.setAttribute("books", jsonList);

        final String redirect = req.getContextPath() + UrlPatterns.BOOK_LIST;
        resp.sendRedirect(redirect);
||||||| merged common ancestors
        System.out.println();

        final RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/general/advancedBookSearch.jsp");
        dispatcher.forward(req, resp);
=======
        final RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/general/advancedBookSearch.jsp");
        dispatcher.forward(req, resp);
>>>>>>> aba3c743fd12c404c5cd021efb3ee3459b7d1b10
    }
}
