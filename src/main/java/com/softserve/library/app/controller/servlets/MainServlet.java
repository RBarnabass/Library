package com.softserve.library.app.controller.servlets;

import javax.servlet.DispatcherType;
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
@WebServlet(name = "MainServlet", urlPatterns = "/library")
public class MainServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DispatcherType dispatcherType = req.getDispatcherType();
        System.out.println("Disp type - " + dispatcherType);
        System.out.println("Session - " + req.getSession());
        System.out.println("Auth - " + req.authenticate(resp));
        System.out.println("Auth type - " + req.getAuthType());
        System.out.println("req session id -" + req.getRequestedSessionId());
        RequestDispatcher view = req.getRequestDispatcher("main.jsp");
        view.forward(req, resp);

    }

    @Override public void init() {
        System.out.println(" - - - Main servlet was initialized !");
    }
    @Override public void destroy() {
        System.out.println(" - - - Main servlet was destroyed !");
    }
}
