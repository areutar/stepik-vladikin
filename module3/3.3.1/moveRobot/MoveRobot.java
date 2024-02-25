package simple.moveRobot;

public class MoveRobot {   

    public static void moveRobot(Robot robot, int toX, int toY) {
        if (toY < robot.getY()) {
            setDirection(robot, Direction.DOWN);
        }
        if (toY > robot.getY()) {
            setDirection(robot, Direction.UP);
        }
        stepsForward(robot, robot.getY() - toY);

        if (toX < robot.getX()) {
            setDirection(robot, Direction.LEFT);
        }
        if (toX > robot.getX()) {
            setDirection(robot, Direction.RIGHT);
        }
        stepsForward(robot, robot.getX() - toX);

        System.out.println("x=" + robot.getX() + " y=" + robot.getY());
    }

    public static void setDirection(Robot robot, Direction direction) {
        while (robot.getDirection() != direction) {
            robot.turnLeft();
        }
    }

    public static void stepsForward(Robot robot, int number) {
        for (int i = 0; i < Math.abs(number); i++) {
            robot.stepForward();
        }
    }

    public class Robot {
        private Direction direction;
        private int x;
        private int y;

        public Robot(Direction direction, int x, int y) {
            this.direction = direction;
            this.x = x;
            this.y = y;
        }

        public Direction getDirection() {
            return direction;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void turnLeft() {
            direction = Direction.values()[(direction.ordinal() + 3) % 4];
        }

        public void turnRight() {
            direction = Direction.values()[(direction.ordinal() + 1) % 4];
        }

        public void stepForward() {
            switch (direction) {
                case UP:
                    this.y++;
                    break;
                case RIGHT:
                    this.x++;
                    break;
                case DOWN:
                    this.y--;
                    break;
                case LEFT:
                    this.x--;
                    break;
            }
        }
    }

    public enum Direction {
        UP,
        RIGHT,
        DOWN,
        LEFT
    }

}