package com.softserve.library.app.service.implementation;

import com.softserve.library.app.dao.implementation.PublisherDaoImpl;
import com.softserve.library.app.dao.interfaces.PublisherDao;
import com.softserve.library.app.dto.PublisherDto;
import com.softserve.library.app.http.CustomResponseEntity;
import com.softserve.library.app.model.Publisher;
import com.softserve.library.app.service.interfaces.PublisherService;
import java.sql.SQLException;

/**
 *
 *
 * @author Roman Berezhnov
 */
public class PublisherServiceImpl implements PublisherService {

    private final PublisherDao publisherDao = new PublisherDaoImpl();

    @Override public Publisher get(int id) throws SQLException {

        return publisherDao.get(id);
    }

    @Override
    public CustomResponseEntity<?> add(PublisherDto publisherDto) throws SQLException {
        return null;
    }

//    @Override public boolean add(Publisher publisher) throws SQLException {
//
//        return publisherDao.add(publisher);
//    }

    @Override public boolean delete(int id) throws SQLException {

        return publisherDao.delete(id);
    }
    @Override public boolean update(Publisher publisher) throws SQLException {

        return publisherDao.update(publisher);
    }
}
