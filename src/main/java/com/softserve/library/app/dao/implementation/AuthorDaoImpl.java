package com.softserve.library.app.dao.implementation;

import com.softserve.library.app.dao.interfaces.AuthorDao;
import com.softserve.library.app.dao.statement.AuthorStatementExecutor;
import com.softserve.library.app.model.Author;

import java.sql.SQLException;
import java.util.List;

/**
 *
 *
 * @author Roman Berezhnov
 */
public class AuthorDaoImpl implements AuthorDao {

    private final AuthorStatementExecutor authorStatementExecutor = new AuthorStatementExecutor();

    @Override public Author get(int id) throws SQLException {

        List<Author> list = authorStatementExecutor.get(id);

        return list.size() > 1 ? null : list.get(0);
    }
    @Override public boolean add(Author author) throws SQLException {

        return authorStatementExecutor.add(author);
    }
    @Override public boolean delete(int id) throws SQLException {

        return authorStatementExecutor.delete(id);
    }
    @Override public boolean update(Author author) throws SQLException {

        return authorStatementExecutor.update(author);
    }
}
