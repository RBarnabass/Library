package com.softserve.library.app.service.interfaces;

import java.sql.SQLException;

public interface SimpleCrudService<E> {

    E get(int id) throws SQLException;
    boolean add(E e) throws SQLException;
    boolean delete(int id) throws SQLException;
    boolean update(E e) throws SQLException;
}
