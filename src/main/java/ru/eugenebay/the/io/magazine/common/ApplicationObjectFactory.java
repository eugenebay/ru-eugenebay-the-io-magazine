package ru.eugenebay.the.io.magazine.common;

import lombok.SneakyThrows;

public class ApplicationObjectFactory {
    private static final ApplicationObjectFactory INSTANCE = new ApplicationObjectFactory();
    private static final String packagePath = "ru.eugenebay.the.io.magazine";
    private final ImplementationsSearchEngine implementationsSearchEngine;

    private ApplicationObjectFactory() {
        this.implementationsSearchEngine = new ApplicationImplementationsSearchEngineImp(packagePath);
    }

    public static ApplicationObjectFactory getInstance() {
        return INSTANCE;
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        Class<? extends T> targetClass = type;
        if (targetClass.isInterface())
            targetClass = implementationsSearchEngine.searchInterfaceImplementation(type);
        return targetClass.getDeclaredConstructor().newInstance();
    }
}
