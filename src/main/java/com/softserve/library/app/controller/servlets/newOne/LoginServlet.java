package com.softserve.library.app.controller.servlets.newOne;


import javax.servlet.http.HttpServlet;

/**
 *
 *
 * @author Roman Berezhnov
 */
//@WebServlet("/login")
public class LoginServlet extends HttpServlet {


    /*@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


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
