package ru.eugenebay.the.io.magazine.repository;

import java.util.List;

public interface Archiver<T> {
    void archive(List<T> list);
}
