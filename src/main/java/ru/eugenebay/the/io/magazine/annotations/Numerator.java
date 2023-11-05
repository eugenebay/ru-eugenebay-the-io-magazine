package ru.eugenebay.the.io.magazine.annotations;

import java.util.List;

public interface Numerator<T, ID> {
    ID calculate(List<T> list);
}
