package com.softserve.library.app.enums.patterns;

/**
 *
 *
 * @author Roman Berezhnov
 */
public enum LibrarianPatterns {

    BOOK_OPTION ("/library/book_option"),
    BOOK_STATISTIC ("/library/book_statistic");

    private String line;

    LibrarianPatterns(String line) {

        this.line = line;
    }

    public String getPattern() {

        return line;
    }
}
