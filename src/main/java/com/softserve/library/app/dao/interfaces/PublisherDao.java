package com.softserve.library.app.dao.interfaces;

import com.softserve.library.app.model.Publisher;

import java.sql.SQLException;

/**
 *
 *
 * @author Roman Berezhnov
 */
public interface PublisherDao extends SimpleCrudDao<Publisher> {

    Publisher getByName(String name) throws SQLException;
    int addAndGetIdBack(Publisher publisher) throws SQLException;
}
