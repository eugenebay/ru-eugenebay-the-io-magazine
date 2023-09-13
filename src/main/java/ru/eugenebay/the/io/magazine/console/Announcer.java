package ru.eugenebay.the.io.magazine.console;

public interface Announcer extends ColorfulAnnouncer {
    <T> void announce(T context);
}
