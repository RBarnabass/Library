package com.softserve.library.app.controller.servlets.book;

import com.softserve.library.app.constant.UrlPatterns;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

        final String bookId = req.getParameter("bookId");
        final String bookName = req.getParameter("bookName");
        final String publishYear = req.getParameter("publishYear");

        final String publisherId = req.getParameter("publisherId");
        final String publisherName = req.getParameter("publisherName");

        final String primaryAuthorId = req.getParameter("primaryAuthorId");
        final String primaryAuthor = req.getParameter("primaryAuthor");

        final String coAuthorId = req.getParameter("coAuthorId");
        final String coAuthor = req.getParameter("coAuthor");
        final String bookQuantity = req.getParameter("bookQuantity");

        // todo: call service and give him a new book !!!


        final RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/general/addBook.jsp");
        dispatcher.forward(req, resp);
    }
}
