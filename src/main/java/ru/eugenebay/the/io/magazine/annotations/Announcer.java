package ru.eugenebay.the.io.magazine.annotations;

public interface Announcer extends ColorfulAnnouncer {
    <T> void announce(T context);
}
