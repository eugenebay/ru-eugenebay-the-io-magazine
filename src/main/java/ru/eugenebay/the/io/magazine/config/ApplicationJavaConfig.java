package ru.eugenebay.the.io.magazine.config;

import lombok.extern.java.Log;
import org.reflections.Reflections;
import ru.eugenebay.the.io.magazine.exception.MultipleInterfaceImplementationException;

import java.util.Set;

@Log
public class ApplicationJavaConfig implements Config {
    private final Reflections reflect;

    public ApplicationJavaConfig(String pathForThePackageToBeScanned) {
        this.reflect = new Reflections(pathForThePackageToBeScanned);
    }

    @Override
    public <T> Class<? extends T> getInterfaceImplementation(Class<T> interfaceName) {
        Set<Class<? extends T>> reflectTypes = reflect.getSubTypesOf(interfaceName);
        if (reflectTypes.size() != 1) {
            var ex = new MultipleInterfaceImplementationException("The interface has none or several implementations.");
            log.warning(ex.getLocalizedMessage());
            throw ex;
        }
        return reflectTypes.iterator().next();
    }
}
