package ru.eugenebay.the.io.magazine.console;

import static ru.eugenebay.the.io.magazine.console.ConsoleColor.RESET;

public interface ColorfulAnnouncer {
    default <T> void colorfulAnnounce(T context, ConsoleColor consoleColor) {
        System.out.println(consoleColor.getColor() + context + RESET.getColor());
    }

    default <T> void colorfulFormatAnnounce(T context, ConsoleColor consoleColor) {
        System.out.printf("%s", consoleColor.getColor() + context + RESET.getColor());
    }

    default <T> void colorfulFormatIndentAnnounce(T context, int indent, ConsoleColor consoleColor) {
        if (indent <= 0)
            colorfulFormatAnnounce(context, consoleColor);
        else
            System.out.printf("%" + indent + "s%n", consoleColor.getColor() + context + RESET.getColor());
    }
}
