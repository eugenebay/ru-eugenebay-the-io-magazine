package ru.eugenebay.the.io.magazine.console;

public enum ConsoleColor {
    RESET("\033[0m"),
    RED("\033[1;91m"),
    GREEN("\033[1;92m"),
    PURPLE("\033[1;95m"),
    WHITE("\033[1;97m");
    public final String color;

    ConsoleColor(String color) {
        this.color = color;
    }
}
