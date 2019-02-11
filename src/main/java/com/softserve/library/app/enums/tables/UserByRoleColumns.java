package com.softserve.library.app.enums.tables;

/**
 *
 *
 * @author Roman Berezhnov
 */
public enum UserByRoleColumns {

    ID("id"),
    USER_ID("user_id"),
    ROLE_ID("role_id");

    private String line;

    UserByRoleColumns(String line) {

        this.line = line;
    }

    public String getColumn() {

        return line;
    }
}
