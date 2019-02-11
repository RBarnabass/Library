package com.softserve.library.app.controller.filters;

import com.softserve.library.app.model.Credential;
import com.softserve.library.app.service.factory.ServiceFactory;
import com.softserve.library.app.service.factory.ServiceFactoryImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import static java.util.Objects.nonNull;

/**
 *
 *
 * @author Roman Berezhnov
 */
@WebFilter("/*")
public class Filter implements javax.servlet.Filter {

    @Override public void init(FilterConfig filterConfig) throws ServletException {

        System.out.println(" - - - Main filter was initialized !");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse resp = (HttpServletResponse) response;

        final String login = req.getParameter("login");
        final String password = req.getParameter("password");
        final HttpSession session = req.getSession(false);

        System.out.println("login - " + login);
        System.out.println("pass - " + password);
        System.out.println("session - " + session);

        boolean q1 = false;
        boolean q2 = false;
        boolean q3 = false;

        if ((q1 = nonNull(session))
                && (q2 = nonNull(session.getAttribute("login")))
                && (q3 = nonNull(session.getAttribute("password")))) {

            final String role = (String) session.getAttribute("role");

            //chain.doFilter(req, resp);
            System.out.println("--------- I am not null in filter --------------");
            moveToMenu(req, resp, role);

        } else if (!(login == null || login.isEmpty()) && !(password == null || password.isEmpty())) {


                ServiceFactory serviceFactory = new ServiceFactoryImpl();
                Credential credential = null;

                try {

                    credential = serviceFactory.getCredentialService().getByLogin(login);

                } catch (SQLException e) {

                    e.printStackTrace();
                }

                System.out.println("--- i before credential servlet ---");

                if (nonNull(credential)) {

                    if (credential.getPassword().equals(password)) {

                        System.out.println("--- i before role servlet ---");

                        if (credential.getRole().getType().equals("user")) {

                            System.out.println(" -------------------------------------------------------- I am here !");
                            request.setAttribute("login", credential.getLogin());
                            request.setAttribute("password", credential.getPassword());
                            request.setAttribute("role", credential.getRole().getType());
                            System.out.println(" --- redirect to - " + req.getContextPath() + "/welcome");
                            //resp.sendRedirect(req.getContextPath() + "/welcome");
                            //return;

                        } else {

                            System.out.println(" ---- and here (( !");

                            request.setAttribute("error", "Unknown login, try again");
                            request.getRequestDispatcher("/view/login.jsp").forward(request, response);

                        }
                    }
                }

            System.out.println(" -- move to in second else");
            moveToMenu(req, resp, (String) request.getAttribute("role"));

        } else {

            System.out.println(q1);
            System.out.println(q2);
            System.out.println(q3);
            System.out.println("---- i am unknown ----");
            moveToMenu(req, resp, "unknown");
        }
    }

    private void moveToMenu(final HttpServletRequest request,
                            final HttpServletResponse response,
                            final String role)
            throws ServletException, IOException {

        if (role.equals("user")) {

            System.out.println("--- i forward to user page ----");
            request.getRequestDispatcher("/WEB-INF/view/user_page.jsp").forward(request, response);

        } else if (role.equals("unknown")) {
            System.out.println("--- i forward to login page ----");

            request.getRequestDispatcher("WEB-INF/view/login.jsp").forward(request, response);
        }
    }

    @Override public void destroy() {

        System.out.println(" - - - Main filter was destroyed !");
    }
}
