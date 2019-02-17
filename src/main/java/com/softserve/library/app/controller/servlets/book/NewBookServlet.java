package com.softserve.library.app.controller.servlets.book;

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
@WebServlet
public class NewBookServlet extends HttpServlet {

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

        if (bookId == null || bookId.isEmpty()) {

            if (bookName == null || bookName.isEmpty() || publishYear == null || publishYear.isEmpty()) {
                // todo: redirect !!!
            }

            // todo: bookDto add book parameters

        } else {

            // todo: cast to int !!!
            // todo: bookDto add book id
        }

        if (publisherId == null || publisherId.isEmpty()) {

            if (publisherName == null || publisherName.isEmpty()) {
                // todo: redirect !!!
            }

            // todo: bookDto add publisher parameters

        } else {

            // todo: cast to int !!!
            // todo: bookDto add publisher id
        }

        if (primaryAuthorId == null || primaryAuthorId.isEmpty()) {

            if (primaryAuthor == null || primaryAuthor.isEmpty()) {
                // todo: redirect !!!
            }

            // todo: bookDto add primary author parameters

        } else {

            // todo: cast to int !!!
            // todo: bookDto add primary author id
        }

        if (coAuthorId == null || coAuthorId.isEmpty()) {

            if (coAuthor != null && !coAuthor.isEmpty()) {
                // todo: bookDto add co author parameters
            }
        } else {

            // todo: cast to int !!!
            // todo: bookDto add co author id
        }

        if (bookQuantity == null || bookQuantity.isEmpty()) {
            // todo: redirect !!!
        } else {
            // todo: cast to int
        }


        // todo: call service and give him a new book !!!

    }
}
