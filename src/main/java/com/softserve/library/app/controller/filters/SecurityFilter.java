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

        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) resp;
        final String servletPath = request.getServletPath();
        final HttpSession session = request.getSession(false);

        SecurityUtils.checkSessionsLife();
        String role = null;

        if (servletPath.equals(UrlPatterns.INFO)
                || servletPath.equals(UrlPatterns.SIGNIN)
                || servletPath.equals(UrlPatterns.LOGOUT)
                || servletPath.equals(UrlPatterns.SIGNUP)) {

            chain.doFilter(request, response);
            return;
        }

        if (session != null) {

            role = SecurityUtils.getRoleOfLoggedUser(session);
        }

        if (SecurityUtils.isSecurityPage(servletPath)) {

            if (role == null) {

                response.sendRedirect(UrlPatterns.SIGNIN);
                return;
            }

            final boolean hasPermission = SecurityUtils.hasPermission(servletPath, role);

            if (!hasPermission) {

                final RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(CommonJSP.ACCESS_DENIED.getPattern());
                dispatcher.forward(request, response);
                return;
            }
        }

        System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
        chain.doFilter(request, response);
    }
}
