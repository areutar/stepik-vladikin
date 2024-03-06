package module5._531.readAsString;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Scanner;

public class ReadAsString { 
    public static String readAsString(
            InputStream inputStream,
            Charset charset) throws IOException {
        ByteArrayOutputStream oStream = new ByteArrayOutputStream();
        try (BufferedInputStream bStream = new BufferedInputStream(inputStream)) {
            int i = bStream.read();
            for (; i != -1; i = bStream.read()) {
                oStream.write(i);
            }
        }
        return new String(oStream.toByteArray(), charset);
    }

    public static String readAsString1(
            InputStream inputStream,
            Charset charset) throws IOException {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        inputStream, charset))) {
            int i;
            while ((i = reader.read()) != -1) {
                builder.append(((char) i));
            }
        }
        return builder.toString();
    }

    public static String readAsString2(InputStream inputStream, Charset charset)
            throws IOException {
        String text = null;
        Scanner scanner = new Scanner(
                inputStream, charset.name())
                .useDelimiter("\\A");
        text = scanner.hasNext()
                ? scanner.next()
                : "";
        if (scanner.ioException() != null) {
            scanner.close();
            throw new IOException();
        }
        scanner.close();
        return text;
    }

    public static String readAsString3(
            InputStream inputStream,
            Charset charset) throws IOException {
        return new String(inputStream.readAllBytes(), charset);
    }

}
