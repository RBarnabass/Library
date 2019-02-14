package com.softserve.library.app.enums.patterns;

/**
 *
 *
 * @author Roman Berezhnov
 */
public enum AdminJSP {

    USER_OPTION ("/WEB-INF/view/admin/user_option.jsp");

    private String line;

    AdminJSP(String line) {

        this.line = line;
    }

    public String getPattern() {

        return line;
    }
}
