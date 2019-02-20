package com.softserve.library.app.controller.servlets.book;

import com.softserve.library.app.constant.UrlPatterns;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(UrlPatterns.BOOK_SEARCH)
public class BookAdvancedSearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/general/advancedBookSearch.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println(req.getParameter("book"));
        System.out.println(req.getParameter("author"));
        System.out.println(req.getParameter("publisher"));
        System.out.println(req.getParameter("from"));
        System.out.println(req.getParameter("to"));
        System.out.println(req.getParameter("available"));

        final RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/general/advancedBookSearch.jsp");
        dispatcher.forward(req, resp);
    }
}
