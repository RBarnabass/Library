package com.softserve.library.app.controller.security;

import com.softserve.library.app.model.Credential;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * @author Roman Berezhnov
 */
public class AppUtils {

    private static int REDIRECT_ID = 0;

    private static final Map<Integer, String> id_uri_map = new HashMap<>();
    private static final Map<String, Integer> uri_id_map = new HashMap<>();

    // Сохранить информацию пользователя в Session.
    public static void storeLoginedUser(HttpSession session, Credential loggedUser) {

        System.out.println(" - - - AppUtils - - - (storeLoggedUser)");
        // На JSP можно получить доступ через ${loginedUser}
        session.setAttribute("loggedUser", loggedUser);
    }

    // If user is logged already !
    public static Credential getLoggedUser(HttpSession session) {

        System.out.println(" - - - AppUtils - - - (getLoggedUser)");
        return (Credential) session.getAttribute("loggedUser");
    }

    public static int storeRedirectAfterLoginUrl(HttpSession session, String requestUri) {

        System.out.println(" - - - AppUtils - - - (storeRedirectAfterLoginUrl)");
        Integer id = uri_id_map.get(requestUri);

        if (id == null) {

            System.out.println(" - - - AppUtils - - - (storeRedirectAfterLoginUrl) - (if (id == null) {)");
            id = REDIRECT_ID++;

            uri_id_map.put(requestUri, id);
            id_uri_map.put(id, requestUri);

            return id;
        }
        return id;
    }

    public static String getRedirectAfterLoginUrl(HttpSession session, int redirectId) {

        System.out.println(" - - - AppUtils - - - (getRedirectAfterLoginUrl) - redId - " + redirectId);
        String url = id_uri_map.get(redirectId);

        if (url != null) {

            System.out.println(" - - - AppUtils - - - (getRedirectAfterLoginUrl) - (if (url != null) {) - url - " + url);
            return url;
        }
        return null;
    }

}
