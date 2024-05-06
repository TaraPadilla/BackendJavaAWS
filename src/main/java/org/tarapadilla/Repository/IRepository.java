package org.tarapadilla.Repository;

import java.sql.SQLException;
import java.util.List;

public interface IRepository<T> {
    List<T> getAll() throws SQLException;
    T getById(Integer id) throws SQLException;
    void save(T t) throws SQLException;
    void delete(T t) throws SQLException;
}
