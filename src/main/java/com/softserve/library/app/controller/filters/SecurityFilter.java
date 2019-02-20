package com.softserve.library.app.controller.filters;

import com.softserve.library.app.constant.UrlPatterns;
import com.softserve.library.app.enums.patterns.CommonJSP;
import com.softserve.library.app.security.SecurityUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 *
 * @author Roman Berezhnov
 */
@WebFilter(UrlPatterns.ABSOLUTE)
public class SecurityFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        System.out.println(" ----------------------------------------------- Do filtering ... ");
        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) resp;

        System.out.println("Request login - " + request.getAttribute("login"));
        System.out.println("Request pass - " + request.getAttribute("login"));

        final String servletPath = request.getServletPath();
        final HttpSession session = request.getSession(false);
        final String requestedSessionId = request.getRequestedSessionId();
        System.out.println(" - - - Filter _ session id - " + requestedSessionId);

        SecurityUtils.checkSessionsLife();
        String role = null;

        if (servletPath.equals(UrlPatterns.INFO)
                || servletPath.equals(UrlPatterns.SIGNIN)
                || servletPath.equals(UrlPatterns.LOGOUT)) {

            chain.doFilter(request, response);
            return;
        }

        if (session != null) {

            System.out.println(" - - - Filter _ session _ get id - " + session.getId());
            role = SecurityUtils.getRoleOfLoggedUser(session);
            System.out.println("Session login - " + session.getAttribute("login"));
            System.out.println("Session pass - " + session.getAttribute("password"));
        }

        if (SecurityUtils.isSecurityPage(servletPath)) {

            if (role == null) {

                //todo: here can be saved redirect id and after success login forward to requested page !
                System.out.println(" - - - Filter _ security page without login - redirected ! - - - ");
                response.sendRedirect(UrlPatterns.SIGNIN);
                return;
            }

            final boolean hasPermission = SecurityUtils.hasPermission(servletPath, role);

            if (!hasPermission) {

                final RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(CommonJSP.ACCESS_DENIED.getPattern());
                System.out.println(" - - - Filter _ has no permission _ request dispatcher - " + dispatcher);
                dispatcher.forward(request, response);
                return;
            }
        }

        System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
        chain.doFilter(request, response);
    }
}
