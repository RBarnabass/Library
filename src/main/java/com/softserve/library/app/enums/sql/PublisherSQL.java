package com.softserve.library.app.enums.sql;

import com.softserve.library.app.enums.tables.PublisherColumns;
import com.softserve.library.app.enums.tables.Tables;

public enum PublisherSQL {

    INSERT ("INSERT INTO "
            + Tables.PUBLISHER.getTable()
            + "(" + PublisherColumns.NAME.getColumn()
            + ")" + "VALUE(?)"),

    SELECT ("SELECT * FROM "
            + Tables.PUBLISHER.getTable()
            + " WHERE id="),

    DELETE ("DELETE FROM "
            + Tables.PUBLISHER.getTable()
            + " WHERE id="),

    UPDATE ("UPDATE "
            + Tables.PUBLISHER.getTable()
            + " SET "
            + PublisherColumns.NAME.getColumn()
            + "=? WHERE id=?");

    private String line;

    PublisherSQL(String line) {

        this.line = line;
    }

    public String getSQL() {

        return line;
    }
}
