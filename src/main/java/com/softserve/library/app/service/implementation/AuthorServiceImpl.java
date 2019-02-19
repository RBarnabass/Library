package com.softserve.library.app.service.implementation;

import com.softserve.library.app.dao.implementation.AuthorDaoImpl;
import com.softserve.library.app.dao.interfaces.AuthorDao;
import com.softserve.library.app.dto.AuthorDto;
import com.softserve.library.app.http.CustomResponseEntity;
import com.softserve.library.app.model.Author;
import com.softserve.library.app.service.interfaces.AuthorService;

import java.sql.SQLException;

/**
 *
 *
 * @author Roman Berezhnov
 */
public class AuthorServiceImpl implements AuthorService {

    private final AuthorDao authorDao = new AuthorDaoImpl();

    @Override public Author get(int id) throws SQLException {

        return authorDao.get(id);
    }

    @Override
    public void add(Author author) throws SQLException {

    }

//    @Override
//    public CustomResponseEntity<?> add(AuthorDto authorDto) throws SQLException {
//        return null;
//    }

    //    @Override public boolean add(Author author) throws SQLException {
//
//        return authorDao.add(author);
//    }
    @Override public boolean delete(int id) throws SQLException {

        return authorDao.delete(id);
    }

    @Override public boolean update(Author author) throws SQLException {

        return authorDao.update(author);
    }
}
