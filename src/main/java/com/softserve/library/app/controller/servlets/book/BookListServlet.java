package com.softserve.library.app.controller.servlets.book;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.softserve.library.app.constant.UrlPatterns;
import com.softserve.library.app.dto.BookDto;
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

@WebServlet(UrlPatterns.BOOK_LIST)
public class BookListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session.getAttribute("books") == null) {

            ServiceFactory serviceFactory = ServiceFactoryImpl.getFactory();

            List<BookDto> books = new ArrayList<>();

            try {

                books = serviceFactory.getBookService().getAll();
            } catch (SQLException e) {

                System.out.println("sql exception");
            }

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonList = gson.toJson(books);
            session.setAttribute("books", jsonList);
        }

        final RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/general/bookListPage.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
