package com.softserve.library.app.controller.security;

import com.softserve.library.app.model.Credential;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 *
 * @author Roman Berezhnov
 */
//@WebFilter("/*")
public class SecurityFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        System.out.println("--- Security filter --- ");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        final String servletPath = request.getServletPath();
        final Credential loggedUser = AppUtils.getLoggedUser(request.getSession());

        // if way was to login page, let it go
        if (servletPath.equals("/login")) {

            System.out.println("--- Security filter --- ( if (servletPath.equals(\"/login\")) {)");
            chain.doFilter(request, response);
            return;
        }

        HttpServletRequest wrapRequest = request;

        // If user are in session scope
        if (loggedUser != null) {

            System.out.println("--- Security filter --- ( if (loggedUser != null) {)");
            final String login = loggedUser.getLogin();
            final String roles = loggedUser.getRole().getType();

            // ???
            wrapRequest = new UserRoleRequestWrapper(login, roles, request);
        }

        if (SecurityUtils.isSecurityPage(request)) { // todo: last point...

            System.out.println("--- Security filter --- (if (SecurityUtils.isSecurityPage(request)) {)");

            if (loggedUser == null) {

                System.out.println("--- Security filter --- (if (loggedUser == null) {)");
                String requestUri = request.getRequestURI();

                // Сохранить текущую страницу для перенаправления (redirect) после успешного входа в систему.
                int redirectId = AppUtils.storeRedirectAfterLoginUrl(request.getSession(), requestUri);

                response.sendRedirect(wrapRequest.getContextPath() + "/login?redirectId=" + redirectId);
                return;
            }

            //boolean hasPermission = SecurityUtils.hasPermission(wrapRequest);

            /*if (!hasPermission) {

                System.out.println("--- Security filter --- (if (!hasPermission) {)");

                RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/accessDeniedView.jsp");
                dispatcher.forward(request, response);
                return;
            }*/
        }
        System.out.println("--- Security filter --- (before last chain)");
        chain.doFilter(wrapRequest, response);
    }

    @Override public void init(FilterConfig filterConfig) throws ServletException {

        System.out.println(" - - - Security filter was initialized ! - - -");
    }
    @Override public void destroy() {

        System.out.println(" - - - Security filter was destroyed ! - - -");
    }
}
