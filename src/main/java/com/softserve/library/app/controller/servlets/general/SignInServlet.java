package com.softserve.library.app.controller.servlets.general;

import com.softserve.library.app.constant.UrlPatterns;
import com.softserve.library.app.service.factory.ServiceFactory;
import com.softserve.library.app.service.factory.ServiceFactoryImpl;
import org.apache.commons.lang.RandomStringUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(UrlPatterns.SIGNIN)
public class SignInServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String serverSalt = RandomStringUtils.randomAlphanumeric(16);

        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/general/signIn.jsp");
        //request.setAttribute("serverSalt", serverSalt);
        request.setAttribute("serverSalt", "stub");

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServiceFactory serviceFactory = ServiceFactoryImpl.getFactory();

        String login = request.getParameter("login");
        String clientSalt = request.getParameter("data-clientSalt");
        String hashResponse = request.getParameter("data-hashResult");

        String serverSalt = "stub";

        boolean signed = false;

        // TODO: handle
        try {
            signed = serviceFactory.getUserService().compareHashes(login, serverSalt, clientSalt, hashResponse);
        } catch (SQLException e) {
            System.out.println("sql exception");
        } catch (NullPointerException e) {
            System.out.println("null pointer exception");
        }

        System.out.println(signed);
    }
}




