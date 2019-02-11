package com.softserve.library.app.enums.tables;

/**
 *
 *
 * @author Roman Berezhnov
 */
public enum UserColumns {

    ID("id"),
    FULL_NAME("full_name"),
    BIRTH_DATE("birth_date"),
    REGISTRATION_DATE("registration_date");

    private String line;

    UserColumns(String line) {

        this.line = line;
    }

    public String getColumn() {

        return line;
    }
}
