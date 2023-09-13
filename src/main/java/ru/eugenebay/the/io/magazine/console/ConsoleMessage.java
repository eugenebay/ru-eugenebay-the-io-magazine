package ru.eugenebay.the.io.magazine.console;

import lombok.Getter;

@Getter
public enum ConsoleMessage {
    TITLE("The IO Magazine"),
    MAIN("TODO TEXT");

    private final String message;

    ConsoleMessage(String message) {
        this.message = message;
    }
}
