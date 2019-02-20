package com.softserve.library.app.controller.servlets.general;

import com.softserve.library.app.constant.UrlPatterns;
import com.softserve.library.app.model.User;
import com.softserve.library.app.security.SecurityUtils;
import com.softserve.library.app.service.factory.ServiceFactory;
import com.softserve.library.app.service.factory.ServiceFactoryImpl;
import org.apache.commons.lang.RandomStringUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(UrlPatterns.SIGNIN)
public class SignInServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final String serverSalt = RandomStringUtils.randomAlphanumeric(16);

        //request.setAttribute("serverSalt", serverSalt);
        request.setAttribute("serverSalt", "stub");

        final RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/general/signIn.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final ServiceFactory serviceFactory = ServiceFactoryImpl.getFactory();
        final HttpSession session = request.getSession(false);
        final String login = request.getParameter("login");
        final String clientSalt = request.getParameter("data-clientSalt");
        final String hashResponse = request.getParameter("data-hashResult");
        final String serverSalt = "stub";

        boolean signed = false;

        // TODO: handle
        try {
            signed = serviceFactory.getUserService().compareHashes(login, serverSalt, clientSalt, hashResponse);
        } catch (SQLException e) {
            System.out.println("sql exception");
        } catch (NullPointerException e) {
            System.out.println("null pointer exception");
        }

        if (!signed) {

            final RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/general/signIn.jsp");
            dispatcher.forward(request, response);
            return;
        }

        User user = null;

        try {
            user = serviceFactory.getUserService().getByLogin(login);
        } catch (SQLException e) {
            System.out.println(" - - - Login servlet _ SQL Exception when get by login ! - - - ");
        }

        if (user == null) {
            final RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/general/signIn.jsp");
            dispatcher.forward(request, response);
            return;
        }

        SecurityUtils.storeLoggedUser(session, user);
        final RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/general/userPage.jsp");
        dispatcher.forward(request, response);
    }
}