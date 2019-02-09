package com.softserve.library.app.enums.tables;

public enum AuthorColumns {

    ID("id"),
    FULL_NAME("full_name");

    private String line;

    AuthorColumns(String line) {

        this.line = line;
    }

    public String getColumn() {

        return line;
    }
}
