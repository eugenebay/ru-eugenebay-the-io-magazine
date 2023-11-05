package ru.eugenebay.the.io.magazine.common;

import lombok.SneakyThrows;
import ru.eugenebay.the.io.magazine.annotations.InjectByType;
import ru.eugenebay.the.io.magazine.annotations.ObjectTuner;

import java.lang.reflect.Field;

public class InjectByTypeAnnotationObjectTuner implements ObjectTuner {
    @Override
    @SneakyThrows
    public void tune(Object o, ApplicationContext context) {
        for (Field field : o.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(InjectByType.class)) {
                Object obj = context.getObject(field.getType());
                field.setAccessible(true);
                field.set(o, obj);
            }
        }

    }
}
