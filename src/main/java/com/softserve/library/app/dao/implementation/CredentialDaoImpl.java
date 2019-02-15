package com.softserve.library.app.dao.implementation;

import com.softserve.library.app.dao.interfaces.CredentialDao;
import com.softserve.library.app.dao.statement.CredentialStatementExecutor;
import com.softserve.library.app.model.Credential;
import java.sql.SQLException;
import java.util.List;

/**
 *
 *
 * @author Roman Berezhnov
 */
public class CredentialDaoImpl implements CredentialDao {

    private final CredentialStatementExecutor credentialStatementExecutor = new CredentialStatementExecutor();

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

    @Override public Credential getByLogin(String login) throws SQLException {

        List<Credential> list = credentialStatementExecutor.get(login);

        return list != null && !list.isEmpty() ? list.get(0) : null;
    }
    @Override public boolean checkExistence(String login) throws SQLException {

        return credentialStatementExecutor.checkExistence(login);
    }
}
