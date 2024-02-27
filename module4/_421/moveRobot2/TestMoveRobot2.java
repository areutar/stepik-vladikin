package module4._421.moveRobot2;

import org.junit.Test;
import static org.junit.Assert.assertThrows;

public class TestMoveRobot2 {

    @Test
    public void testWhenManagerThrowArithmeticExceptionThanRethrow() {
        RobotConnectionManager manager = new RCMThrowingArithmeticException();
        assertThrows(ArithmeticException.class,
                () -> MoveRobot2.moveRobot(manager, 0, 0));

    }

    @Test
    public void testWhenMoveThrowNPEExceptionThanRethrow() {
        RobotConnectionManager manager = new RobotConnectionManager() {

            @Override
            public RobotConnection getConnection() {
                return new RobotConnectionThrowingNPEExceptionMove();
            }

        };
        assertThrows(NullPointerException.class,
                () -> MoveRobot2.moveRobot(manager, 0, 0));

    }

    @Test
    public void testWhenCloseThrowArithmeticExceptionThanRethrow() {
        RobotConnectionManager manager = new RobotConnectionManager() {

            @Override
            public RobotConnection getConnection() {
                return new RobotConnectionThrowingArithmeticExceptionClose();
            }

        };
        assertThrows(ArithmeticException.class,
                () -> MoveRobot2.moveRobot(manager, 0, 0));

    }

}

//////////////////////////////////////////////////////
// MANAGERS CLASSES

class GoodRCM implements RobotConnectionManager {

    @Override
    public RobotConnection getConnection() {
        return new GoodRobotConnection();
    }

}

class RCMThrowingArithmeticException implements RobotConnectionManager {

    @Override
    public RobotConnection getConnection() {
        System.out.println(5 / 0);
        return null;
    }

}

class RCMThrowingRCException implements RobotConnectionManager {

    @Override
    public RobotConnection getConnection() {
        throw new RobotConnectionException("RCE");
    }

}

//////////////////////////////////////////////////////
// CONNECTION CLASSES

class GoodRobotConnection implements RobotConnection {

    @Override
    public void moveRobotTo(int x, int y) {
        System.out.println("Robot moved");
    }

    @Override
    public void close() {
        System.out.println("Connection closed");
    }

}

class RobotConnectionThrowingNPEExceptionMove implements RobotConnection {

    @Override
    public void moveRobotTo(int x, int y) {
        throw new NullPointerException();
    }

    @Override
    public void close() {
        System.out.println("Connection closed");
    }

}

class RobotConnectionThrowingRCExceptionMove implements RobotConnection {

    @Override
    public void moveRobotTo(int x, int y) {
        throw new RobotConnectionException();
    }

    @Override
    public void close() {
        System.out.println("Connection closed");
    }

}

class RobotConnectionThrowingArithmeticExceptionClose implements RobotConnection {

    @Override
    public void moveRobotTo(int x, int y) {
        System.out.println("Robot moved");
    }

    @Override
    public void close() {
        throw new ArithmeticException();
    }

}

class RobotConnectionThrowingRCExceptionClose implements RobotConnection {

    @Override
    public void moveRobotTo(int x, int y) {
        System.out.println("Robot moved");
    }

    @Override
    public void close() {
        throw new RobotConnectionException();
    }

}

class RobotConnectionThrowingRCExceptionCloseAndMove implements RobotConnection {

    @Override
    public void moveRobotTo(int x, int y) {
        throw new RobotConnectionException();
    }

    @Override
    public void close() {
        throw new RobotConnectionException();
    }

}
