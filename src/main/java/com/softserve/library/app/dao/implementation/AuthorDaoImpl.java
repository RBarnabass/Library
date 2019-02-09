package com.softserve.library.app.dao.implementation;

import com.softserve.library.app.dao.interfaces.AuthorDao;
import com.softserve.library.app.dao.statement.AuthorStatementExecutor;
import com.softserve.library.app.model.Author;

public class AuthorDaoImpl implements AuthorDao {

    private AuthorStatementExecutor authorStatementExecutor = new AuthorStatementExecutor();

    @Override public Author get(int id) {

        return authorStatementExecutor.get(id);
    }
    @Override public void add(Author author) {

        authorStatementExecutor.add(author);
    }
    @Override public void delete(int id) {

        authorStatementExecutor.delete(id);
    }

    @Override
    public void update(int id) {

    }
}
