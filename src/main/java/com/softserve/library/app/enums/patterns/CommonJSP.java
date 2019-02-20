package com.softserve.library.app.enums.patterns;

/**
 *
 *
 * @author Roman Berezhnov
 */
public enum CommonJSP {

    INFO ("/WEB-INF/view/general/homepage.jsp"),
    ACCESS_DENIED ("/WEB-INF/view/general/accessDenied.jsp");

    private String line;

    CommonJSP(String line) {

        this.line = line;
    }

    public String getPattern() {

        return line;
    }
}