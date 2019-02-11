package com.softserve.library.app.tables;

public enum Tables {

    USER("user"),
    AUTHOR("author"),
    BOOK("book"),
    COPY("copy"),
    PUBLISHER("publisher"),
    TIME_PERIOD("time_period");

    private String line;

    Tables(String line) {
        this.line = line;
    }

    public String getTable() {
        return line;
    }
}