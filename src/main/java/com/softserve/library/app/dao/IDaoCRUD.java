package com.softserve.library.app.dao;

import java.sql.SQLException;
import java.util.List;

public interface IDaoCRUD<Entity> {
    Entity get(int id) throws SQLException;

    List<Entity> getAll() throws SQLException;

    boolean add(Entity entity) throws SQLException;

    boolean update(Entity entity) throws SQLException;

    boolean delete(int id) throws SQLException;
}
