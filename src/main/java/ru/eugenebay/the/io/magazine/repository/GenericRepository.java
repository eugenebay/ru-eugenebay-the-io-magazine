package ru.eugenebay.the.io.magazine.repository;

import ru.eugenebay.the.io.magazine.annotations.Archiver;
import ru.eugenebay.the.io.magazine.annotations.Numerator;

import java.util.List;

public interface GenericRepository<T, ID> extends Numerator<T, ID>, Archiver<T> {
    List<T> getAll();

    T getById(ID id);

    T save(T t);

    T update(T t);

    void deleteById(ID id);
}
