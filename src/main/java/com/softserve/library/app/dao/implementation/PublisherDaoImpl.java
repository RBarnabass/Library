package com.softserve.library.app.dao.implementation;

import com.softserve.library.app.dao.interfaces.PublisherDao;
import com.softserve.library.app.model.Publisher;
import java.sql.SQLException;

public class PublisherDaoImpl implements PublisherDao {

    @Override
    public Publisher get(int id) throws SQLException {
        return null;
    }

    @Override
    public boolean add(Publisher publisher) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Publisher publisher) throws SQLException {
        return false;
    }
}
