package simple.moveRobot2;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class MoveRobot2 {
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

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        int count = 0;
        boolean success = false;
        while (!success && count < 3) {
            count++;
            try (RobotConnection connection = robotConnectionManager
                    .getConnection()) {
                connection.moveRobotTo(toX, toY);
                count = 3;
                success = true;
            } catch (RobotConnectionException e) {
            }
        }
        if (!success) {
            throw new RobotConnectionException("failure");
        }
    }

}

interface RobotConnection extends AutoCloseable {
    void moveRobotTo(int x, int y);

    @Override
    void close();
}

interface RobotConnectionManager {
    RobotConnection getConnection();
}

class RobotConnectionException extends RuntimeException {

    public RobotConnectionException() {
        super();

    }

    public RobotConnectionException(String message) {
        super(message);

    }

    public RobotConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}