package com.softserve.library.app.enums.tables;

/**
 *
 *
 * @author Roman Berezhnov
 */
public enum UserByCredentialColumns {

    ID("id"),
    USER_ID("user_id"),
    CREDENTIAL_ID("credential_id");

    private String line;

    UserByCredentialColumns(String line) {

        this.line = line;
    }

    public String getColumn() {

        return line;
    }
}
