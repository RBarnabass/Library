package com.softserve.library.app.enums.sql;

/**
 *
 *
 * @author Roman Berezhnov
 */
public enum RoleSQL {

    INSERT (""),
    SELECT ("");

    private String line;

    RoleSQL(String line) {

        this.line = line;
    }

    public String getSQL() {

        return line;
    }
}
