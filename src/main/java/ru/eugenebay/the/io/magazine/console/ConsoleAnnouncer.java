package ru.eugenebay.the.io.magazine.console;

import ru.eugenebay.the.io.magazine.common.Singleton;

import static ru.eugenebay.the.io.magazine.console.ConsoleColor.WHITE;

@Singleton
public class ConsoleAnnouncer implements Announcer {
    @Override
    public <T> void announce(T context) {
        colorfulAnnounce(context, WHITE);
    }
}
