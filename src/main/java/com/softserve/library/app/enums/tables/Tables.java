package com.softserve.library.app.enums.tables;

/**
 *
 *
 * @author Roman Berezhnov
 */
public enum Tables {

    AUTHOR("author"),
    BOOK("book"),
    PUBLISHER("publisher"),
    USER("user"),
    ROLE("role");


    private String line;

    Tables(String line) {
        this.line = line;
    }

    public String getTable() {
        return line;
    }

}
