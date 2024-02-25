package module3._331.moveRobot;

import static module3._331.moveRobot.MoveRobot.moveRobot;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import module3._331.moveRobot.MoveRobot.Direction;
import module3._331.moveRobot.MoveRobot.Robot;

public class TestMoveRobot {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private Robot robot;

    @BeforeEach
    void setSystemOut() {
        MoveRobot mRobot = new MoveRobot();
        robot = mRobot.new Robot(Direction.UP, 0, 0);
        System.setOut(new PrintStream(out));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "-1, -1, 'x=-1 y=-1'",
            "-1, 1, 'x=-1 y=1'",
            "-1, 0, 'x=-1 y=0'",
            "0, -1, 'x=0 y=-1'",
            "0, 0, 'x=0 y=0'",
            "0, 1, 'x=0 y=1'",
            "1, -1, 'x=1 y=-1'",
            "1, 0, 'x=1 y=0'",
            "1, 1, 'x=1 y=1'",
    })
    void testMoveRobot(int toX, int toY, String expected) {
        moveRobot(robot, toX, toY);
        assertEquals(expected, out.toString().stripTrailing());
    }

    @AfterEach
    void restoreOut() {
        System.setOut(null);
    }

    @BeforeEach
    void setSystemOut1() {
        MoveRobot mRobot = new MoveRobot();
        robot = mRobot.new Robot(Direction.LEFT, -3, 12);
        System.setOut(new PrintStream(out));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "-1, -1, 'x=-1 y=-1'",
            "-1, 1, 'x=-1 y=1'",
            "-1, 0, 'x=-1 y=0'",
            "0, -1, 'x=0 y=-1'",
            "0, 0, 'x=0 y=0'",
            "0, 1, 'x=0 y=1'",
            "1, -1, 'x=1 y=-1'",
            "1, 0, 'x=1 y=0'",
            "1, 1, 'x=1 y=1'",
    })
    void testMoveRobot1(int toX, int toY, String expected) {
        moveRobot(robot, toX, toY);
        assertEquals(expected, out.toString().stripTrailing());
    }

    @AfterEach
    void restoreOut1() {
        System.setOut(null);
    }

}