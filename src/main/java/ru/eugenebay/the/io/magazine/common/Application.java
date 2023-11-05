package ru.eugenebay.the.io.magazine.common;

import ru.eugenebay.the.io.magazine.annotations.Conveyor;
import ru.eugenebay.the.io.magazine.config.ApplicationPropertiesConfig;

import static ru.eugenebay.the.io.magazine.constans.STR.APPLICATION_PROPS_PATH;
import static ru.eugenebay.the.io.magazine.constans.STR.DEFAULT_PACKAGE_TO_SCAN;

public class Application {
    public static void run(String... args) {
        //TODO init all @Singleton classes
        var applicationConfig = new ApplicationPropertiesConfig(APPLICATION_PROPS_PATH.getValue());
        var implementationFinder = new ApplicationImplementationFinder(DEFAULT_PACKAGE_TO_SCAN.getValue());
        var context = new ApplicationContext(applicationConfig, implementationFinder);
        var factory = new ApplicationObjectFactory(context);
        context.setFactory(factory);
        var conveyor = context.getObject(Conveyor.class);
        conveyor.convey(true);
    }
}
