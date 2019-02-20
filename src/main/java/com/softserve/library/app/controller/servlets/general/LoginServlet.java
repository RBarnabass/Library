package com.softserve.library.app.controller.servlets.general;

import com.softserve.library.app.constant.UrlPatterns;
import com.softserve.library.app.dto.ErrorDto;
import com.softserve.library.app.dto.SuccessfulLoginUserDto;
import com.softserve.library.app.enums.patterns.CommonJSP;
import com.softserve.library.app.http.CustomResponseEntity;
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

        //final CustomResponseEntity<?> customResponseEntity = serviceFactory.getUserService().checkLoginPasswordEquality(login, password);

        /*if (!customResponseEntity.getHttpStatus().isError()) {

           // final SuccessfulLoginUserDto responseBody = (SuccessfulLoginUserDto) customResponseEntity.getResponseBody();
            //SecurityUtils.storeLoggedUser(request.getSession(), responseBody);

           *//* if (responseBody.getRole().equals("user")) {
                System.out.println("___ user is logged ___");
            } else {
                System.out.println("___ else is logged ___");
            }*//*

        } else {

            //final ErrorDto responseBody = (ErrorDto) customResponseEntity.getResponseBody();
            request.setAttribute("errorMessage", responseBody.getErrorMessage());
            final RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(CommonJSP.LOGIN.getPattern());
            dispatcher.forward(request, response);
            return;
        }*/

        String redirect = request.getContextPath() + UrlPatterns.INFO;
        System.out.println(" - - - Login servlet _ success _ redirect to - " + redirect);
        response.sendRedirect(redirect);
    }
}