package com.softserve.library.app.controller.servlets;

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
@WebServlet(name = "hey", urlPatterns = "/welcome")
public class HeyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("-------------------------------------Hey servlet------------------------------------");
        req.getRequestDispatcher("WEB-INF/view/welcome.jsp").forward(req, resp);
    }
}
