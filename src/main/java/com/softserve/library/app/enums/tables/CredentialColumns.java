package com.softserve.library.app.enums.tables;

/**
 *
 *
 * @author Roman Berezhnov
 */
public enum CredentialColumns {

    ID("id"),
    LOGIN("login"),
    PASSWORD("password");

    private String line;

    CredentialColumns(String line) {

        this.line = line;
    }

    public String getColumn() {

        return line;
    }
}
