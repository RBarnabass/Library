package com.softserve.library.app.controller.servlets.general;

import com.softserve.library.app.constant.UrlPatterns;
import com.softserve.library.app.enums.patterns.CommonJSP;
import com.softserve.library.app.model.Credential;
import com.softserve.library.app.security.SecurityUtils;
import com.softserve.library.app.service.factory.ServiceFactory;
import com.softserve.library.app.service.factory.ServiceFactoryImpl;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 *
 * @author Roman Berezhnov
 */
@WebServlet(UrlPatterns.LOGIN)
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(CommonJSP.LOGIN.getPattern());
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        ServiceFactory serviceFactory = ServiceFactoryImpl.getFactory();
        Credential credential;

        // todo: check login and password before go to DB !!!
        try {

            // todo: save user id some where !!!
            credential = serviceFactory.getCredentialService().getByLogin(login);

        } catch (SQLException e) {

            System.out.println(" - - - Exception - - - Login servlet");
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(CommonJSP.LOGIN.getPattern());
            dispatcher.forward(request, response);
            return;
        }

        // todo: check password here and set null if not correct !!!
        // todo: now we use encoder for pass so that should be changed !!!

        if (credential == null || !credential.getPassword().equals(password)) {

            String errorMessage = "Invalid login or password";
            request.setAttribute("errorMessage", errorMessage);

            System.out.println();
            System.out.println(" - - - Login servlet _ credential == null or incorrect pass ! - - - ");
            System.out.println();

            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(CommonJSP.LOGIN.getPattern());
            dispatcher.forward(request, response);
            return;
        }

        SecurityUtils.storeLoggedUser(request.getSession(), credential);

        // todo: case role - case redirect !!!
        String redirect = request.getContextPath() + UrlPatterns.INFO;
        System.out.println(" - - - Login servlet _ success _ redirect to - " + redirect);
        response.sendRedirect(redirect);
    }
}
