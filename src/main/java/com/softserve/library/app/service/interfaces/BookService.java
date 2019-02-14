package com.softserve.library.app.service.interfaces;

import com.softserve.library.app.dto.BookDto;
import com.softserve.library.app.model.Book;

import java.sql.SQLException;
import java.util.List;

/**
 *
 *
 * @author Roman Berezhnov
 */
public interface BookService extends SimpleCrudService<Book> {

    List<BookDto> getAll() throws SQLException;
    List<Boolean> getAllAvailable() throws SQLException;
}
