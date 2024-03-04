package module5._53Question4;

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

public class AsciiWriter {
    public static void main(String[] args) {
         try (Writer writer = new OutputStreamWriter(
                System.out, StandardCharsets.US_ASCII)) {
            writer.write("ю");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
