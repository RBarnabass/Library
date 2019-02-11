package com.softserve.library.app.tables;

public enum CopyColumns {
    ID("id"),
    BOOK_ID("book_id"),
    IS_AVAILABLE("is_available");

    private String line;

    CopyColumns(String line) {
        this.line = line;
    }

    public String getColumn() {
        return line;
    }
}