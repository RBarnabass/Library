package com.softserve.library.app.controller.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "MainServlet", urlPatterns = "/library")
public class MainServlet extends HttpServlet {






    @Override public void init() {
        System.out.println(" - - - Main servlet was initialized !");
    }
    @Override public void destroy() {
        System.out.println(" - - - Main servlet was destroyed !");
    }
}
