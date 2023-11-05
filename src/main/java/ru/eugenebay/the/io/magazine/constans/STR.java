package ru.eugenebay.the.io.magazine.constans;

import lombok.Getter;

@Getter
public enum STR {
    DEFAULT_PACKAGE_TO_SCAN("ru.eugenebay.the.io.magazine"),
    APPLICATION_PROPS_PATH("application.properties");

    private final String value;

    STR(String value) {
        this.value = value;
    }
}
