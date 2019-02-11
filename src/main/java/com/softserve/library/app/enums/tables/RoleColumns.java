package com.softserve.library.app.enums.tables;

/**
 *
 *
 * @author Roman Berezhnov
 */
public enum RoleColumns {

    ID("id"),
    TYPE("type");

    private String line;

    RoleColumns(String line) {

        this.line = line;
    }

    public String getColumn() {

        return line;
    }
}
