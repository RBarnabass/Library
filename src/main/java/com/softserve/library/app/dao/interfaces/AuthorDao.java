package com.softserve.library.app.dao.interfaces;

import com.softserve.library.app.model.Author;

import java.sql.SQLException;

/**
 *
 *
 * @author Roman Berezhnov
 */
public interface AuthorDao extends SimpleCrudDao<Author> {

    Author getByName(String name) throws SQLException;
    int addAndGetIdBack(Author author) throws SQLException;
}
