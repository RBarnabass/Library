package com.softserve.library.app.controller.servlets.general;

import com.softserve.library.app.constant.UrlPatterns;

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
@WebServlet(UrlPatterns.LOGOUT)
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getSession().invalidate();
        System.out.println(" - - - Logout servlet _ session was invalidate and redirect to info page ! - - - ");
        response.sendRedirect(request.getContextPath() + "/library/info");
    }
}
