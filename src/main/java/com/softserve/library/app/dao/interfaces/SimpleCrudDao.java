package com.softserve.library.app.dao.interfaces;

import java.sql.SQLException;

/**
 *
 *
 * @author Roman Berezhnov
 */
public interface SimpleCrudDao<E> {

    E get(int id) throws SQLException;
    boolean add(E e) throws SQLException;
    boolean delete(int id) throws SQLException;
    boolean update(E e) throws SQLException;
}
