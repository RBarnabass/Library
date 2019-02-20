package com.softserve.library.app.controller.servlets.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

/**
 *
 *
 * @author Roman Berezhnov
 */
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



        // todo: create new user or user dto and send him to user service !!!
        // todo: getAllByOption some parameter from jsp if user want to update data !!!

    }
}
