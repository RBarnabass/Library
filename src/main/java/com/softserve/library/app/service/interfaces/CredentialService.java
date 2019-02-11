package com.softserve.library.app.service.interfaces;

import com.softserve.library.app.model.Credential;

import java.sql.SQLException;

/**
 *
 *
 * @author Roman Berezhnov
 */
public interface CredentialService extends SimpleCrudService<Credential> {

    Credential getByLogin(String login) throws SQLException;
}
