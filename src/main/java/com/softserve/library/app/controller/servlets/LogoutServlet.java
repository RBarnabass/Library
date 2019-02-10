package com.softserve.library.app.controller.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Logout servlet", urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final HttpSession session = req.getSession(false);

        session.removeAttribute("login");
        session.removeAttribute("password");
        session.removeAttribute("role");

        resp.sendRedirect("/");
    }

    @Override
    public void init() throws ServletException {

        System.out.println(" - - - Logout servlet was initialized !");
    }

    @Override
    public void destroy() {

        System.out.println(" - - - Logout servlet was destroyed !");
    }
}
