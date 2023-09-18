package ru.eugenebay.the.io.magazine.common;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Slf4j
public class ApplicationObjectFactory {
    private final ApplicationContext context;
    private final List<ObjectTuner> objectTuners = new ArrayList<>();

    @SneakyThrows
    public ApplicationObjectFactory(ApplicationContext context) {
        this.context = context;
        //TODO Sh*t code
        Set<Class<? extends ObjectTuner>> tunerTypes = context.getImplementationFinder().getReflect().getSubTypesOf(ObjectTuner.class);
        for (Class<? extends ObjectTuner> type : tunerTypes) {
            ObjectTuner tuner = type.getDeclaredConstructor().newInstance();
            objectTuners.add(tuner);
        }
    }

    @SneakyThrows
    public <T> T createObject(Class<T> implementation) {
        T instance = implementation.getDeclaredConstructor().newInstance();
        objectTuners.forEach(tuner -> tuner.tune(instance, context));
        postConstructInvocation(instance);
        return instance;
    }

    @SneakyThrows
    private <T> void postConstructInvocation(T instance) {
        for (Method method : instance.getClass().getMethods()) {
            if (method.isAnnotationPresent(PostConstruct.class)) {
                method.invoke(instance);
            }
        }
    }
}
