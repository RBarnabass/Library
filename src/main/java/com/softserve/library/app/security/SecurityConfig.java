package com.softserve.library.app.controller.mySecurityTest.security;

import java.util.*;

public class SecurityConfig {

    private static final String ROLE_ADMIN = "admin";
    private static final String ROLE_USER = "user";
    private static final String ROLE_LIBRARIAN = "librarian";
    private static final String ROLE_GUEST = "guest";
    private static final Map<String, List<String>> mapConfig = new HashMap<>();

    static {
        initialization();
        System.out.println(" - - - Security config initialization - - - ");
    }

    private static void initialization() {

        // ADMIN
        List<String> urlPatternsForAdmin = new ArrayList<>();
        urlPatternsForAdmin.add("/library/user_option");
        mapConfig.put(ROLE_ADMIN, urlPatternsForAdmin);

        // USER
        List<String> urlPatternsForUser = new ArrayList<>();
        urlPatternsForUser.add("/library/book_list");
        urlPatternsForUser.add("/library/book_order");
        mapConfig.put(ROLE_USER, urlPatternsForUser);

        // LIBRARIAN
        List<String> urlPatternsForLibrarian = new ArrayList<>();
        urlPatternsForLibrarian.add("/library/book_option");
        urlPatternsForLibrarian.add("/library/book_statistic");
        mapConfig.put(ROLE_LIBRARIAN, urlPatternsForLibrarian);

        // GUEST
        List<String> urlPatternsForGuest = new ArrayList<>();
        urlPatternsForGuest.add("/library/info");
        urlPatternsForGuest.add("/library/login");
        urlPatternsForGuest.add("/library/logout");
        mapConfig.put(ROLE_GUEST, urlPatternsForGuest);
    }

    public static Set<String> getAllRoles() {

        return mapConfig.keySet();
    }
    public static List<String> getUrlPatternsForRole(String role) {

        return mapConfig.get(role);
    }
}
