package module5._531.readAsString;

import static module5._531.readAsString.ReadAsString.readAsString;
import static module5._531.readAsString.ReadAsString.readAsString1;
import static module5._531.readAsString.ReadAsString.readAsString2;
import static module5._531.readAsString.ReadAsString.readAsString3;
import static org.junit.Assert.assertArrayEquals;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ReadAsStringTest {
    private static final Charset ASCII = StandardCharsets.US_ASCII;
    private static final Charset UTF8 = StandardCharsets.UTF_8;
    private static final Charset UTF16 = StandardCharsets.UTF_16;

    @ParameterizedTest
    @MethodSource("provideParams")
    void testReadAsString(InputStream inputStream,
            Charset charset,
            byte[] expected) throws UnsupportedEncodingException, IOException {
        assertArrayEquals(expected,
                readAsString(inputStream, charset)
                        .getBytes(charset.name()));
    }

    @ParameterizedTest
    @MethodSource("provideParams")
    void testReadAsString1(InputStream inputStream,
            Charset charset,
            byte[] expected) throws UnsupportedEncodingException, IOException {
        assertArrayEquals(expected,
                readAsString1(inputStream, charset)
                        .getBytes(charset.name()));
    }

    @ParameterizedTest
    @MethodSource("provideParams")
    void testReadAsString2(InputStream inputStream,
            Charset charset,
            byte[] expected) throws UnsupportedEncodingException, IOException {
        assertArrayEquals(expected,
                readAsString2(inputStream, charset)
                        .getBytes(charset.name()));
    }

    @ParameterizedTest
    @MethodSource("provideParams")
    void testReadAsString3(InputStream inputStream,
            Charset charset,
            byte[] expected) throws UnsupportedEncodingException, IOException {
        assertArrayEquals(expected,
                readAsString3(inputStream, charset)
                        .getBytes(charset.name()));
    }

    public static Stream<Arguments> provideParams() {
        return Stream.of(
                Arguments.of(
                        new ByteArrayInputStream("01\r\n23".getBytes(ASCII)),
                        ASCII,
                        "01\r\n23".getBytes(ASCII)),
                Arguments.of(
                        new ByteArrayInputStream("фывааа!".getBytes(UTF8)),
                        UTF8,
                        "фывааа!".getBytes(UTF8)),
                Arguments.of(
                        new ByteArrayInputStream("".getBytes(ASCII)),
                        ASCII,
                        "".getBytes(ASCII)),
                Arguments.of(
                        new ByteArrayInputStream("Ɇɷи¶".getBytes(UTF8)),
                        UTF8,
                        "Ɇɷи¶".getBytes(UTF8)),
                Arguments.of(
                        new ByteArrayInputStream("Ћ\t\n".getBytes(UTF16)),
                        UTF16,
                        "Ћ\t\n".getBytes(UTF16)));
    }
}
