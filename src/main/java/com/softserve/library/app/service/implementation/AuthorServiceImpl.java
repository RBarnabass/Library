package com.softserve.library.app.service.implementation;

import com.softserve.library.app.dao.implementation.AuthorDaoImpl;
import com.softserve.library.app.dao.interfaces.AuthorDao;
import com.softserve.library.app.model.Author;
import com.softserve.library.app.service.interfaces.AuthorService;

import java.sql.SQLException;

public class AuthorServiceImpl implements AuthorService {

    private AuthorDao authorDao = new AuthorDaoImpl();

    @Override public Author get(int id) throws SQLException {

        return authorDao.get(id);
    }
    @Override public boolean add(Author author) throws SQLException {

        return authorDao.add(author);
    }
    @Override public boolean delete(int id) throws SQLException {

        return authorDao.delete(id);
    }
    @Override public boolean update(Author author) throws SQLException {

        return authorDao.update(author);
    }
}
