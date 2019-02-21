package com.softserve.library.app.controller.servlets.user;

import com.softserve.library.app.constant.UrlPatterns;
import com.softserve.library.app.model.User;
import com.softserve.library.app.security.SecurityUtils;
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
import java.time.LocalDate;

@WebServlet(UrlPatterns.USER_PAGE)
public class UserPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final ServiceFactory serviceFactory = ServiceFactoryImpl.getFactory();
        final int loggedUserId = SecurityUtils.getLoggedUserId(req.getSession());
        User user = null;

        try {
            user = serviceFactory.getUserService().get(loggedUserId);
        } catch (SQLException e) {
            System.out.println(" - - - User page servlet _ getAllByOptions user by id exception ! - - - ");
        }

        req.getSession().setAttribute("user", user);
        final RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/general/userPage.jsp");
        dispatcher.forward(req, resp);
    }
}
