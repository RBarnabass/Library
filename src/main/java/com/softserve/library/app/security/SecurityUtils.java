package com.softserve.library.app.security;

import com.softserve.library.app.model.User;

import javax.servlet.http.HttpSession;
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

    private static final Map<String, Token> tokens = new ConcurrentHashMap<>();
    private static final int MAX_SESSION_LIFETIME_IN_SECONDS = 1800;

    public static String getRoleOfLoggedUser(HttpSession session) {

        if (tokens.containsKey(session.getId())) {

            System.out.println(" - - - Session id is correct !!! - - - ");
            setTokenLastAccessTime(session.getId(), session.getLastAccessedTime());
            return tokens.get(session.getId()).getRole();
        }

        System.out.println(" - - - Session id is NOT correct !!! - - - ");
        return null;
    }
    public static int getLoggedUserId(HttpSession session) {

        if (tokens.containsKey(session.getId())) {

            setTokenLastAccessTime(session.getId(), session.getLastAccessedTime());
            return tokens.get(session.getId()).getUserId();
        }
        return 0;
    }
    public static void storeLoggedUser(HttpSession session, User user) {

        session.setMaxInactiveInterval(MAX_SESSION_LIFETIME_IN_SECONDS);
        final Token token = new Token(session.getLastAccessedTime(), user.getRole().getType(), user.getId());
        tokens.put(session.getId(), token);
        System.out.println("_____ tokens pack size is - " + tokens.size() + " _______________________________________________________");
    }
    public static boolean isSecurityPage(String servletPath) {

        final Set<String> allRoles = SecurityConfig.getAllRoles();

        for (String role : allRoles) {

            final List<String> urlPatterns = SecurityConfig.getUrlPatternsForRole(role);

            if (urlPatterns != null && urlPatterns.contains(servletPath)) {

                System.out.println(" - - - SecurityUtils - - - (isSecurityPage) - (true) - " + servletPath);
                return true;
            }
        }
        System.out.println(" - - - SecurityUtils - - - (isSecurityPage) - (false) - " + servletPath);
        return false;
    }
    public static boolean hasPermission(String servletPath, String role) {

        final Set<String> allRoles = SecurityConfig.getAllRoles();

        if (allRoles.contains(role)) {

            final List<String> urlPatternsForRole = SecurityConfig.getUrlPatternsForRole(role);
            return urlPatternsForRole.contains(servletPath);
        }
        return false;
    }
    public static void removeSession(String sessionId) {

        tokens.remove(sessionId);
    }
    public static void checkSessionsLife() {

        final long currentTime = new Date().getTime();
        long sessionLifeTime;
        long sessionFifeTimeInSeconds;

        for (String sessionToken : tokens.keySet()) {

            sessionLifeTime = currentTime - tokens.get(sessionToken).getLastTouch();
            sessionFifeTimeInSeconds = TimeUnit.MILLISECONDS.toSeconds(sessionLifeTime);

            if (sessionFifeTimeInSeconds > MAX_SESSION_LIFETIME_IN_SECONDS) {
                tokens.remove(sessionToken);
            }
        }
    }

    private static void setTokenLastAccessTime(String sessionId, long lastTime) {

        tokens.get(sessionId).setLastTouch(lastTime);
    }
}
