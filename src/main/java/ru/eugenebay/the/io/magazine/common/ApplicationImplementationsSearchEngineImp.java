package ru.eugenebay.the.io.magazine.common;

import lombok.extern.slf4j.Slf4j;
import org.reflections.Reflections;
import ru.eugenebay.the.io.magazine.exception.MultipleInterfaceImplementationException;

import java.util.Set;

//TODO Make logger in Reflection lib silent
@Slf4j
public class ApplicationImplementationsSearchEngineImp implements ImplementationsSearchEngine {
    private final Reflections reflect;

    public ApplicationImplementationsSearchEngineImp(String pathForThePackageToBeScanned) {
        this.reflect = new Reflections(pathForThePackageToBeScanned);
    }

    @Override
    public <T> Class<? extends T> searchInterfaceImplementation(Class<T> interfaceName) {
        Set<Class<? extends T>> reflectTypes = reflect.getSubTypesOf(interfaceName);
        if (reflectTypes.size() != 1) {
            var ex = new MultipleInterfaceImplementationException("The interface has none or several implementations.");
            log.error(ex.getLocalizedMessage());
            throw ex;
        }
        return reflectTypes.iterator().next();
    }
}
