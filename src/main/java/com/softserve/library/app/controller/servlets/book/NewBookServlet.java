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

        // todo: call service and give him a new book !!!

    }
}
