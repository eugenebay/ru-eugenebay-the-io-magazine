package ru.eugenebay.the.io.magazine.common;

import lombok.Getter;

import java.util.List;

@Getter
public class Application {
    private static final Application App = new Application();
    private final ApplicationContext context;

    private Application() {
        this.context = new ApplicationContext();
    }

    public static Application getInstance() {
        return App;
    }

    public static void run() {
        /*var lec = Writer.builder()
                .firstName("Станислав")
                .lastName("Ежи Лец")
                .posts(List.of(
                        Post.builder()
                                .content("Из одной системы нам еще долго не выбраться — из солнечной.")
                                .labels(
                                        Set.of(new Label(1L, "Earth"), new Label(2L, "Sun"))
                                )
                                .build()
                ))
                .build();
        var vinci = Writer.builder()
                .firstName("Леонардо")
                .lastName("да Винчи")
                .posts(List.of(
                        Post.builder()
                                .content("Синева неба происходит благодаря толще освещенных частиц воздуха, которая расположена между Землей и находящейся наверху чернотой.")
                                .labels(
                                        Set.of()
                                        //Set.of(new Label(3L, "Sky"))
                                )
                                .build()
                ))
                .build();
        new Quote().say(lec);
        new Quote().say(vinci);*/
        getInstance().getContext().getLabelView().settle(List.of("Sun", "Earth"));
        System.out.println(getInstance().getContext().getLabelView().getController().getAll());
    }
}
