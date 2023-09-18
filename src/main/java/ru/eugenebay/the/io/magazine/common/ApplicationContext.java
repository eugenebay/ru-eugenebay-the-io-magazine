package ru.eugenebay.the.io.magazine.common;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ApplicationContext {
    @Setter
    private ApplicationObjectFactory factory;
    @Getter
    private final ImplementationFinder implementationFinder;
    private final Map<Class<?>, Object> contextCache = new ConcurrentHashMap<>();

    public ApplicationContext(ImplementationFinder implementationFinder) {
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
