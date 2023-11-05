package ru.eugenebay.the.io.magazine.model;

import lombok.extern.slf4j.Slf4j;
import ru.eugenebay.the.io.magazine.annotations.InjectByType;
import ru.eugenebay.the.io.magazine.annotations.Singleton;
import ru.eugenebay.the.io.magazine.annotations.Announcer;
import ru.eugenebay.the.io.magazine.console.ConsoleMessageEX;
import ru.eugenebay.the.io.magazine.console.QuotationBook;

import java.util.Objects;

import static ru.eugenebay.the.io.magazine.console.ConsoleColor.BLACK_BOLD;
import static ru.eugenebay.the.io.magazine.console.ConsoleColor.GREEN_BOLD;
import static ru.eugenebay.the.io.magazine.console.ConsoleColor.WHITE;

@Slf4j
@Singleton
public class Quote implements QuotationBook {
    @InjectByType
    private Announcer announcer;
    // List of default Writers

    @Override
    public void randomQuote() {
        announcer.colorfulAnnounce(QuotationBook.class.getName(), GREEN_BOLD);
    }

    public void sayQuote(Writer writer) {
        var post = writer.getPosts()
                .stream()
                .findFirst()
                .orElseThrow(() -> {
                    var ex = new IllegalArgumentException("This writer has no posts.");
                    //TODO Test without logger
                    log.error(ex.getLocalizedMessage());
                    return ex;
                });
        if (Objects.nonNull(post)) {
            announcer.colorfulAnnounce(ConsoleMessageEX.TITLE.getMessage(), GREEN_BOLD);
            announcer.announce(post);
            announcer.colorfulFormatAnnounce(writer, WHITE);
            if (post.getLabels().isEmpty())
                announcer.colorfulFormatIndentAnnounce("", 50, BLACK_BOLD);
            else
                announcer.colorfulFormatIndentAnnounce(post.getLabels(), 50, BLACK_BOLD);
        }
    }
}
