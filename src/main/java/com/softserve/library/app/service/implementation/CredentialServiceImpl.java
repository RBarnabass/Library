package com.softserve.library.app.service.implementation;

import com.softserve.library.app.dao.implementation.CredentialDaoImpl;
import com.softserve.library.app.dao.interfaces.CredentialDao;
import com.softserve.library.app.model.Credential;
import com.softserve.library.app.service.interfaces.CredentialService;
import java.sql.SQLException;

/**
 *
 *
 * @author Roman Berezhnov
 */
public class CredentialServiceImpl implements CredentialService {

    private final CredentialDao credentialDao = new CredentialDaoImpl();

    @Override public Credential getByLogin(String login) throws SQLException {

        return credentialDao.getByLogin(login);
    }
    @Override public boolean checkExistence(String login) throws SQLException {

        return credentialDao.checkExistence(login);
    }

    @Override
    public Credential get(int id) throws SQLException {

        //todo: implement me !
        return null;
    }

    @Override
    public boolean add(Credential credential) throws SQLException {

        //todo: implement me !
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {

        //todo: implement me !
        return false;
    }

    @Override
    public boolean update(Credential credential) throws SQLException {

        //todo: implement me !
        return false;
    }
}
