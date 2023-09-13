package ru.eugenebay.the.io.magazine.console;

import static ru.eugenebay.the.io.magazine.console.ConsoleColor.WHITE;

public class ConsoleAnnouncer implements Announcer {
    @Override
    public <T> void announce(T context) {
        colorfulAnnounce(context, WHITE);
    }
}
