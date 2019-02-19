package com.softserve.library.app.dao.implementation;

import com.softserve.library.app.dao.interfaces.PublisherDao;
import com.softserve.library.app.dao.statement.PublisherStatementExecutor;
import com.softserve.library.app.dto.PublisherDto;
import com.softserve.library.app.http.CustomResponseEntity;
import com.softserve.library.app.model.Publisher;
import java.sql.SQLException;
import java.util.List;

/**
 *
 *
 * @author Roman Berezhnov
 */
public class PublisherDaoImpl implements PublisherDao {

    private final PublisherStatementExecutor publisherStatementExecutor = new PublisherStatementExecutor();

    @Override public Publisher get(int id) throws SQLException {

        List<Publisher> list = publisherStatementExecutor.get(id);

        return list != null && !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    public boolean add(Publisher t) throws SQLException {
        return false;
    }

//    @Override
//    public CustomResponseEntity<?> add(PublisherDto publisherDto) throws SQLException {
//        return null;
//    }

//    @Override public boolean add(Publisher publisher) throws SQLException {
//
//        return publisherStatementExecutor.add(publisher);
//    }

    @Override public boolean delete(int id) throws SQLException {

        return publisherStatementExecutor.delete(id);
    }
    @Override public boolean update(Publisher publisher) throws SQLException {

        return publisherStatementExecutor.update(publisher);
    }
}
