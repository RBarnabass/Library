package com.softserve.library.app.dao.interfaces;

import com.softserve.library.app.model.Credential;

import java.sql.SQLException;

/**
 *
 *
 * @author Roman Berezhnov
 */
public interface CredentialDao extends SimpleCrudDao<Credential> {

    Credential getByLogin(String login) throws SQLException;
    boolean checkExistence(String login) throws SQLException;
}
