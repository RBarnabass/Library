package com.softserve.library.app.enums.sql;

import com.softserve.library.app.enums.tables.CredentialColumns;
import com.softserve.library.app.enums.tables.RoleColumns;
import com.softserve.library.app.enums.tables.Tables;

/**
 *
 *
 * @author Roman Berezhnov
 */
public enum CredentialSQL {

    INSERT ("INSERT INTO "
            + Tables.CREDENTIAL.getTable()
            + " ("
            + CredentialColumns.LOGIN.getColumn()
            + ","
            + CredentialColumns.PASSWORD.getColumn()
            + ","
            + CredentialColumns.ROLE_ID
            + ")"
            + "VALUES (?, ?, ?)"),

    SELECT ("SELECT * FROM "
            + Tables.CREDENTIAL.getTable()
            + " JOIN "
            + Tables.ROLE.getTable()
            + " ON "
            + Tables.CREDENTIAL.getTable()
            + "."
            + CredentialColumns.ROLE_ID.getColumn()
            + "="
            + Tables.ROLE.getTable()
            + "."
            + RoleColumns.ID.getColumn()
            + " WHERE "
            + Tables.CREDENTIAL.getTable()
            + "."
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
