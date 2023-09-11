package ru.eugenebay.the.io.magazine.console;

import ru.eugenebay.the.io.magazine.common.Quote;
import ru.eugenebay.the.io.magazine.model.Label;
import ru.eugenebay.the.io.magazine.model.Post;
import ru.eugenebay.the.io.magazine.model.Writer;

import java.util.List;
import java.util.Set;

public class ConsoleRunner {

    public static void run() {
        var w = Writer.builder()
                .firstName("Станислав")
                .lastName("Ежи Лец")
                .posts(List.of(
                        Post.builder()
                                .postContent("Из одной системы нам еще долго не выбраться — из солнечной.")
                                .labels(
                                        Set.of(new Label(1L, "Earth"), new Label(2L, "Sun"))
                                )
                                .build()
                ))
                .build();
        new Quote().say(w);
    }
}
