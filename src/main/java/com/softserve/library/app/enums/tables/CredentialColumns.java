package com.softserve.library.app.enums.tables;

/**
 *
 *
 * @author Roman Berezhnov
 */
public enum CredentialColumns {

    ID("id"),
    LOGIN("login"),
    PASSWORD("password"),
    ROLE_ID("role_id"),
    USER_ID("user_id");

    private String line;

    CredentialColumns(String line) {

        this.line = line;
    }

    public String getColumn() {

        return line;
    }
}
