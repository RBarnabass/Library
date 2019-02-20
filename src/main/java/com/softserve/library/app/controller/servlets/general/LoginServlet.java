
package com.softserve.library.app.controller.servlets.general;

import com.softserve.library.app.constant.UrlPatterns;
import com.softserve.library.app.enums.patterns.CommonJSP;
import com.softserve.library.app.service.factory.ServiceFactory;
import com.softserve.library.app.service.factory.ServiceFactoryImpl;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 *
 * @author Roman Berezhnov
 */
//@WebServlet(UrlPatterns.LOGIN)
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(CommonJSP.LOGIN.getPattern());
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final String login = request.getParameter("login");
        final String password = request.getParameter("password");

        final ServiceFactory serviceFactory = ServiceFactoryImpl.getFactory();



        String redirect = request.getContextPath() + UrlPatterns.INFO;
        System.out.println(" - - - Login servlet _ success _ redirect to - " + redirect);
        response.sendRedirect(redirect);
    }
}