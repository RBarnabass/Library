package com.softserve.library.app.security;

import com.softserve.library.app.model.Credential;
import javax.servlet.http.HttpSession;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 *
 *
 * @author Roman Berezhnov
 */
public class SecurityUtils {

    private static final Map<String, String> sessions = new ConcurrentHashMap<>();
    private static final int SESSION_LIFETIME_IN_SECONDS = 1800;

    public static Credential getLoggedUser(HttpSession session) {

        if (sessions.containsKey(session.getId())) {

            System.out.println(" - - - Session id is correct !!! - - - ");
           // return sessions.get(session.getId());
        } else {
            System.out.println(" - - - Session id is NOT correct !!! - - - ");
            //return null;
        }

        return (Credential) session.getAttribute("credential");
    }

    public static void storeLoggedUser(HttpSession session, Credential credential) {

        System.out.println(" - - - User was saved in session ! - - - ");

        // todo: do not hold pass and login in session !!!

        // todo: create new entity and map container (token) for holding session id and role with last activity touch. And check this container every filtering !!!

        session.setMaxInactiveInterval(SESSION_LIFETIME_IN_SECONDS);
        sessions.put(session.getId(), credential.getRole().getType());

        session.setAttribute("credential", credential);
    }

    public static boolean isSecurityPage(String servletPath) {

        final Set<String> allRoles = SecurityConfig.getAllRoles();

        for (String role : allRoles) {

            List<String> urlPatterns = SecurityConfig.getUrlPatternsForRole(role);

            if (urlPatterns != null && urlPatterns.contains(servletPath)) {

                System.out.println(" - - - SecurityUtils - - - (isSecurityPage) - (true) - " + servletPath);
                return true;
            }
        }
        System.out.println(" - - - SecurityUtils - - - (isSecurityPage) - (false) - " + servletPath);
        return false;
    }

    public static boolean hasPermission(String servletPath, String role) {

        System.out.println(" - - - SecurityUtils - - - ask for permission - - - ");

        Set<String> allRoles = SecurityConfig.getAllRoles();

        if (allRoles.contains(role)) {

            List<String> urlPatternsForRole = SecurityConfig.getUrlPatternsForRole(role);

            return urlPatternsForRole.contains(servletPath);
        }

        /*for (String role : allRoles) {

            if (!request.isUserInRole(role)) {

                System.out.println(" - - - SecurityUtils - - - (hasPermission) - (continue) - " + role);
                continue;
            }

            List<String> urlPatterns = SecurityConfig.getUrlPatternsForRole(role);

            if (urlPatterns != null && urlPatterns.contains(urlPattern)) {

                System.out.println(" - - - SecurityUtils - - - (hasPermission) - (true)");
                return true;
            }
        }
        System.out.println(" - - - SecurityUtils - - - (hasPermission) - (false)");*/

        return false;
    }
}
