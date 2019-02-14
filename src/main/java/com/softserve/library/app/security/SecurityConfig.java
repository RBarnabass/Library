package com.softserve.library.app.security;

import com.softserve.library.app.constant.UrlPatterns;

import java.util.*;

/**
 *
 *
 * @author Roman Berezhnov
 */
public class SecurityConfig {

    private static final String ROLE_ADMIN = "admin";
    private static final String ROLE_USER = "user";
    private static final String ROLE_LIBRARIAN = "librarian";
    private static final String ROLE_GUEST = "general";
    private static final Map<String, List<String>> mapConfig = new HashMap<>();

    static {
        initialization();
        System.out.println(" - - - Security config initialization - - - ");
    }

    private static void initialization() {

        // ADMIN
        List<String> urlPatternsForAdmin = new ArrayList<>();
        urlPatternsForAdmin.add(UrlPatterns.USER_OPTION);
        mapConfig.put(ROLE_ADMIN, urlPatternsForAdmin);

        // USER
        List<String> urlPatternsForUser = new ArrayList<>();
        urlPatternsForUser.add(UrlPatterns.BOOK_LIST);
        urlPatternsForUser.add(UrlPatterns.BOOK_ORDER);
        mapConfig.put(ROLE_USER, urlPatternsForUser);

        // LIBRARIAN
        List<String> urlPatternsForLibrarian = new ArrayList<>();
        urlPatternsForLibrarian.add(UrlPatterns.BOOK_OPTION);
        urlPatternsForLibrarian.add(UrlPatterns.BOOK_STATISTIC);
        mapConfig.put(ROLE_LIBRARIAN, urlPatternsForLibrarian);

        // Common
        List<String> urlPatternsForGuest = new ArrayList<>();
        urlPatternsForGuest.add(UrlPatterns.INFO);
        urlPatternsForGuest.add(UrlPatterns.LOGIN);
        urlPatternsForGuest.add(UrlPatterns.LOGOUT);
        mapConfig.put(ROLE_GUEST, urlPatternsForGuest);
    }

    public static Set<String> getAllRoles() {

        return mapConfig.keySet();
    }
    public static List<String> getUrlPatternsForRole(String role) {

        return mapConfig.get(role);
    }
}
