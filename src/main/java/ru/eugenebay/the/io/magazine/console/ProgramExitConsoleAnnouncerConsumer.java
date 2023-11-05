package ru.eugenebay.the.io.magazine.console;

import lombok.extern.slf4j.Slf4j;
import ru.eugenebay.the.io.magazine.annotations.Announcer;
import ru.eugenebay.the.io.magazine.annotations.InjectByType;

import java.util.stream.IntStream;

import static ru.eugenebay.the.io.magazine.console.ConsoleColor.GREEN_BOLD;

@Slf4j
public class ProgramExitConsoleAnnouncerConsumer implements ConsoleConsumer {
    //TODO FunctionExecutors?
    @InjectByType
    private Announcer announcer;

    @Override
    public void accept(String action) {
        announcer.colorfulFormatAnnounce("Program is terminated", GREEN_BOLD);
        IntStream.range(0, 3)
                .forEach(num -> {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException ex) {
                        log.error(ex.getLocalizedMessage());
                    }
                    announcer.colorfulFormatAnnounce(".", GREEN_BOLD);
                });
    }
}
