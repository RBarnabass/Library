package com.softserve.library.app.controller.servlets.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet
public class NewUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println(" - - - New user servlet - - - ");

        final String fullName = req.getParameter("userName");
        final String birthDate = req.getParameter("birthDate");
        final String login = req.getParameter("login");
        final String password = req.getParameter("password");
        final String role = req.getParameter("role");

        if (fullName == null || birthDate == null || login == null || password == null || role == null) {

            System.out.println(" - - - New user servlet _ some parameter is null ! - - - ");
            // todo: redirect to new user page with error message !
            resp.sendRedirect("");
            return;
        }

        if (fullName.isEmpty() || birthDate.isEmpty() || login.isEmpty() || password.isEmpty() || role.isEmpty()) {

            System.out.println(" - - - New user servlet _ some parameter is empty ! - - - ");
            // todo: redirect to new user page with error message !
            resp.sendRedirect("");
            return;
        }

        // todo: validate all this parameters !!!
        // todo: create new user or user dto and send him to user service !!!
        // todo: receive boolean from DB and continue if success !!!

    }
}
