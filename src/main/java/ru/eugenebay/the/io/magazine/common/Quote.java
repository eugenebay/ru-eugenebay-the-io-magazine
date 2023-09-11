package ru.eugenebay.the.io.magazine.common;

import lombok.extern.java.Log;
import ru.eugenebay.the.io.magazine.console.Announcer;
import ru.eugenebay.the.io.magazine.console.ConsoleColor;
import ru.eugenebay.the.io.magazine.model.Writer;

@Log
public class Quote {
    private static final String TITLE = "The IO Magazine";
    private final Announcer announcer = ObjectFactory.getInstance().createObject(Announcer.class);

    public void say(Writer writer) {
        announcer.colorfulAnnounce(TITLE, ConsoleColor.GREEN);
        var post = writer.getPosts()
                .stream()
                .findAny()
                .orElseThrow(() -> {
                    var ex = new IllegalArgumentException("This writer has no posts.");
                    log.warning(ex.getLocalizedMessage());
                    return ex;
                });
        System.out.println(post);
        System.out.printf("%s", writer);
        System.out.printf("%40s%n", post.getLabels());
    }
}
