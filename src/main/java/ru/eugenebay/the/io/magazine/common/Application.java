package ru.eugenebay.the.io.magazine.common;

import lombok.Getter;
import ru.eugenebay.the.io.magazine.view.LabelView;

@Getter
public class Application {
    private static final String DEFAULT_PACKAGE_TO_SCAN = "ru.eugenebay.the.io.magazine";

    public static void run(String... args) {
        //TODO init all @Singleton classes
        var implementationFinder = new ApplicationImplementationFinder(DEFAULT_PACKAGE_TO_SCAN);
        var context = new ApplicationContext(implementationFinder);
        var factory = new ApplicationObjectFactory(context);
        context.setFactory(factory);
        LabelView labelView = context.getObject(LabelView.class);
        System.out.println(labelView.getController().getAll());
    }
}
