package com.softserve.library.app.dao.interfaces;

public interface SimpleCrudDao<E> {

    E get(int id);
    void add(E e);
    void delete(int id);
    void update(E e);
}
