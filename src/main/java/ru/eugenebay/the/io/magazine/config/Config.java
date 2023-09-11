package ru.eugenebay.the.io.magazine.config;

public interface Config {
    <T> Class<? extends T> getInterfaceImplementation(Class<T> interfaceName);
}
