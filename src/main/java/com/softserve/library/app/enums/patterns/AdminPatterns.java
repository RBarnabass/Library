package com.softserve.library.app.enums.patterns;

/**
 *
 *
 * @author Roman Berezhnov
 */
public enum AdminPatterns {

    USER_OPTION ("/library/user_option");

    private String line;

    AdminPatterns(String line) {

        this.line = line;
    }

    public String getPattern() {

        return line;
    }
}
