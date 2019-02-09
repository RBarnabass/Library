package com.softserve.library.app.service.implementation;

import com.softserve.library.app.dao.implementation.AuthorDaoImpl;
import com.softserve.library.app.dao.interfaces.AuthorDao;
import com.softserve.library.app.model.Author;
import com.softserve.library.app.service.interfaces.AuthorService;

public class AuthorServiceImpl implements AuthorService {

    private AuthorDao authorDao = new AuthorDaoImpl();

    @Override public Author get(int id) {

        return authorDao.get(id);
    }
    @Override public void add(Author author) {

        authorDao.add(author);
    }
    @Override public void delete(int id) {

        authorDao.delete(id);
    }
    @Override public void update(Author author) {

        authorDao.update(author);
    }
}
