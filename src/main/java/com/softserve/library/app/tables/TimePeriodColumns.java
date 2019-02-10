package com.softserve.library.app.tables;

public enum TimePeriodColumns {
    ID("id"),
    COPY_ID("copy_id"),
    BOOK_TAKING_DATE("bookTakingDate"),
    BOOK_RETURNING_DATE("bookReturningDate"),
    USER_ID("user_id");

    private String line;

    TimePeriodColumns(String line) {
        this.line = line;
    }

    public String getColumn() {
        return line;
    }
}
