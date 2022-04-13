package by.it.academy.jd2.reunova.dao;

public interface DAO<T> {
    void select(T t);

    void update(T t, String nameColumn, String newValue, int id);

    void delete(T t, int id);

    void insert(T t);
}
