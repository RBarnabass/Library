package com.softserve.library.app.controller.servlets.user;

import com.softserve.library.app.constant.UrlPatterns;
import com.softserve.library.app.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(UrlPatterns.USER_PAGE)
public class UserPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = new User();
        user.setFullName("Vasia Pupkin");
        user.setBirthDate(LocalDate.parse("1989-01-01"));
        user.setLogin("avatar");

        req.getSession().setAttribute("user", user);

        final RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/general/userPage.jsp");
        dispatcher.forward(req, resp);
    }
}
