package module4._431.configureLogging;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class Main {
    @SuppressWarnings("unused")
    private static void configureLogging() {
        Logger loggerA = Logger.getLogger("org.stepic.java.logging.ClassA");
        Logger loggerB = Logger.getLogger("org.stepic.java.logging.ClassB");
        loggerA.setLevel(Level.ALL);
        loggerB.setLevel(Level.WARNING);

        Logger loggerC = Logger.getLogger("org.stepic.java");
        loggerC.setUseParentHandlers(false);
        Handler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        consoleHandler.setFormatter(new XMLFormatter());
        loggerC.addHandler(consoleHandler);
    }

    

}
