package module5._532.sumOfAllNumbers;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        while (scanner.hasNext()) {
            String next = scanner.next();
            if ("ok".equals(next)) {
                break;
            }
            try {
                double d = Double.parseDouble(next);
                sum += d;
            } catch (Exception e) {
                continue;
            }
        }
        System.out.printf("%.6f", sum);
        scanner.close();
    }
}
