package com.softserve.library.app.security;

import com.softserve.library.app.constant.UrlPatterns;
import java.util.*;

/**
 *
 *
 * @author Roman Berezhnov
 */
class SecurityConfig {

    private static final String ROLE_ADMIN = "admin";
    private static final String ROLE_USER = "user";
    private static final String ROLE_LIBRARIAN = "librarian";
    private static final String ROLE_GUEST = "general";
    private static final Map<String, List<String>> mapConfig = new HashMap<>();

    static {
        initialization();
    }

    private static void initialization() {

        // ADMIN
        final List<String> urlPatternsForAdmin = new ArrayList<>();
        urlPatternsForAdmin.add(UrlPatterns.USER_OPTION);
        urlPatternsForAdmin.add(UrlPatterns.BOOK_SEARCH);
        urlPatternsForAdmin.add(UrlPatterns.BOOK_LIST);
        mapConfig.put(ROLE_ADMIN, urlPatternsForAdmin);

        // USER
        final List<String> urlPatternsForUser = new ArrayList<>();
        urlPatternsForUser.add(UrlPatterns.BOOK_LIST);
        urlPatternsForUser.add(UrlPatterns.BOOK_ORDER);
        urlPatternsForUser.add(UrlPatterns.BOOK_SEARCH);
        urlPatternsForUser.add(UrlPatterns.BOOK_PAGE);
        urlPatternsForUser.add(UrlPatterns.USER_PAGE);
        mapConfig.put(ROLE_USER, urlPatternsForUser);

        // LIBRARIAN
        final List<String> urlPatternsForLibrarian = new ArrayList<>();
        urlPatternsForLibrarian.add(UrlPatterns.BOOK_OPTION);
        urlPatternsForLibrarian.add(UrlPatterns.BOOK_STATISTIC);
        mapConfig.put(ROLE_LIBRARIAN, urlPatternsForLibrarian);

        // Common
        final List<String> urlPatternsForGuest = new ArrayList<>();
        urlPatternsForGuest.add(UrlPatterns.INFO);
        urlPatternsForGuest.add(UrlPatterns.SIGNIN);
        urlPatternsForGuest.add(UrlPatterns.LOGOUT);
        urlPatternsForGuest.add(UrlPatterns.SIGNUP);
        mapConfig.put(ROLE_GUEST, urlPatternsForGuest);
    }

    static Set<String> getAllRoles() {

        return mapConfig.keySet();
    }
    static List<String> getUrlPatternsForRole(String role) {

        return mapConfig.get(role);
    }
}
