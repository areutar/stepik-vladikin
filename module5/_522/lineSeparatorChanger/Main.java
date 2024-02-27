package module5._522.lineSeparatorChanger;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Main {
    public static final int R = 13;
    public static final int N = 10;

    public static void main(String[] args) {
        try (InputStream sin = System.in;
                OutputStream sout = System.out;) {
            int byt;
            boolean byteIsR = false;
            while ((byt = sin.read()) != -1) {
                if (byteIsR && byt != N) {
                    sout.write(R);
                }
                if (byt != R) {
                    sout.write(byt);
                }
                byteIsR = (byt == R);
            }
            if (byteIsR) {
                sout.write(R);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.flush();
        }
    }
}
