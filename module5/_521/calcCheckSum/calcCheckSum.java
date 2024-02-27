package module5._521.calcCheckSum;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class calcCheckSum {
    public static void main(String[] args) {
        byte[] bytes = { 0x33, 0x45, 0x01 };
        InputStream inputStream = new ByteArrayInputStream(bytes);
        try {
            System.out.println(checkSumOfStream(inputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }       
    }

    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int r;
        int sum = 0;
        while ((r = inputStream.read()) > -1) {
            sum = Integer.rotateLeft(sum, 1) ^ r;
        }
        return sum;
    }
}
