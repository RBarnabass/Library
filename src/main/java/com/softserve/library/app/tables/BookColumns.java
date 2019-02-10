package com.softserve.library.app.tables;

public enum BookColumns {

    ID("id"),
    TITLE("title"),
    AUTHOR_ID("author_id"),
    PUBLISHER_ID("publisher_id"),
    PUBLISH_YEAR("publish_year");

    private String line;

    BookColumns(String line) {
        this.line = line;
    }

    public String getColumn() {
        return line;
    }
}
