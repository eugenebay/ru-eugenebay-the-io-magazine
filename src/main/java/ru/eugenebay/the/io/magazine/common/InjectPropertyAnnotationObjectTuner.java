package ru.eugenebay.the.io.magazine.common;

import lombok.SneakyThrows;
import ru.eugenebay.the.io.magazine.annotations.InjectProperty;
import ru.eugenebay.the.io.magazine.annotations.ObjectTuner;

import java.lang.reflect.Field;
import java.util.Objects;

public class InjectPropertyAnnotationObjectTuner implements ObjectTuner {
    @Override
    @SneakyThrows
    public void tune(Object o, ApplicationContext context) {
        for (Field field : o.getClass().getDeclaredFields()) {
            var annotation = field.getAnnotation(InjectProperty.class);
            if (Objects.nonNull(annotation)) {
                String value = (annotation.value().isEmpty()) ?
                        context.getApplicationConfig().getApplicationProperties().get(field.getName()) :
                        context.getApplicationConfig().getApplicationProperties().get(annotation.value());
                field.setAccessible(true);
                field.set(o, value);
            }
        }
    }
}
