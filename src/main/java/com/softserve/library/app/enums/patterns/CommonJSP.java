package com.softserve.library.app.enums.patterns;

/**
 *
 *
 * @author Roman Berezhnov
 */
public enum CommonPatterns {

    INFO ("/library/info"),
    LOGIN ("/library/login"),
    LOGOUT ("/library/logout");

    private String line;

    CommonPatterns(String line) {

        this.line = line;
    }

    public String getPattern() {

        return line;
    }
}
