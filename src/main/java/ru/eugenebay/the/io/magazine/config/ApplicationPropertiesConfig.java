package ru.eugenebay.the.io.magazine.config;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import ru.eugenebay.the.io.magazine.annotations.Singleton;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Singleton
@Getter
@Slf4j
public class ApplicationPropertiesConfig {
    private final Map<String, String> applicationProperties;

    public ApplicationPropertiesConfig(String pathToThePropertiesFile) {
        this.applicationProperties = constructApplicationPropertiesMap(pathToThePropertiesFile);
    }

    private Map<String, String> constructApplicationPropertiesMap(String pathToThePropertiesFile) {
        Map<String, String> applicationProperties = null;
        InputStream systemResourceAsStream = ClassLoader.getSystemResourceAsStream(pathToThePropertiesFile);
        if (Objects.nonNull(systemResourceAsStream)) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(systemResourceAsStream))) {
                Stream<String> lines = reader.lines();
                applicationProperties = lines
                        .map(line -> line.split("="))
                        .collect(Collectors.toMap(arr -> arr[0], arr -> arr[1]));
            } catch (IOException ex) {
                log.error(ex.getLocalizedMessage());
            }
        }
        return Objects.nonNull(applicationProperties) ? applicationProperties : new HashMap<>();
    }
}
