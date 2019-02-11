package com.softserve.library.app.enums.tables;

/**
 *
 *
 * @author Roman Berezhnov
 */
public enum Tables {

    AUTHOR("author"),
    BOOK("book"),
    COPY("copy"),
    PUBLISHER("publisher"),
    TIME_PERIOD("time_period"),
    USER("user"),
    CREDENTIAL("credential"),
    ROLE("role"),
    USER_BY_CREDENTIAL("user_by_credential"),
    USER_BY_ROLE("user_by_role");

    private String line;

    Tables(String line) {
        this.line = line;
    }

    public String getTable() {
        return line;
    }

}
