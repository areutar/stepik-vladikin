package module6._622.getEvenNumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        if (input == null) {    
            return;
        }
        String[] strings = input.split("\\s+");
        List<String> evens = new ArrayList<>();
        for (int i = strings.length - 1; i >= 0; i--) {
            if (i % 2 == 1) {
                evens.add(strings[i]);
            }
        }
        System.out.println(String.join(" ", evens));
    }
}
