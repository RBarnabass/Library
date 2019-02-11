package com.softserve.library.app.enums.sql;

import com.softserve.library.app.enums.tables.CredentialColumns;
import com.softserve.library.app.enums.tables.Tables;

/**
 *
 *
 * @author Roman Berezhnov
 */
public enum CredentialSQL {

    INSERT (""),

    SELECT ("SELECT * FROM "
            + Tables.CREDENTIAL.getTable()
            + " WHERE "
            + CredentialColumns.LOGIN.getColumn()
            + "=");

    private String line;

    CredentialSQL(String line) {

        this.line = line;
    }

    public String getSQL() {

        return line;
    }

}
