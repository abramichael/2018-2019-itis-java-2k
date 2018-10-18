package dao;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {
    T get(long i);
    void update(T obj);
    void delete(long i);
    void create(T obj);
    List<T> getAll();
}
