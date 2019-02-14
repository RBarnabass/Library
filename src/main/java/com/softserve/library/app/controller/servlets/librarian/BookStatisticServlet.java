package com.softserve.library.app.controller.servlets.librarian;

import com.softserve.library.app.constant.UrlPatterns;
import com.softserve.library.app.enums.patterns.LibrarianJSP;

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
@WebServlet(UrlPatterns.BOOK_STATISTIC)
public class BookStatisticServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(LibrarianJSP.BOOK_STATISTIC.getPattern());
        dispatcher.forward(req, resp);
    }
}
