package com.softserve.library.app.controller.mySecurityTest.freeServlets;

import com.softserve.library.app.controller.mySecurityTest.security.SecurityUtils;
import com.softserve.library.app.controller.security.AppUtils;
import com.softserve.library.app.model.Credential;
import com.softserve.library.app.service.factory.ServiceFactory;
import com.softserve.library.app.service.factory.ServiceFactoryImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/library/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/viewTest/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        ServiceFactory serviceFactory = new ServiceFactoryImpl();
        Credential credential = null;

        // todo: check name and password before go to DB !!!
        try {

            credential = serviceFactory.getCredentialService().getByLogin(login);

        } catch (SQLException e) {

            e.printStackTrace();
        }

        if (credential == null || !credential.getPassword().equals(password)) {

            String errorMessage = "Invalid userName or Password";
            request.setAttribute("errorMessage", errorMessage);

            System.out.println();
            System.out.println(" - - - Login servlet _ credential == null or incorrect pass ! - - - ");
            System.out.println();

            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/viewTest/login.jsp");
            dispatcher.forward(request, response);

            return;
        }

        SecurityUtils.storeLoggedUser(request.getSession(), credential);

        String redirect = request.getContextPath() + "/library/book_list";

        System.out.println(" - - - Login servlet _ success _ redirect to - " + redirect);

        response.sendRedirect(redirect);
    }
}
