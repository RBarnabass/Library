package com.softserve.library.app.enums.patterns;

/**
 *
 *
 * @author Roman Berezhnov
 */
public enum UserJSP {

    BOOK_ORDER ("/WEB-INF/view/user/book_order.jsp");

    private String line;

    UserJSP(String line) {

        this.line = line;
    }

    public String getPattern() {

        return line;
    }
}
