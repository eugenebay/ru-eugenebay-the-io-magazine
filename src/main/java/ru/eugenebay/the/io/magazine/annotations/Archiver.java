package ru.eugenebay.the.io.magazine.annotations;

import java.util.List;

public interface Archiver<T> {
    void archive(List<T> list);
}
