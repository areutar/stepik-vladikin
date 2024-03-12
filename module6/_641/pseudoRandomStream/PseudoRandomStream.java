package module6._641.pseudoRandomStream;

import java.util.stream.IntStream;

public class PseudoRandomStream {
    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, i -> {
            String squareString = String.valueOf(i * i);
            int rightIndex = squareString.length() - 1;
            int leftIndex = Math.max(0, rightIndex - 3);
            return rightIndex - leftIndex > 0
                    ? Integer.parseInt(
                            squareString.substring(leftIndex, rightIndex))
                    : 0;
        });
    }
}
