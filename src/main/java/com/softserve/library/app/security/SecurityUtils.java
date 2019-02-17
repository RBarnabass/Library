package com.softserve.library.app.security;

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

    private static final Map<String, Token> sessions = new ConcurrentHashMap<>();
    private static final int SESSION_LIFETIME_IN_SECONDS = 30;

    public static String getLoggedUser(HttpSession session) {

        if (sessions.containsKey(session.getId())) {

            System.out.println(" - - - Session id is correct !!! - - - ");
            sessions.get(session.getId()).setLastTouch(session.getLastAccessedTime());
            return sessions.get(session.getId()).getRole();
        }

        System.out.println(" - - - Session id is NOT correct !!! - - - ");
        return null;
    }

    public static void storeLoggedUser(HttpSession session, String role) {

        session.setMaxInactiveInterval(SESSION_LIFETIME_IN_SECONDS);
        Token token = new Token(session.getId(), session.getLastAccessedTime(), role);
        sessions.put(session.getId(), token);
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

        Set<String> allRoles = SecurityConfig.getAllRoles();

        if (allRoles.contains(role)) {

            List<String> urlPatternsForRole = SecurityConfig.getUrlPatternsForRole(role);
            return urlPatternsForRole.contains(servletPath);
        }
        return false;
    }

    public static void checkSessionLife() {

        for (String line : sessions.keySet()) {

            long time = TimeUnit.MILLISECONDS.toSeconds(new Date().getTime() - sessions.get(line).getLastTouch());

            if (time > SESSION_LIFETIME_IN_SECONDS) {
                sessions.remove(line);
            }
        }
    }

    static class Token {

        private String sessionId;
        private long lastTouch;
        private String role;

        public Token() { }
        Token(String sessionId, long lastTouch, String role) {
            this.sessionId = sessionId;
            this.lastTouch = lastTouch;
            this.role = role;
        }

        public String getSessionId() {
            return sessionId;
        }
        public void setSessionId(String sessionId) {
            this.sessionId = sessionId;
        }
        long getLastTouch() {
            return lastTouch;
        }
        void setLastTouch(long lastTouch) {
            this.lastTouch = lastTouch;
        }
        public String getRole() {
            return role;
        }
        public void setRole(String role) {
            this.role = role;
        }
    }
}
