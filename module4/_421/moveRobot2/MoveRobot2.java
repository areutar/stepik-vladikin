package module4._421.moveRobot2;

public class MoveRobot2 {
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