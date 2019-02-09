package com.softserve.library.app.enums.tables;

public enum Tables {

    AUTHOR("author"),
    BOOK("book"),
    COPY("copy"),
    PUBLISHER("publisher"),
    TIME_PERIOD("time_period"),
    USER("user");

    private String line;

    Tables(String line) {
        this.line = line;
    }

    public String getTable() {
        return line;
    }

}
