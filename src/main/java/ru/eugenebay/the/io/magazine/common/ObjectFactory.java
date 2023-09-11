package ru.eugenebay.the.io.magazine.common;

import lombok.SneakyThrows;
import ru.eugenebay.the.io.magazine.config.ApplicationJavaConfig;
import ru.eugenebay.the.io.magazine.config.Config;

public class ObjectFactory {
    private static final ObjectFactory INSTANCE = new ObjectFactory();
    private static final String packagePath = "ru.eugenebay.the.io.magazine";
    private final Config config;

    private ObjectFactory() {
        this.config = new ApplicationJavaConfig(packagePath);
    }

    public static ObjectFactory getInstance() {
        return INSTANCE;
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        Class<? extends T> targetClass = type;
        if (targetClass.isInterface())
            targetClass = config.getInterfaceImplementation(type);
        return targetClass.getDeclaredConstructor().newInstance();
    }
}
