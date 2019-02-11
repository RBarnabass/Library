package com.softserve.library.app.controller.servlets;

import com.softserve.library.app.model.Credential;
import com.softserve.library.app.service.factory.ServiceFactory;
import com.softserve.library.app.service.factory.ServiceFactoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.nonNull;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        Map<String, String> messages = new HashMap<>();

        if (login == null || login.isEmpty()) {
            messages.put("login", "Please enter username");
        }
        if (password == null || password.isEmpty()) {
            messages.put("password", "Please enter password");
        }

        if (messages.isEmpty()) {

            ServiceFactory serviceFactory = new ServiceFactoryImpl();
            Credential credential = null;

            try {

                credential = serviceFactory.getCredentialService().getByLogin(login);

            } catch (SQLException e) {

                e.printStackTrace();
            }

           if (nonNull(credential)) {

               if (credential.getPassword().equals(password)) {

                   if (credential.getRole().getType().equals("user")) {

                       System.out.println(" -------------------------------------------------------- I am here !");
                       request.setAttribute("login", credential.getLogin());
                       request.setAttribute("password", credential.getPassword());
                       request.setAttribute("role", credential.getRole().getType());
                       System.out.println(" --- redirect to - " + request.getContextPath() + "/welcome");
                       response.sendRedirect(request.getContextPath() + "/welcome");
                       return;

                   } else {

                       System.out.println(" ---- and here (( !");

                       request.setAttribute("error", "Unknown login, try again");
                       request.getRequestDispatcher("/view/login.jsp").forward(request, response);
                       messages.put("login", "Unknown login, please try again");
                   }
               }
           }
        }

        request.setAttribute("messages", messages);
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

}
