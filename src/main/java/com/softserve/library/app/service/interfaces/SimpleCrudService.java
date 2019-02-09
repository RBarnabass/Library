package com.softserve.library.app.service.interfaces;

public interface SimpleCrudService<E> {

    E get(int id);
    void add(E e);
    void delete(int id);
    void update(E e);
}
