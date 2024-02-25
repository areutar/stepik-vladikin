package module3._351.leftRectangleFormula;

import java.util.function.DoubleUnaryOperator;

public class LeftRectangleFormula {
    public static double leftRectangleFormula(
            DoubleUnaryOperator f,
            double a,
            double b) {
        double step = 1e6d;
        double PRECISION = 1e-7d * (b - a);
        double firstIntegral = leftRectangleFormula(f, a, b, step);
        double precision = firstIntegral;
        while (Math.abs(precision) > PRECISION) {
            step *= 2;
            double secondIntegral = leftRectangleFormula(f, a, b, step);
            precision = Math.abs(
                    Math.abs(secondIntegral) - Math.abs(firstIntegral));
            firstIntegral = secondIntegral;
            System.out.println(firstIntegral);
        }
        return firstIntegral;
    }

    public static double leftRectangleFormula(
            DoubleUnaryOperator f,
            double a,
            double b,
            double step) {
        double sum = 0;
        double delta = Math.abs(b - a) / step;
        double leftPoint;
        for (long i = 0; i < step; i++) {
            leftPoint = a + i * delta;
            sum += f.applyAsDouble(leftPoint);
        }
        return sum * delta;
    }

}