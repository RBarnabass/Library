package com.softserve.library.app.dao.statement;

import com.softserve.library.app.config.DBConnectivity;
import com.softserve.library.app.enums.sql.CredentialSQL;
import com.softserve.library.app.enums.tables.CredentialColumns;
import com.softserve.library.app.enums.tables.RoleColumns;
import com.softserve.library.app.model.Credential;
import com.softserve.library.app.model.Role;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author Roman Berezhnov
 */
public class CredentialStatementExecutor {

    private boolean isSuccess;

    public Credential get(String login) throws SQLException {

        List<Credential> list = new ArrayList<>();

        //todo: wrapper method !
        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(CredentialSQL.SELECT.getSQL() + "'" + login + "'");
        preparedStatement.executeQuery();
        ResultSet set = preparedStatement.getResultSet();
        Credential credential;
        Role role;

        while (set.next()) {

            credential = new Credential();
            credential.setId(set.getInt(CredentialColumns.ID.getColumn()));
            credential.setLogin(set.getString(CredentialColumns.LOGIN.getColumn()));
            credential.setPassword(set.getString(CredentialColumns.PASSWORD.getColumn()));

            role = new Role();
            role.setId(set.getInt(RoleColumns.ID.getColumn()));
            role.setType(set.getString(RoleColumns.TYPE.getColumn()));
            credential.setRole(role);

            list.add(credential);
        }

        set.close();
        preparedStatement.close();
        System.out.println(" ---------------------------- I was in db !");
        System.out.println(list.get(0));
        return list.get(0);
    }

    public boolean add(Credential credential) {







        return true;
    }
}
