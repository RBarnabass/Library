package com.softserve.library.app.enums.patterns;

/**
 *
 *
 * @author Roman Berezhnov
 */
public enum CommonJSP {

    INFO ("/index.jsp"),
    LOGIN ("/WEB-INF/appearance/pages/login.jsp"),
    ACCESS_DENIED ("/WEB-INF/view/general/accessDenied.jsp");

    private String line;

    CommonJSP(String line) {

        this.line = line;
    }

    public String getPattern() {

        return line;
    }
}
