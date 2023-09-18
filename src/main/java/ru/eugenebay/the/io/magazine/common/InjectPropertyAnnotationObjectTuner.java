package ru.eugenebay.the.io.magazine.common;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class InjectPropertyAnnotationObjectTuner implements ObjectTuner {
    private final Map<String, String> propertiesMap;

    public InjectPropertyAnnotationObjectTuner() {
        this.propertiesMap = getPropertiesMap();
    }

    @Override
    @SneakyThrows
    public void tune(Object o, ApplicationContext context) {
        for (Field field : o.getClass().getDeclaredFields()) {
            var annotation = field.getAnnotation(InjectProperty.class);
            if (Objects.nonNull(annotation)) {
                String value = (annotation.value().isEmpty()) ? propertiesMap.get(field.getName()) : propertiesMap.get(annotation.value());
                field.setAccessible(true);
                field.set(o, value);
            }
        }
    }

    private Map<String, String> getPropertiesMap() {
        Map<String, String> propertiesMap = null;
        InputStream systemResourceAsStream = ClassLoader.getSystemResourceAsStream("application.properties");
        if (Objects.nonNull(systemResourceAsStream)) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(systemResourceAsStream))) {
                Stream<String> lines = reader.lines();
                propertiesMap = lines
                        .map(line -> line.split("="))
                        .collect(Collectors.toMap(arr -> arr[0], arr -> arr[1]));
            } catch (IOException ex) {
                log.error(ex.getLocalizedMessage());
            }
        }
        //TODO create file application.properties
        // Can I create file at runtime in resource folder?
        return Objects.nonNull(propertiesMap) ? propertiesMap : new HashMap<>();
    }
}
