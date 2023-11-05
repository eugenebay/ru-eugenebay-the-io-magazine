package ru.eugenebay.the.io.magazine.console;

import java.util.function.Function;
import java.util.stream.IntStream;

public class FunctionExecutor implements Function<Boolean, Boolean> {
    @Override
    public Boolean apply(Boolean value) {
        System.out.println("START");
        IntStream.range(0, 3)
                .forEach(num -> {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException ex) {
                        //log.error(ex.getLocalizedMessage());
                    }
                    System.out.println(".");
                });
        System.out.println("END");
        return value ? Boolean.FALSE : Boolean.TRUE;
    }
}
