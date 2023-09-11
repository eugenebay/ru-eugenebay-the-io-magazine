package ru.eugenebay.the.io.magazine.console;

import static ru.eugenebay.the.io.magazine.console.ConsoleColor.WHITE;

public class ConsoleAnnouncer implements Announcer {
    @Override
    public void announce(String text) {
        colorfulAnnounce(text, WHITE);
    }
}
