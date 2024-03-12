package module6._643.tenFrequentWords;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TenFrequentWords {
    public static void main(String[] args) {
        String input = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus. Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio nec mi tempor dignissim.";
        byte[] bytes = input.getBytes(StandardCharsets.UTF_8);
        System.setIn(new ByteArrayInputStream(bytes));
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in, StandardCharsets.UTF_8));
        Map<String, Integer> frequencyMap = reader.lines()
                .flatMap(line -> Arrays.stream(line.split("[^\\p{IsAlnum}]+")))
                .map(String::toLowerCase)
                .collect(Collectors.toMap(Function.identity(),
                        s -> 1,
                        (t, i) -> t + i));
        frequencyMap.forEach((k, v) -> System.out.println(k + " " + v));
        frequencyMap.keySet().stream()
                .sorted((s1, s2) -> {
                    int frequency = frequencyMap.get(s2) - frequencyMap.get(s1);
                    return frequency == 0
                            ? s1.compareTo(s2)
                            : frequency;
                })
                .limit(10)
                .forEach(System.out::println);
    }
}
