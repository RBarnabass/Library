package com.softserve.library.app.tables;

public enum UserColumns {

    ID("id"),
    NAME("name"),
    BIRTH_DATE("publisher_id"),
    REGISTRATION_DATE("publisher_id");

    private String line;

    UserColumns(String line) {
        this.line = line;
    }

    public String getColumn() {
        return line;
    }
}