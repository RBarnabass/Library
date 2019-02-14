package com.softserve.library.app.enums.patterns;

/**
 *
 *
 * @author Roman Berezhnov
 */
public enum UserPatterns {

    BOOK_LIST ("/library/book_list"),
    BOOK_ORDER ("/library/book_order");

    private String line;

    UserPatterns(String line) {

        this.line = line;
    }

    public String getPattern() {

        return line;
    }
}
