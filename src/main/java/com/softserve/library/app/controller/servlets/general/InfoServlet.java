package com.softserve.library.app.controller.servlets.general;

import com.softserve.library.app.constant.UrlPatterns;
import com.softserve.library.app.enums.patterns.CommonJSP;

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
@WebServlet({UrlPatterns.LIBRARY, UrlPatterns.INFO})
public class InfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(CommonJSP.INFO.getPattern());
        dispatcher.forward(request, response);
    }
}
