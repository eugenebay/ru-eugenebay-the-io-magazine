package ru.eugenebay.the.io.magazine.validation;

public final class ApplicationValidator {
    private static final String EXIT = "exit";

    private ApplicationValidator() {
    }

    public static boolean isExit(String line) {
        return line.equalsIgnoreCase(EXIT);
    }
}
