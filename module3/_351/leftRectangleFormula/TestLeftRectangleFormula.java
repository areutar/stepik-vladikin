package module3._351.leftRectangleFormula;

import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sin;
import static org.junit.Assert.assertTrue;
import static module3._351.leftRectangleFormula.LeftRectangleFormula.leftRectangleFormula;

import java.util.function.DoubleUnaryOperator;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestLeftRectangleFormula {
    @ParameterizedTest
    @MethodSource("provideParams")
    void testLeftRectangleFormula(
            DoubleUnaryOperator operator,
            double start,
            double end,
            double expected,
            double delta) {
        double actual = leftRectangleFormula(operator, start, end);
        assertTrue(abs(abs(expected) - abs(actual)) <= delta);
    }

    public static Stream<Arguments> provideParams() {
        double delta = 1e-6d;
        DoubleUnaryOperator operatorOne = x -> 1;
        DoubleUnaryOperator operatorIdentity = x -> x;
        DoubleUnaryOperator operatorSin = x -> sin(x);
        DoubleUnaryOperator operatorXX = x -> pow(x, 2);
        DoubleUnaryOperator operatorXXX = x -> pow(x, 3);
        return Stream.of(
                Arguments.of(operatorOne, 0, 10, 10, delta),
                Arguments.of(operatorIdentity, -2, 2, 0, delta),
                Arguments.of(operatorSin, -2, 2, 0, delta),
                Arguments.of(operatorXX, -1, 1, 2.0 / 3, delta),
                Arguments.of(operatorXX, -1, -1, 0, delta),
                Arguments.of(operatorXXX, 2, 3, 65.0 / 4, 1e-5d),
                Arguments.of(operatorXXX, 1, 1, 0, 1e-5d)
                );
    }

}