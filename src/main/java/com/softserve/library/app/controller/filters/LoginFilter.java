package com.softserve.library.app.controller.filters;

import javax.servlet.*;
import javax.servlet.Filter;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//todo: stuped filter !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

//@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse resp = (HttpServletResponse) response;
        final HttpSession session = req.getSession(false);
        String loginURI = req.getContextPath() + "/login";

        final boolean loggedIn = session != null && session.getAttribute("user") != null;
        final boolean loginRequest = req.getRequestURI().equals(loginURI);

        System.out.println("----- I filtered you !!! ----");

        if (loggedIn || loginRequest) {

            System.out.println("--- filter - do chain");
            //resp.sendRedirect("WEB-INF/view/welcome.jsp");
            chain.doFilter(req, resp);

        } else {

            System.out.println("--- filter - do redirect");
            resp.sendRedirect(loginURI);
        }
    }
}
