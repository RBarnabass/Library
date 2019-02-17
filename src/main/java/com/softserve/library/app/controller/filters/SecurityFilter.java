package com.softserve.library.app.controller.filters;

import com.softserve.library.app.constant.UrlPatterns;
import com.softserve.library.app.enums.patterns.CommonJSP;
import com.softserve.library.app.security.SecurityUtils;
import com.softserve.library.app.model.Credential;
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

        System.out.println(" - - - Do filtering ... - - - ");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        final String servletPath = request.getServletPath();
        System.out.println(" - - - Filter _ servlet path - " + servletPath);

        final HttpSession session = request.getSession(false);
        System.out.println(" - - - Filter _ session - " + session);

        final String requestedSessionId = request.getRequestedSessionId();
        System.out.println(" - - - Filter _ session id - " + requestedSessionId);

        final String requestURI = request.getRequestURI();
        System.out.println(" - - - Filter _ request URI - " + requestURI);

        System.out.println();

        Credential credential = null;

        if (session != null) {

            System.out.println(" - - - Filter _ session _ is new - " + session.isNew());
            System.out.println(" - - - Filter _ session _ get id - " + session.getId());
            System.out.println();

            credential = SecurityUtils.getLoggedUser(session);

            System.out.println(" - - - credential - " + credential);
            System.out.println();
        }

        if (servletPath.equals(UrlPatterns.INFO)
                || servletPath.equals(UrlPatterns.LOGIN)
                || servletPath.equals(UrlPatterns.LOGOUT)) {

            // todo: here can be created session for general, maybe !

            System.out.println(" - - - Filter _ request for general urls - - -");
            System.out.println();

            chain.doFilter(request, response);
            return;
        }

        String role = null;

        if (credential != null) {

            role = credential.getRole().getType();

            System.out.println(" - - - Filter _ credential not null _ role - " + role);
            System.out.println();
        }

        if (SecurityUtils.isSecurityPage(servletPath)) {

            if (credential == null) {

                //todo: here can be saved redirect id and after success login forward to requested page !
                System.out.println(" - - - Filter _ security page without login - redirected ! - - - ");
                response.sendRedirect(UrlPatterns.LOGIN);
                return;
            }

            boolean hasPermission = SecurityUtils.hasPermission(servletPath, role);

            if (!hasPermission) {

                RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(CommonJSP.ACCESS_DENIED.getPattern());

                System.out.println();
                System.out.println(" - - - Filter _ has no permission _ request dispatcher - " + dispatcher);
                System.out.println();

                dispatcher.forward(request, response);
                return;
            }
        }

        System.out.println();
        System.out.println(" - - - Filter _ all correct _ do filter in last point ! - - - ");
        System.out.println();

        System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
        chain.doFilter(request, response);
    }




    @Override public void init(FilterConfig filterConfig) throws ServletException {

        System.out.println(" - - - Security filter created ! - - - ");
    }
    @Override public void destroy() {

        System.out.println(" - - - Security filter destroyed ! - - - ");
    }
}
