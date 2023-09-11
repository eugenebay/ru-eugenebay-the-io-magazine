package ru.eugenebay.the.io.magazine.console;

import static ru.eugenebay.the.io.magazine.console.ConsoleColor.RESET;

public interface ColorfulAnnouncer {
    default void colorfulAnnounce(String text, ConsoleColor consoleColor) {
        System.out.println(consoleColor.color + text + RESET.color);
    }
}
