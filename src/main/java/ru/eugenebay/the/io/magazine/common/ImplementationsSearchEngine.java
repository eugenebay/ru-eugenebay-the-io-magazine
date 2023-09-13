package ru.eugenebay.the.io.magazine.common;

public interface ImplementationsSearchEngine {
    <T> Class<? extends T> searchInterfaceImplementation(Class<T> interfaceName);
}
