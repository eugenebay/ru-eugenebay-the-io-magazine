package ru.eugenebay.the.io.magazine.common;

import lombok.Getter;
import lombok.Setter;
import ru.eugenebay.the.io.magazine.annotations.ImplementationFinder;
import ru.eugenebay.the.io.magazine.annotations.Singleton;
import ru.eugenebay.the.io.magazine.config.ApplicationPropertiesConfig;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ApplicationContext {
    @Setter
    private ApplicationObjectFactory factory;
    @Getter
    private final ApplicationPropertiesConfig applicationConfig;
    @Getter
    private final ImplementationFinder implementationFinder;
    private final Map<Class<?>, Object> contextCache = new ConcurrentHashMap<>();

    public ApplicationContext(ApplicationPropertiesConfig applicationConfig, ImplementationFinder implementationFinder) {
        this.applicationConfig = applicationConfig;
        this.implementationFinder = implementationFinder;
    }

    @SuppressWarnings("unchecked")
    public <T> T getObject(Class<T> type) {
        if (contextCache.containsKey(type)) {
            return (T) contextCache.get(type);
        }
        Class<? extends T> implementation = type;
        if (implementation.isInterface()) {
            implementation = implementationFinder.findImplementation(type);
        }
        T instance = factory.createObject(implementation);
        if (implementation.isAnnotationPresent(Singleton.class)) {
            contextCache.put(type, instance);
        }
        return instance;
    }
}
