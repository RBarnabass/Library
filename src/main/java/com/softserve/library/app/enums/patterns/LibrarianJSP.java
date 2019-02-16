package com.softserve.library.app.enums.patterns;

/**
 *
 *
 * @author Roman Berezhnov
 */
public enum LibrarianJSP {

    BOOK_OPTION ("/WEB-INF/view/librarian/book_option.jsp"),
    BOOK_STATISTIC ("/WEB-INF/view/librarian/book_statistic.jsp");

    private String line;

    LibrarianJSP(String line) {

        this.line = line;
    }

    public String getPattern() {

        return line;
    }
}
