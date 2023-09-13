package ru.eugenebay.the.io.magazine.model;

import lombok.extern.slf4j.Slf4j;
import ru.eugenebay.the.io.magazine.common.ApplicationObjectFactory;
import ru.eugenebay.the.io.magazine.console.Announcer;
import ru.eugenebay.the.io.magazine.console.ConsoleMessage;

import java.util.Objects;

import static ru.eugenebay.the.io.magazine.console.ConsoleColor.*;

//TODO Quote can be Singleton, cuz everytime we will be use only say() method for show writer's quote.
@Slf4j
public class Quote {
    private final Announcer announcer = ApplicationObjectFactory.getInstance().createObject(Announcer.class);

    public void say(Writer writer) {
        var post = writer.getPosts()
                .stream()
                .findAny()
                .orElseThrow(() -> {
                    var ex = new IllegalArgumentException("This writer has no posts.");
                    //TODO Test without logger
                    log.error(ex.getLocalizedMessage());
                    return ex;
                });
        if (Objects.nonNull(post)) {
            announcer.colorfulAnnounce(ConsoleMessage.TITLE.getMessage(), GREEN_BOLD);
            announcer.announce(post);
            announcer.colorfulFormatAnnounce(writer, WHITE);
            if (post.getLabels().isEmpty())
                announcer.colorfulFormatIndentAnnounce("", 50, BLACK_BOLD);
            else
                announcer.colorfulFormatIndentAnnounce(post.getLabels(), 50, BLACK_BOLD);
        }
    }
}
