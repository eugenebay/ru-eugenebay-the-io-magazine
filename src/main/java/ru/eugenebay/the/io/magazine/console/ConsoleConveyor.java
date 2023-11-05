package ru.eugenebay.the.io.magazine.console;

import ru.eugenebay.the.io.magazine.annotations.Announcer;
import ru.eugenebay.the.io.magazine.annotations.Conveyor;
import ru.eugenebay.the.io.magazine.annotations.InjectByType;
import ru.eugenebay.the.io.magazine.annotations.Listener;

import java.util.HashMap;

import static ru.eugenebay.the.io.magazine.console.ConsoleColor.GREEN_BOLD;
import static ru.eugenebay.the.io.magazine.console.ConsoleMessageEX.TITLE;

public class ConsoleConveyor implements Conveyor {
    @InjectByType
    private Listener listener;
    @InjectByType
    private Announcer announcer;
    @InjectByType
    private ConsoleConsumer consumer; // TODO mb change on functionHashMap with FunctionExecutors
    @InjectByType
    private QuotationBook quotationBook;

    //TODO Inject all views
    //TODO Mb here settle default chain label -> posts -> writers

    @Override
    public void convey(boolean isDistributionWorking) {
        announcer.colorfulAnnounce(TITLE.getMessage(), GREEN_BOLD);
        while (isDistributionWorking) {
            var action = listener.listen();
            //someMethod(line);
            HashMap<String, FunctionExecutor> functionHashMap = new HashMap<>();
            functionHashMap.put("exit", new FunctionExecutor());
            //storeForFunctionHashMap.call(action, from, to);
            if (action.isEmpty()) {
                quotationBook.randomQuote();
                // TODO if we stay here QUOTE don't be beautified by console print look say() method in Quote
                announcer.colorfulAnnounce(TITLE.getMessage(), GREEN_BOLD);
            }
            if (action.equalsIgnoreCase("exit")) {
                isDistributionWorking = functionHashMap.get(action).apply(isDistributionWorking);
                //consumer.accept(action);
                //isDistributionWorking = ApplicationHelper.changingBooleanValue(isDistributionWorking);
            } else
                announcer.announce(action);
        }
//        purpleAnnounceText(MAIN.message);
//        //new ConsoleAnnouncer().colorfulAnnounce(MAIN.message, PURPLE_BOLD_BRIGHT);
//        while (isDistributionWorking) {
//            var line = listener.listen();
//            switch (line) {
//                case "1", "2", "3" -> applicationContext.print();
//                case "4" -> greenLocalTimeAnnounceText();
//                case "5" -> {
//                    isDistributionWorking = ApplicationHelper.changingBooleanValue(isDistributionWorking);
//                    programExitAnnounceText();
//                }
//                default -> redEnteredValueIncorrectAnnounceText();
//            }
//        }
    }

    private void someMethod(String line) {
    }
}
