package com.softserve.library.app.controller.servlets.book;

import com.softserve.library.app.model.Author;
import com.softserve.library.app.model.Book;
import com.softserve.library.app.model.Publisher;
import jdk.internal.dynalink.linker.LinkerServices;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/library/book")
public class BookPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Book book = new Book();
        book.setId(1);
        book.setName("My Book");
        Publisher publisher = new Publisher();
        publisher.setName("Publisher !!!");
        book.setPublisher(publisher);

        book.setPublishYear(1989);
        List<Author> list = new ArrayList<>();
        Author author = new Author();
        author.setName("One author");
        author.setPrimary(false);
        list.add(author);

        Author author1 = new Author();
        author1.setName("Two author");
        author1.setPrimary(true);
        list.add(author1);
        book.setAuthors(list);
        System.out.println(book);
        req.getSession().setAttribute("bookList", book);

        final RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/general/bookPage.jsp");
        dispatcher.forward(req, resp);
    }
}
