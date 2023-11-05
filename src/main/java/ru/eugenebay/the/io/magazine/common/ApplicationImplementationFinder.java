package ru.eugenebay.the.io.magazine.common;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.reflections.Reflections;
import ru.eugenebay.the.io.magazine.annotations.ImplementationFinder;
import ru.eugenebay.the.io.magazine.exception.MultipleInterfaceImplementationException;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//TODO Make logger in Reflection lib silent
@Slf4j
public class ApplicationImplementationFinder implements ImplementationFinder {
    @Getter
    private final Reflections reflect;
    //TODO Multi-Map Map<Class<?>, List<Class<?>>
    private final Map<Class<?>, Class<?>> implementationsMap = new HashMap<>();

    public ApplicationImplementationFinder(String packageToScan) {
        this.reflect = new Reflections(packageToScan);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> Class<? extends T> findImplementation(Class<T> interfaceName) {
        Class<?> computedClass = implementationsMap.computeIfAbsent(interfaceName, reflectedClass -> {
            Set<Class<? extends T>> reflectTypes = reflect.getSubTypesOf(interfaceName);
            if (reflectTypes.size() != 1) {
                var ex = new MultipleInterfaceImplementationException("The interface has none or several implementations.");
                log.error(ex.getLocalizedMessage());
                throw ex;
            }
            return reflectTypes.iterator().next();
        });
        return (Class<? extends T>) computedClass;
    }
}
