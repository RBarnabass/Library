package com.softserve.library.app.controller.servlets.general;

import com.softserve.library.app.constant.UrlPatterns;
import com.softserve.library.app.model.User;
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
import java.time.LocalDate;

@WebServlet(UrlPatterns.SIGNUP)
public class SignUpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/general/signUp.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServiceFactory serviceFactory = ServiceFactoryImpl.getFactory();

        User user = new User();

        user.setFullName(request.getParameter("fullName"));
        user.setBirthDate(LocalDate.parse(request.getParameter("birthDate")));
        user.setLogin(request.getParameter("login"));
        user.setPassword(request.getParameter("password"));
        user.setRole_id((request.getParameter("isAdmin") == null) ? 1 : 2);

        // TODO: handle exception
        try {
            serviceFactory.getUserService().add(user);
        } catch (SQLException e) {
            System.out.println("whoa exception xd");
        }

        String redirect = request.getContextPath() + UrlPatterns.LOGIN;
        response.sendRedirect(redirect);
    }
}
