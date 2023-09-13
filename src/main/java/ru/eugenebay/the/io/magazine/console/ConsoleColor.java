package ru.eugenebay.the.io.magazine.console;

import lombok.Getter;

@Getter
public enum ConsoleColor {
    RESET("\033[0m"),
    BLACK_BOLD("\033[1;90m"),
    RED_BOLD("\033[1;91m"),
    GREEN_BOLD("\033[1;92m"),
    YELLOW_BOLD("\033[1;93m"),
    BLUE_BOLD("\033[1;94m"),
    PURPLE_BOLD("\033[1;95m"),
    CYAN_BOLD("\033[1;96m"),
    WHITE("\033[0;97m"),
    WHITE_BOLD("\033[1;97m");

    private final String color;

    ConsoleColor(String color) {
        this.color = color;
    }
}
