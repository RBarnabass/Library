package com.softserve.library.app.dao.implementation;

import com.softserve.library.app.dao.interfaces.PublisherDao;
import com.softserve.library.app.dao.statement.PublisherStatementExecutor;
import com.softserve.library.app.model.Publisher;
import java.sql.SQLException;

public class PublisherDaoImpl implements PublisherDao {

    private final PublisherStatementExecutor publisherStatementExecutor = new PublisherStatementExecutor();

    @Override public Publisher get(int id) throws SQLException {

        return publisherStatementExecutor.get(id);
    }
    @Override public boolean add(Publisher publisher) throws SQLException {

        return publisherStatementExecutor.add(publisher);
    }
    @Override public boolean delete(int id) throws SQLException {

        return publisherStatementExecutor.delete(id);
    }
    @Override public boolean update(Publisher publisher) throws SQLException {

        return publisherStatementExecutor.update(publisher);
    }
}
