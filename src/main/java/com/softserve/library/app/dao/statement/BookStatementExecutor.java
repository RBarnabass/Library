package com.softserve.library.app.dao.statement;

import com.softserve.library.app.config.DBConnectivity;
import com.softserve.library.app.enums.sql.BookSQL;
import com.softserve.library.app.enums.tables.BookColumns;
import com.softserve.library.app.enums.tables.PublisherColumns;
import com.softserve.library.app.model.Book;
import com.softserve.library.app.model.Publisher;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author Roman Berezhnov
 */
public class BookStatementExecutor {

    private boolean isSuccess;

    public Book get(int id) throws SQLException {

        List<Book> list = new ArrayList<>();

        PreparedStatement preparedStatement = DBConnectivity.getConnection().prepareStatement(BookSQL.SELECT.getSQL() + scopesWrapper(id));
        preparedStatement.executeQuery();
        ResultSet set = preparedStatement.getResultSet();

        Book book;
        Publisher publisher;

        while (set.next()) {

            book = new Book();
            book.setId(set.getInt(BookColumns.ID.getColumn()));
            book.setName(set.getString(BookColumns.NAME.getColumn()));
            book.setPublishYear(set.getInt(BookColumns.PUBLISH_YEAR.getColumn()));

            publisher = new Publisher();
            publisher.setId(set.getInt(BookColumns.PUBLISHER_ID.getColumn()));
            publisher.setName(set.getString(PublisherColumns.NAME.getColumn()));

            book.setPublisher(publisher);
            list.add(book);
        }

        return list.get(0);
    }

    private String scopesWrapper(int id) {

        return "'" + id + "'";
    }
}
