package com.softserve.library.app.service.interfaces;

import com.softserve.library.app.http.CustomResponseEntity;

import java.sql.SQLException;

/**
 *
 *
 * @author Roman Berezhnov
 */
public interface SimpleCrudService<E, T> {

    E get(int id) throws SQLException;
    CustomResponseEntity<?> add(T t) throws SQLException;
    boolean delete(int id) throws SQLException;
    boolean update(E e) throws SQLException;
}
