package com.softserve.library.app.controller.servlets.newOne;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 *
 * @author Roman Berezhnov
 */
//@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
        dispatcher.forward(request, response);
    }

    /*@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        ServiceFactory serviceFactory = new ServiceFactoryImpl();
        Credential credential = null;

        // todo: check name and password before go to DB !!!
        try {

            credential = serviceFactory.getCredentialService().getByLogin(userName);

        } catch (SQLException e) {

            e.printStackTrace();
        }

        if (credential == null || !credential.getPassword().equals(password)) {

            String errorMessage = "Invalid userName or Password";
            request.setAttribute("errorMessage", errorMessage);

            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
            dispatcher.forward(request, response);

            return;
        }

        AppUtils.storeLoggedUser(request.getSession(), credential);

        int redirectId = -1;

        try {

            redirectId = Integer.parseInt(request.getParameter("redirectId"));

        } catch (Exception e) {

            e.printStackTrace();
        }

        String requestUri = AppUtils.getRedirectAfterLoginUrl(request.getSession(), redirectId);

        if (requestUri != null) {

            response.sendRedirect(requestUri);

        } else {

            // По умолчанию после успешного входа в систему
            // перенаправить на страницу /userInfo
            response.sendRedirect(request.getContextPath() + "/userInfo");
        }
    }*/
}
