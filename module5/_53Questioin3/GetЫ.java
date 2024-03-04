package module5._53Questioin3;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class GetЫ {
    public static void main(String[] args) {
        byte[] bytes = "Ы".getBytes(StandardCharsets.UTF_8);
        System.out.println(Arrays.toString(bytes));
        for (byte b : bytes) {
            System.out.print(Byte.toUnsignedInt(b) + " ");
        }       
    }
}
