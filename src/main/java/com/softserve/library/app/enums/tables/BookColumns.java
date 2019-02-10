package com.softserve.library.app.enums.tables;

/**
 *
 *
 * @author Roman Berezhnov
 */
public enum BookColumns {

    ID("id"),
    NAME("name"),
    PUBLISHER_ID("publisher_id"),
    PUBLISH_YEAR("publish_year");

    private String line;

    BookColumns(String line) {

        this.line = line;
    }

    public String getColumn() {

        return line;
    }
}
