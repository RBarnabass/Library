package com.softserve.library.app.dao.implementation;

import com.softserve.library.app.config.DBConnectivity;
import com.softserve.library.app.dao.interfaces.PublisherDao;
import com.softserve.library.app.dao.statement.PublisherStatementExecutor;
import com.softserve.library.app.enums.sql.PublisherSQL;
import com.softserve.library.app.model.Publisher;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 *
 * @author Roman Berezhnov
 */
public class PublisherDaoImpl implements PublisherDao {

    private final PublisherStatementExecutor publisherStatementExecutor = new PublisherStatementExecutor();
    private boolean isSuccess;

    @Override public Publisher get(int id) throws SQLException {

        List<Publisher> list = publisherStatementExecutor.getAllByOptions("publisher.id=" + scopesWrapper(id + ""));

        return list != null && !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    public boolean add(Publisher publisher) throws SQLException {

        return publisherStatementExecutor.add(publisher);
    }



    @Override public boolean delete(int id) throws SQLException {

        return publisherStatementExecutor.delete(id);
    }
    @Override public boolean update(Publisher publisher) throws SQLException {

        return publisherStatementExecutor.update(publisher);
    }

    @Override public Publisher getByName(String name) throws SQLException {

        List<Publisher> list = publisherStatementExecutor.getAllByOptions("publisher.name=" + scopesWrapper(name));

        return list != null && !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    public int addAndGetIdBack(Publisher publisher) throws SQLException {

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(PublisherSQL.INSERT.getSQL(), Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, publisher.getName());
        isSuccess = preparedStatement.executeUpdate() > 0;

        if (isSuccess) {

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            return resultSet.getInt(1);
        }

        return 0;
    }

    private String scopesWrapper(String param) {

        return "'" + param + "'";
    }
}
