package com.softserve.library.app.enums.sql;

import com.softserve.library.app.enums.tables.BookColumns;
import com.softserve.library.app.enums.tables.PublisherColumns;
import com.softserve.library.app.enums.tables.Tables;

public enum BookSQL {

    SELECT ("SELECT * FROM "
            + Tables.BOOK.getTable()
            + " JOIN "
            + Tables.PUBLISHER.getTable()
            + " ON "
            + Tables.BOOK.getTable()
            + "."
            + BookColumns.PUBLISHER_ID.getColumn()
            + "="
            + Tables.PUBLISHER.getTable()
            + "."
            + PublisherColumns.ID.getColumn()
            + " WHERE "
            + Tables.BOOK.getTable()
            + "."
            + BookColumns.ID.getColumn()
            + "="),

    // todo: fix it !
    INSERT ("INSERT INTO "
            + Tables.BOOK.getTable()
            + "(" + BookColumns.NAME.getColumn()
            + ")" + "VALUE(?)");

    private String line;

    BookSQL(String line) {

        this.line = line;
    }

    public String getSQL() {

        return line;
    }
}
