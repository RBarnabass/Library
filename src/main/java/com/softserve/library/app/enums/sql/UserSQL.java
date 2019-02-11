package com.softserve.library.app.enums.sql;

import com.softserve.library.app.enums.tables.Tables;
import com.softserve.library.app.enums.tables.UserColumns;

/**
 *
 *
 * @author Roman Berezhnov
 */
public enum UserSQL {

    INSERT ("INSERT INTO "
            + Tables.USER.getTable()
            + " ("
            + UserColumns.FULL_NAME.getColumn()
            + ", "
            + UserColumns.BIRTH_DATE.getColumn()
            + ", "
            + UserColumns.REGISTRATION_DATE.getColumn()
            + ")"
            + " VALUE(?,?,?)"),

    SELECT ("");

    private String line;

    UserSQL(String line) {

        this.line = line;
    }

    public String getSQL() {

        return line;
    }
}
