package ru.eugenebay.the.io.magazine.repository;

import java.util.List;

public interface GenericRepository<T, ID> extends Numerator<T, ID> {
    T getById(ID id);

    List<T> getAll();

    T save(T t);

    T update(T t);

    void deleteById(ID id);
}
