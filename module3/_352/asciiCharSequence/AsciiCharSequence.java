/*
 Напишите класс AsciiCharSequence, реализующий компактное хранение
 последовательности ASCII-символов (их коды влезают в один байт)
 в массиве байт.
 По сравнению с классом String, хранящим каждый символ как char,
 AsciiCharSequence будет занимать в два раза меньше памяти.

Класс AsciiCharSequence должен:
    реализовывать интерфейс java.lang.CharSequence;
    иметь конструктор, принимающий массив байт;
    определять методы length(), charAt(), subSequence() и toString()
    
https://stepik.org/lesson/14513/step/8?unit=4147
 */
package module3._352.asciiCharSequence;

import java.util.Arrays;

public class AsciiCharSequence implements CharSequence {
    private byte[] bytes;

    public AsciiCharSequence(byte[] bytes) {
        this.bytes = Arrays.copyOf(bytes, bytes.length);
    }

    @Override
    public int length() {
        return bytes.length;
    }

    @Override
    public char charAt(int index) {
        return (char) bytes[index];
    }

    @Override
    public AsciiCharSequence subSequence(int start, int end) {
        byte[] subSequence = Arrays.copyOfRange(bytes, start, end);
        return new AsciiCharSequence(subSequence);
    }

    @Override
    public String toString() {
        return new String(bytes);
    }
    
    
}