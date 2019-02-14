package com.softserve.library.app.controller.servlets.admin;

import com.softserve.library.app.enums.patterns.AdminJSP;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 *
 * @author Roman Berezhnov
 */
@WebServlet("/library/user_option")
public class UserOptionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(AdminJSP.USER_OPTION.getPattern());
        dispatcher.forward(req, resp);
    }
}
