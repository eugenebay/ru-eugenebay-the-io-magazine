package ru.eugenebay.the.io.magazine.annotations;

import org.reflections.Reflections;

public interface ImplementationFinder {
    Reflections getReflect();

    <T> Class<? extends T> findImplementation(Class<T> interfaceName);

}
