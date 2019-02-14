package com.softserve.library.app.dao.interfaces;

import com.softserve.library.app.dto.BookDto;
import com.softserve.library.app.model.Book;

import java.sql.SQLException;
import java.util.List;

/**
 *
 *
 * @author Roman Berezhnov
 */
public interface BookDao extends SimpleCrudDao<Book> {

    List<BookDto> getAll() throws SQLException;
    List<Boolean> getAllAvailable() throws SQLException;
}
