package ru.eugenebay.the.io.magazine.console;

import lombok.extern.slf4j.Slf4j;
import ru.eugenebay.the.io.magazine.annotations.Listener;
import ru.eugenebay.the.io.magazine.validation.ApplicationValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Slf4j
public class ConsoleListener implements Listener {
    private final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public String listen() {
        String line = null;
        try {
            line = READER.readLine();
            if (ApplicationValidator.isExit(line)) {
                try {
                    READER.close();
                    log.info("BufferedReader is closed...");
                } catch (IOException ex) {
                    log.error(ex.getLocalizedMessage());
                }
            }
        } catch (IOException ex) {
            log.error(ex.getLocalizedMessage());
        }
        return line;
    }
}
