package com.softserve.library.app.enums.sql;

import com.softserve.library.app.enums.tables.AuthorColumns;
import com.softserve.library.app.enums.tables.Tables;

public enum AuthorSQL {

    INSERT ("INSERT INTO "
            + Tables.AUTHOR.getTable()
            + "(" + AuthorColumns.FULL_NAME.getColumn()
            + ")" + "VALUE(?)"),

    SELECT ("SELECT * FROM "
            + Tables.AUTHOR.getTable()
            + " WHERE id="),

    DELETE ("DELETE FROM "
            + Tables.AUTHOR.getTable()
            + " WHERE id="),

    UPDATE ("UPDATE "
            + Tables.AUTHOR.getTable()
            + " SET "
            + AuthorColumns.FULL_NAME.getColumn()
            + "=? WHERE id=?");

    private String line;

    AuthorSQL(String line) {

        this.line = line;
    }

    public String getSQL() {

        return line;
    }
}
